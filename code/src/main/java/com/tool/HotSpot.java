package com.tool;

import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.session.SqlSession;
import org.apdplat.word.WordSegmenter;
import org.apdplat.word.segmentation.SegmentationAlgorithm;
import org.apdplat.word.segmentation.Word;

import java.io.*;
import java.net.URI;
import java.util.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


/**
 * Created by Amadeus on 2018/5/10.
 */
public class HotSpot {
    private Map<String, Integer> hotspot = new HashMap<String, Integer>();
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
    public void seg(String text, SegmentationAlgorithm segmentationAlgorithm) {
        List<String> result = new ArrayList<String>();
        for(Word word : WordSegmenter.segWithStopWords(text, segmentationAlgorithm)){
            String rst = word.getText();
            if (hotspot.containsKey(rst)){
                hotspot.put(rst, hotspot.get(rst) + 1);
            }else {
                hotspot.put(rst, 1);
            }
        }
    }

    //    对结果进行排序,并返回结果
    public void excute(){
        List<String> words = getHotWords();
        List<String> temp = new ArrayList<>();
        String word = StringUtils.join(words.toArray(), ",");
        seg(word, SegmentationAlgorithm.BidirectionalMaximumMatching);
        hotspot = MapSorter.sortMapByValue(hotspot);//map排序起
        int i = 0;
        for(String key : hotspot.keySet()){
            if (i==5) break;
            temp.add(key);
            i++;
        }
        try {
            saveRtn(temp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void initHotSpot() {//每隔十分钟查询一次数据
        Runnable runnable = new Runnable() {
            public void run() {
                excute();
            }
        };
        ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
        // 参数：1、任务体 2、首次执行的延时时间
        //      3、任务执行间隔 4、间隔时间单位
        service.scheduleAtFixedRate(runnable, 0, 60, TimeUnit.SECONDS);
    }

    public void saveRtn(List<String> temp) throws Exception{
        File file = new File(new URI(HotSpot.class.getResource("/data/hotspot.txt").toString()));
        BufferedWriter bw=new BufferedWriter(new FileWriter(file));
        for(int i=0;i<temp.size();i++){
            bw.write(temp.get(i));
            bw.newLine();
        }
        bw.close();
    }

    public static List<String> loadRtn(){
        List<String> list = new ArrayList<String>();
        try {

            String encoding="UTF-8";
            File file = new File(new URI(HotSpot.class.getResource("/data/hotspot.txt").toString()));
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
