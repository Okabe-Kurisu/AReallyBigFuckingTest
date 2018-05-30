package com.action;

import com.DAO.BlogDao;
import com.DAO.UserDao;
import com.annotations.Authority;
import com.google.gson.Gson;
import com.model.*;
import com.opensymphony.xwork2.ActionSupport;
import com.tool.PowerfulTools;
import com.tool.SensitivewordFilter;
import org.apache.struts2.components.Date;
import org.apache.struts2.convention.annotation.*;
import org.apache.struts2.interceptor.ServletRequestAware;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 关于博客的action
 *
 * @author Zhongxu Fan
 * @create 2018-03-25 19:18
 **/

@Namespace("/blog")
@ParentPackage("custom-default")
@Results({@Result(name = ActionSupport.SUCCESS, type = "json", params = {"root", "resultMap"}),
        @Result(name = ActionSupport.ERROR, type = "json", params = {"root", "resultMap"}),
        @Result(name = "login", type = "json", params = {"root", "resultMap"})})
public class BlogAction extends ActionSupport implements ServletRequestAware {

    HttpServletRequest request;

    String message;

    Map<String, Object> resultMap;

    @Action(value = "submitBlog")
    @Authority("")
    public String submitBlog() {//提交微博
        Blog blog = new Blog();
        SensitivewordFilter filter = new SensitivewordFilter();

        String release_time, multimedia, content1;
        int user_id, visibility, is_showName;
        HttpSession session = request.getSession();
        //从前端获取
        //user_id = Integer.parseInt((String) session.getAttribute("user_id"));
        content1 = request.getParameter("content");
        release_time = request.getParameter("release_time");
        String visiStr = request.getParameter("visibility");
        if (visiStr == null || "".equals(visiStr)) visiStr = "0";
        visibility = Integer.parseInt(visiStr);
        multimedia = request.getParameter("multimedia");
        String isStr = request.getParameter("is_showName");
        if (isStr == null || "".equals(isStr)) isStr = "0";
        is_showName = Integer.parseInt(isStr);
        try {
            //获得当前登录用户
            User user = (User) request.getSession().getAttribute("user");
            user_id = user.getUid();

            Set<String> set = filter.getSensitiveWord(content1, 1);

            if (release_time == null || "".equals(release_time)) {
                blog.setRelease_time((int) (System.currentTimeMillis() / 1000));
            } else {
                blog.setRelease_time(Integer.parseInt(release_time));
            }

            if (multimedia == null || "".equals(multimedia)) {
                blog.setMultimedia("");
            } else {
                blog.setMultimedia(multimedia);
            }
            blog.setUser_id(user_id);
            blog.setContentO(content1);
            blog.setVisibility(visibility);
            blog.setIs_showName(is_showName);
            //后台添加
            String userAgent = request.getHeader("user-agent");//获取浏览器信息
            String ip = UserAtion.getIpAddr(request);//获取IP地址
            blog.setBrowser_sign(userAgent);
            blog.setIp_address(ip);
            blog.setComment_on(0);
            blog.setType(0);
            blog.setIs_edit(0);

            int bid = BlogDao.insertBlog(blog);

            if (set.size() > 0) {
                System.out.println("提交微博存在敏感词");
                Sensitivity Sensitivity_blog = new Sensitivity();
                Sensitivity_blog.setBlog_id(bid);
                Sensitivity_blog.setDetails("");
                Sensitivity_blog.setType(0);
                Sensitivity_blog.setTime((int) (System.currentTimeMillis() / 1000));
                BlogDao.reportBlog(Sensitivity_blog);
            }
            // 封装响应数据
            Map map = new HashMap();
            map.put("data", BlogDao.getBlogById(bid));
            resultMap = PowerfulTools.format("200", "发布成功", map);
        } catch (NullPointerException ne) {
            ne.printStackTrace();
            resultMap = PowerfulTools.format("101", "内容为空或者过长", null);
        }
        return SUCCESS;
    }

    @Action(value = "setBlog")
    @Authority("")
    public String setBlog() {//修改微博
        Blog blog = new Blog();
        String release_time, multimedia, content;
        SensitivewordFilter filter = new SensitivewordFilter();
        int bid, visibility, user_id, is_showName;
        //从前端获取
        bid = Integer.parseInt(request.getParameter("bid"));

        //获得当前登录用户

        User user = (User) request.getSession().getAttribute("user");
        user_id = user.getUid();
        content = request.getParameter("content");
        release_time = request.getParameter("release_time");
        multimedia = request.getParameter("multimedia");
        String visiStr = request.getParameter("visibility");
        if (visiStr == null || "".equals(visiStr)) visiStr = "0";
        visibility = Integer.parseInt(visiStr);

        String isStr = request.getParameter("is_showName");
        if (isStr == null || "".equals(isStr)) isStr = "0";
        is_showName = Integer.parseInt(isStr);
        try {
            if (BlogDao.checkAdmin(user_id) != 0) {
                // 封装响应数据
                resultMap = PowerfulTools.format("101", "该账户被封", user);
                System.out.print("该账户被封");
                return SUCCESS;
            }
            if (BlogDao.SetBlogNum(bid) != 0) {
                // 封装响应数据
                resultMap = PowerfulTools.format("101", "该博客今日修改次数达到上限（5次）", user);
                System.out.print("该博客今日修改次数达到上限(5次)");
                return SUCCESS;
            }
            if (release_time == null || "".equals(release_time)) {
                blog.setRelease_time((int) (System.currentTimeMillis() / 1000));
            } else {
                blog.setRelease_time(Integer.parseInt(release_time));
            }

            if (multimedia == null || "".equals(multimedia)) {
                blog.setMultimedia("");
            } else {
                blog.setMultimedia(multimedia);
            }
            Set<String> set = filter.getSensitiveWord(content, 1);
            if (set.size() > 0) {
                System.out.println("修改微博存在敏感词");
                Sensitivity Sensitivity_blog = new Sensitivity();
                Sensitivity_blog.setBlog_id(bid);
                Sensitivity_blog.setDetails("");
                Sensitivity_blog.setType(0);
                Sensitivity_blog.setTime((int) (System.currentTimeMillis() / 1000));
                BlogDao.reportBlog(Sensitivity_blog);

            }

            blog.setBid(bid);
            blog.setContent(content);
            blog.setVisibility(visibility);
            blog.setIs_showName(is_showName);

            //后台添加
            String userAgent = request.getHeader("user-agent");//获取浏览器信息
            String ip = request.getHeader("X-Forwarded-For");//获取IP地址
            blog.setBrowser_sign(userAgent);
            System.out.print("------------------user_id:" + user_id);
            System.out.print("------------------ip address:" + ip);
            blog.setIp_address(ip);
            blog.setComment_on(0);
            blog.setType(0);
            blog.setIs_edit(1);

            BlogDao.setBlog(blog);
            // 封装响应数据
            resultMap = PowerfulTools.format("200", "修改成功", user);

        } catch (NullPointerException ne) {
            ne.printStackTrace();
            resultMap = PowerfulTools.format("101", "内容为空或者过长", null);
        }
        return SUCCESS;
    }

    @Action(value = "delBlog")
    @Authority("")
    public String delBlog() {
        int bid;
        User user = (User) request.getSession().getAttribute("user");
        bid = Integer.parseInt(request.getParameter("bid"));
        try {
            BlogDao.delBlog(bid);
            resultMap = PowerfulTools.format("200", "删除成功", user);
        } catch (NullPointerException ne) {
            ne.printStackTrace();
        }
        return SUCCESS;
    }

    @Action(value = "commitBlog", results = {
            @Result(name = "success", type = "json", params = {"root", "resultMap"}),
            @Result(name = "error", type = "json", params = {"root", "resultMap"}),
            @Result(name = "login", type = "json", params = {"root", "resultMap"})
    })
    @Authority("")
    public String commit() {//评论微博
        Blog blog = new Blog();
        String release_time, multimedia, content1;
        int user_id, visibility, is_showName, Commentid;
        SensitivewordFilter filter = new SensitivewordFilter();

        //从前端获取
        Commentid = Integer.parseInt(request.getParameter("bid"));
        content1 = request.getParameter("content");

        try {
            //获得当前登录用户
            User user = (User) request.getSession().getAttribute("user");
            user_id = user.getUid();
            //查看用户是否被封
            if (BlogDao.checkAdmin(user_id) != 0) {
                // 封装响应数据
                resultMap = PowerfulTools.format("101", "该账户被封", user);
                System.out.print("该账户被封");
                return LOGIN;
            }
            if (content1 == null || "".equals(content1)) {
                // 封装响应数据
                resultMap = PowerfulTools.format("101", "评论不能空", user);
                System.out.print("评论为空");
                return ERROR;
            }
            release_time = request.getParameter("release_time");
            String visiStr = request.getParameter("visibility");
            if (visiStr == null || "".equals(visiStr)) visiStr = "0";
            visibility = Integer.parseInt(visiStr);
            multimedia = request.getParameter("multimedia");
            String isStr = request.getParameter("is_showName");
            if (isStr == null || "".equals(isStr)) isStr = "0";
            is_showName = Integer.parseInt(isStr);
            Set<String> set = filter.getSensitiveWord(content1, 1);
            if (release_time == null || "".equals(release_time)) {
                blog.setRelease_time((int) (System.currentTimeMillis() / 1000));
            } else {
                blog.setRelease_time(Integer.parseInt(release_time));
            }
            if (multimedia == null || "".equals(multimedia)) {
                blog.setMultimedia("");
            } else {
                blog.setMultimedia(multimedia);
            }
            if (Commentid != 0) {
                blog.setComment_on(Commentid);
            }
            blog.setUser_id(user_id);
            blog.setContentO(content1);
            blog.setVisibility(visibility);
            blog.setIs_showName(is_showName);
            //后台添加
            String userAgent = request.getHeader("user-agent");//获取浏览器信息
            String ip = UserAtion.getIpAddr(request);//获取IP地址
            blog.setBrowser_sign(userAgent);
            blog.setIp_address(ip);
            blog.setType(2);
            blog.setIs_edit(0);

            int bid = BlogDao.commit(blog);

            if (set.size() > 0) {
                System.out.println("提交评论存在敏感词");
                Sensitivity Sensitivity_blog = new Sensitivity();
                Sensitivity_blog.setBlog_id(bid);
                Sensitivity_blog.setDetails("");
                Sensitivity_blog.setType(0);
                Sensitivity_blog.setTime((int) (System.currentTimeMillis() / 1000));
                BlogDao.reportBlog(Sensitivity_blog);
            }
            // 封装响应数据
            resultMap = PowerfulTools.format("200", "发布成功", user);
        } catch (NullPointerException ne) {
            ne.printStackTrace();
            resultMap = PowerfulTools.format("101", "内容为空或者过长", null);
        }
        return SUCCESS;
    }

    @Action(value = "thumbUp")
    @Authority("")
    public String thumbUp() {//点赞微博
        ThumbUp thumbup = new ThumbUp();
        int user_id, bid;
        //从前端获取
        User user = (User) request.getSession().getAttribute("user");
        user_id = user.getUid();
        bid = Integer.parseInt(request.getParameter("bid"));
        try {

            thumbup.setUser_id(user_id);
            thumbup.setBlog_id(bid);
            //获得被点赞人的id
            thumbup.setT_id(BlogDao.getUidByBid(bid));
            //后台添加
            thumbup.setDate((int) (System.currentTimeMillis() / 1000));
            BlogDao.thumbUp(thumbup);
            // 封装响应数据
            resultMap = PowerfulTools.format("200", "点赞成功", user);

        } catch (NullPointerException ne) {
            ne.printStackTrace();
            resultMap = PowerfulTools.format("101", "点赞失败", user);
        }
        return SUCCESS;
    }

    @Action(value = "forwardBlog")
    @Authority("")
    public String forwardBlog() {//转发微博
        Blog blog = new Blog();
        SensitivewordFilter filter = new SensitivewordFilter();

        String content1;
        int user_id, Commentid, bid;
        //从前端获取
        Commentid = Integer.parseInt(request.getParameter("bid"));
        content1 = request.getParameter("content");

        if (content1 == null && "".equals(content1)) content1 = "";

        try {
            //获得当前登录用户
            User user = (User) request.getSession().getAttribute("user");
            user_id = user.getUid();
            if (BlogDao.checkAdmin(user_id) != 0) {
                // 封装响应数据
                resultMap = PowerfulTools.format("101", "该账户被封", user);
                return LOGIN;
            }
            String userAgent = request.getHeader("user-agent");//获取浏览器信息
            String ip = UserAtion.getIpAddr(request);//获取IP地址
            blog.setBrowser_sign(userAgent);
            blog.setIp_address(ip);
            blog.setComment_on(Commentid);
            blog.setContent(content1);
            blog.setUser_id(user_id);
            blog.setType(1);
            blog.setMultimedia("");
            blog.setVisibility(0);
            blog.setIs_edit(0);
            blog.setRelease_time((int) (System.currentTimeMillis()/1000));

            Set<String> set = filter.getSensitiveWord(content1, 1);
            //后台添加
            bid = BlogDao.forwordBlog(blog);

            if (set.size() > 0) {
                System.out.println("转发评论存在敏感词");
                Sensitivity Sensitivity_blog = new Sensitivity();
                Sensitivity_blog.setBlog_id(bid);
                Sensitivity_blog.setDetails("");
                Sensitivity_blog.setType(0);
                Sensitivity_blog.setTime((int) (System.currentTimeMillis() / 1000));
                BlogDao.reportBlog(Sensitivity_blog);
            }
            resultMap = PowerfulTools.format("200", "转发成功", BlogDao.getBlogById(bid));
            System.out.println(resultMap);
        } catch (NullPointerException ne) {
            ne.printStackTrace();
            resultMap = PowerfulTools.format("101", "内容为空或者过长", null);
        }
        return SUCCESS;
    }

    @Action(value = "searchBlog")
    public String searchBlog() {
        String keyword, userid, pageNum, pageCap;
        long nowtime;
        Map<String, Object> map = new HashMap();
        try {
            // 获得参数
            keyword = request.getParameter("keyword");
            userid = request.getParameter("uid");
            System.out.println(keyword);
            // 获得当前时间戳
            nowtime = new java.util.Date().getTime() / 1000;
            map.put("userid", userid);
            map.put("keyword", keyword);
            map.put("nowtime", nowtime);
            // 调用Dao层 获取数据
            List blogList = BlogDao.getBlogByKeyword(map);

            // 写入搜索记录(用户登陆状态下)
            if (userid != null && !"".equals(userid)) BlogDao.insertSearchBlog(map);

            // 封装响应数据
            resultMap = PowerfulTools.format("200", "成功", blogList);


        } catch (NullPointerException ne) {
            ne.printStackTrace();
            resultMap = PowerfulTools.format("500", "系统异常", null);
        }
        return SUCCESS;
    }

    @Action(value = "selectBlogByTime")
    public String selectBlogByTime() {
        int nowtime;
        Map<String, Object> map = new HashMap();
        //1527122341  1527104341
        try {
            // 获得前3小时的时间戳
            /*SimpleDateFormat dft = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            java.util.Date beginDate = new java.util.Date();
            Calendar date = Calendar.getInstance();
            date.setTime(beginDate);
            date.set(Calendar.HOUR_OF_DAY, date.get(Calendar.HOUR_OF_DAY) - 5);
            java.util.Date endDate = dft.parse(dft.format(date.getTime()));
            nowtime = (int) endDate.getTime();
            System.out.println(nowtime);*/
            int sevenDay = 7 * 24 * 3600;
            nowtime = ((int) (System.currentTimeMillis() / 1000)) - sevenDay;

            // 封装参数
            map.put("release_time", nowtime);
            // 调用Dao层 获取数据
            List blogList = BlogDao.selectBlogByTime(map);

            // 封装响应数据
            resultMap = PowerfulTools.format("200", "成功", blogList);


        } catch (Exception ne) {
            ne.printStackTrace();
            resultMap = PowerfulTools.format("500", "系统异常", null);
        }
        return SUCCESS;
    }


    @Action(value = "getFiveDiscuss", results = {//#话题获得5个话题
            @Result(name = "success", type = "json", params = {"root", "resultMap"})
    })
    public String getFiveDiscuss() {
        String name;
        int nowtime;
        Map<String, Object> map = new HashMap();

        try {
            name = request.getParameter("name");
            if (null == name) name = "";
            nowtime = ((int) (System.currentTimeMillis() / 1000));
            Map<String, Object> maps = new HashMap<String, Object>();
            maps.put("name", name);
            maps.put("NowTime", nowtime);
            List<Discuss> DiscussList = BlogDao.selectDiscuss(maps);
            resultMap = PowerfulTools.format("200", "获取话题", DiscussList);

        } catch (NullPointerException ne) {
            ne.printStackTrace();
            resultMap = PowerfulTools.format("500", "系统异常", null);

        }
        return SUCCESS;
    }

    @Action(value = "addDisBlog")//将#话题添加到表中
    public String addDisBlog() {
        int blog_id, discuss_id, user_id;
        BlogDiscuss bd = new BlogDiscuss();
        //从前端获取
        User user = (User) request.getSession().getAttribute("user");
        user_id = user.getUid();
        discuss_id = Integer.parseInt(request.getParameter("discuss_id"));
        blog_id = Integer.parseInt(request.getParameter("blog_id"));
        try {
            bd.setBlog_id(blog_id);
            bd.setDiscuss_id(discuss_id);
            bd.setUser_id(user_id);
            BlogDao.addDisBlog(bd);
            resultMap = PowerfulTools.format("200", "#话题添加成功", user);

        } catch (NullPointerException ne) {
            ne.printStackTrace();
            resultMap = PowerfulTools.format("500", "系统异常", user);
        }
        return SUCCESS;
    }

    @Action(value = "collectBlog")
    @Authority("")
    public String collectBlog() {//收藏微博
        Favorite Favorite_blog = new Favorite();
        int user_id, bid, fid;
        //从前端获取
        bid = Integer.parseInt(request.getParameter("bid"));
        try {
            //获得当前登录用户
            User user = (User) request.getSession().getAttribute("user");
            user_id = user.getUid();
            /*if (user_id==0||"".equals(user_id)) {
                // 封装响应数据
                resultMap = PowerfulTools.format("101", "请登录", user);

                return LOGIN;
            }*/

            if (BlogDao.checkAdmin(user_id) != 0) {
                // 封装响应数据
                resultMap = PowerfulTools.format("101", "该账户被封", user);
                System.out.print("该账户被封");
                return LOGIN;
            }

            Favorite_blog.setUser_id(user_id);
            Favorite_blog.setBlog_id(bid);
            Favorite_blog.setTime((int) (System.currentTimeMillis() / 1000));
            Favorite_blog.setVisibility(0);

            fid = BlogDao.collectBlog(Favorite_blog);
            if (fid == 0) {
                // 封装响应数据
                resultMap = PowerfulTools.format("200", "取消收藏成功", user);
            } else {
                // 封装响应数据
                resultMap = PowerfulTools.format("200", "收藏成功", user);
            }

        } catch (NullPointerException ne) {
            ne.printStackTrace();
            resultMap = PowerfulTools.format("101", "异常", null);
        }
        return SUCCESS;
    }

    @Action(value = "reportBlog")
    @Authority("")
    public String reportBlog() {//举报微博
        Sensitivity Sensitivity_blog = new Sensitivity();
        String details, type;
        int bid, user_id;
        //从前端获取
        bid = Integer.parseInt(request.getParameter("bid"));
        type = request.getParameter("type");
        details = request.getParameter("details");
        try {
            //获得当前登录用户
            User user = (User) request.getSession().getAttribute("user");
            user_id = user.getUid();
            if (BlogDao.checkAdmin(user_id) != 0) {
                // 封装响应数据
                resultMap = PowerfulTools.format("101", "该账户被封", user);
                System.out.print("该账户被封");
                return LOGIN;
            }
            if (details == null && "".equals(details)) {
                Sensitivity_blog.setDetails(type);
            } else {
                Sensitivity_blog.setDetails(type + details);
            }
            Sensitivity_blog.setBlog_id(bid);
            Sensitivity_blog.setType(0);
            Sensitivity_blog.setTime((int) (System.currentTimeMillis() / 1000));
            Sensitivity_blog.setUser_id(user_id);
            Sensitivity_blog.setVisibility(0);
            BlogDao.reportBlog(Sensitivity_blog);
            // 封装响应数据
            resultMap = PowerfulTools.format("200", "举报成功", user);

        } catch (NullPointerException ne) {
            ne.printStackTrace();
            resultMap = PowerfulTools.format("101", "举报失败", null);
        }
        return SUCCESS;
    }


    @Action(value = "getFollowBlog")
    public String getFollowBlog() {
        String userid;
        Map<String, Object> map = new HashMap();
        try {
            // 获得参数
            userid = request.getParameter("userid");

            // 封装参数
            map.put("userid", userid);

            // 调用Dao层 获取数据
            List blogList = BlogDao.getFollowBlogByUserid(map);
            System.out.println("得到了用户关注的各种微博" + blogList.size());

            // 封装响应数据
            resultMap = PowerfulTools.format("200", "成功", blogList);


        } catch (NullPointerException ne) {
            ne.printStackTrace();
            resultMap = PowerfulTools.format("500", "系统异常", null);
        }
        return SUCCESS;
    }


    @Action(value = "getHotspot")
    public String getHotspot() {

        Map<String, Object> map = new HashMap();
        try {
            // 调用Dao层 获取数据
            int nowtime = (int) (System.currentTimeMillis() / 1000 - 24 * 3600);

            map.put("nowtime", nowtime);
            List blogList = BlogDao.getTodayHostBlog(map);

            System.out.println("list集合大小：" + blogList.size());

            // 对今日微博进行热点排序
            blogList.sort((Comparator<Map<String, Object>>) (o1, o2) -> {
                float f1 = PowerfulTools.HotBlogSort(o1.get("likeNum"), o1.get("reshareNum"), o1.get("commentNum"));
                float f2 = PowerfulTools.HotBlogSort(o2.get("likeNum"), o2.get("reshareNum"), o2.get("commentNum"));
                return (f1 > f2) ? -1 : 1;
            });

            // 封装响应数据
            resultMap = PowerfulTools.format("200", "成功", blogList);


        } catch (NullPointerException ne) {
            ne.printStackTrace();
            resultMap = PowerfulTools.format("500", "系统异常", null);
        }
        return SUCCESS;
    }

    @Action(value = "getUserBlog")
    public String getUserBlog() {
        Map<String, Object> map = new HashMap();
        try {
            int uid = Integer.parseInt(request.getParameter("uid"));
            List blogList = BlogDao.getUserBlog(uid);
            resultMap = PowerfulTools.format("200", "成功", blogList);

        } catch (NullPointerException ne) {
            ne.printStackTrace();
            resultMap = PowerfulTools.format("500", "系统异常", null);
        }
        return SUCCESS;
    }

    @Action(value = "getBlogById")
    public String getBlogById() {
        int bid;
        try {
            // 获得参数
            bid = Integer.parseInt(request.getParameter("bid"));
            Map data = BlogDao.getBlogById(bid);
            // 封装响应数据
            resultMap = PowerfulTools.format("200", "成功", data);

        } catch (NullPointerException ne) {
            ne.printStackTrace();
            resultMap = PowerfulTools.format("500", "系统异常", null);
        }
        return SUCCESS;
    }

    @Action(value = "getFavorite")
    public String getFavorite() {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        int uid = user.getUid();
        try {
            resultMap = PowerfulTools.format("200", "成功", BlogDao.getFavorite(uid));

        } catch (NullPointerException ne) {
            ne.printStackTrace();
            resultMap = PowerfulTools.format("500", "系统异常", null);
        }
        return SUCCESS;
    }

    @Action(value = "getCallat")
    public String getCallat() {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        int uid = user.getUid();
        try {
            resultMap = PowerfulTools.format("200", "成功", BlogDao.getCallat(uid));

        } catch (NullPointerException ne) {
            ne.printStackTrace();
            resultMap = PowerfulTools.format("500", "系统异常", null);
        }
        return SUCCESS;
    }

    @Action(value = "getCommitById")
    public String getCommitById() {
        int bid;
        try {
            // 获得参数
            bid = Integer.parseInt(request.getParameter("bid"));
            List<Map> data = BlogDao.getCommitById(bid);
            // 封装响应数据
            resultMap = PowerfulTools.format("200", "成功", data);

        } catch (NullPointerException ne) {
            ne.printStackTrace();
            resultMap = PowerfulTools.format("500", "系统异常", null);
        }
        return SUCCESS;
    }


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Map<String, Object> getResultMap() {
        return resultMap;
    }

    public void setResultMap(Map<String, Object> resultMap) {
        this.resultMap = resultMap;
    }

    @Override
    public void setServletRequest(javax.servlet.http.HttpServletRequest request) {
        this.request = request;
    }
}
