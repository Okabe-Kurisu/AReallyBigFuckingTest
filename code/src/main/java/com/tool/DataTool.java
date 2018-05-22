package com.tool;

import com.DAO.BlogDao;
import com.DAO.UserDao;
import org.ansj.domain.Term;
import org.ansj.splitWord.analysis.NlpAnalysis;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.session.SqlSession;


import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


/**
 * Created by Amadeus on 2018/5/10.
 */
public class DataTool {
    private Map<String, Integer> hotspot = new HashMap<String, Integer>();
    public static enum Type {
        HotSPot("/data/hotspot.txt");
        String path;
        Type(String path) {this.path = path;}
        public String getPath() {return path;}
    }
    //热词部分
    public List<String> getHotWords(){
        SqlSession sqlSession = MybatisTool.getSqlSession();
        List<String> hotWords = null;
        int date = (int) System.currentTimeMillis()/1000;
        date -= 7*24*3600;
        try {
            hotWords = sqlSession.selectList("weibo/SearchLogMapper.selectSearchLog", date);
        } finally {
            sqlSession.close();
        }
        return hotWords;
    }

    //    對得到的搜索记录进行分词，并且放入map中,统计出现次数
    public void seg(String text) {
        for(Term term : NlpAnalysis.parse(text)){
            String rst = term.getName();
            if (hotspot.containsKey(rst)){
                hotspot.put(rst, hotspot.get(rst) + 1);
            }else {
                hotspot.put(rst, 1);
            }
        }
    }



    public void initHotSpot() {//每隔一分钟查询一次数据
        Runnable runnable = new Runnable() {
            public void run() {
                int startTime = (int) System.currentTimeMillis()/1000;
                List<String> words = getHotWords();
                List<String> temp = new ArrayList<>();
                String word = StringUtils.join(words.toArray(), "");
                seg(word);
                hotspot = MapSorter.sortMapByValue(hotspot);//map排序起
                int i = 0;
                for(String key : hotspot.keySet()){
                    if (i==5) break;
                    temp.add(key);
                    i++;
                }
                int endTime = (int) System.currentTimeMillis()/1000;
                saveRtn(temp,Type.HotSPot.getPath());
            }
        };
        ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
        // 参数：1、任务体 2、首次执行的延时时间
        //      3、任务执行间隔 4、间隔时间单位
        service.scheduleAtFixedRate(runnable, 0, 60, TimeUnit.SECONDS);
    }

    //用户权重分析部分
    public static void analUserWeight() {
        //todo：只对有变动用户进行分析
        System.out.println("权重分析开始");
        Map<String, Object> map = new HashMap();
        List<Map> userList = UserDao.getAllUser();
        for(Map user: userList){
            int weight = 0;
            weight += Integer.valueOf(user.get("follerNum").toString())/5
                    + Integer.valueOf(user.get("likeNum").toString())/10
                    + Integer.valueOf(user.get("forwardNum").toString())/5;
            int nowdate = (int) System.currentTimeMillis()/1000;
            int leftDays = ((int) user.get("last_logtime") - nowdate)/3600;
            weight -= leftDays * 5;
            user.put("weight", weight);
            if (weight != (int) user.get("weight")){
                System.out.println("用户:" + user.get("nickname") + "的权重更新为" + weight);
            }
            UserDao.setWeight(user);
        }
        System.out.println("权重分析结束");
    }

    public void initAUW() {//每隔1小时重置一次权重
        Runnable runnable = new Runnable() {
            public void run() {
                analUserWeight();
            }
        };
        ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
        // 参数：1、任务体 2、首次执行的延时时间
        //      3、任务执行间隔 4、间隔时间单位
        service.scheduleAtFixedRate(runnable, 0, 1, TimeUnit.HOURS);
    }

    //统计用户构成
    //用户关键词提取,并加权存储,然后返回排名前十的关键词
    public List<String> segKeyword(List<Map> contents) {
        Map<String, Integer> userkey = new HashMap<String, Integer>();
        List<String> temp = new ArrayList();
        //只提取名词
        Set<String> expectedNature = new HashSet<String>() {{
            add("n");add("vn");add("ng");add("q");add("wh");
            add("nt");add("nz");add("nw");add("nl");
        }};
        for (Map map: contents){
            String text = map.get("content").toString();
            for(Term term : NlpAnalysis.parse(text)){
                if (expectedNature.contains(term.getNatureStr()) )
                    continue;
                String rst = term.getName();
                int weight = (int) map.get("weight");
                if (userkey.containsKey(rst)){
                    userkey.put(rst, userkey.get(rst) + weight);
                }else {
                    userkey.put(rst, weight);
                }
            }
        }
        userkey = MapSorter.sortMapByValue(userkey);//map排序起
        for (String key: userkey.keySet()){
            if (temp.size() > 10)
                break;
            temp.add(key);
        }
        return temp;
    }


    //工具方法
    public void saveRtn(List<String> temp, String filename){
        BufferedWriter bw = null;
        try {
            String encoding = "UTF-8";
            File file = new File(new URI(DataTool.class.getResource(filename).toString()));
            bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file,false), encoding));
            for(int i=0;i<temp.size();i++){
                bw.write(temp.get(i));
                bw.newLine();
            }
            bw.flush();
            bw.close();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<String> loadRtn(String filename){
        List<String> list = new ArrayList<String>();
        try {

            String encoding="UTF-8";
            File file = new File(new URI(DataTool.class.getResource(filename).toString()));
            //判断文件是否存在
            if(file.isFile() && file.exists()){
                //考虑到编码格式
                InputStreamReader read = new InputStreamReader(new FileInputStream(file),encoding);
                BufferedReader bufferedReader = new BufferedReader(read);
                String lineTxt = null;
                //记录读取的数据文件的行数
                int count = 0;
                while((lineTxt = bufferedReader.readLine()) != null){
                    list.add(lineTxt);
                    count ++;
                }
                read.close();
            }else{
                System.out.println("找不到指定的文件");
            }
        } catch (Exception e) {
            System.out.println("读取文件内容出错");
            e.printStackTrace();
        }
        return list;
    }

}
