package com.action;

import com.DAO.BlogDao;
import com.annotations.Authority;
import com.google.gson.Gson;
import com.model.*;
import com.opensymphony.xwork2.ActionSupport;
import com.tool.PowerfulTools;
import com.tool.SensitivewordFilter;
import org.apache.struts2.components.Date;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
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
public class BlogAction extends ActionSupport implements ServletRequestAware {

    HttpServletRequest request;
    Map<String, Object> resultMap;
    String message;

    @Action(value = "submitBlog", results = {
            @Result(name = "success", type = "json", params = {"root", "resultMap"})
    })
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

            if (release_time == null||"".equals(release_time)) {
                blog.setRelease_time((int) (System.currentTimeMillis() / 1000));
            } else {
                blog.setRelease_time(Integer.parseInt(release_time));
            }

            if (multimedia == null||"".equals(multimedia)) {
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
            map.put("blog", BlogDao.getBlogById(bid));
            map.put("user", user);
            resultMap = PowerfulTools.format("200", "发布成功", map);
            System.out.println(resultMap);
        } catch (NullPointerException ne) {
            ne.printStackTrace();
            resultMap = PowerfulTools.format("101", "内容为空或者过长", null);
        }
        return SUCCESS;
    }

    @Action(value = "setBlog", results = {
            @Result(name = "success", type = "json", params = {"root", "resultMap"})
    })
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
            if (release_time == null||"".equals(release_time)) {
                blog.setRelease_time((int) (System.currentTimeMillis() / 1000));
            } else {
                blog.setRelease_time(Integer.parseInt(release_time));
            }

            if (multimedia == null||"".equals(multimedia)) {
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

    @Action(value = "delBlog", results = {
            @Result(name = "success", type = "json", params = {"root", "resultMap"})
    })
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
            resultMap = PowerfulTools.format("101", "内容为空或者过长", user);
        }
        return SUCCESS;
    }

    @Action(value = "commitBlog", results = {
            @Result(name = "success", type = "json", params = {"root", "resultMap"})
    })
    //@Authority("")
    public String commit() {//评论微博
        Blog blog = new Blog();
        SensitivewordFilter filter = new SensitivewordFilter();

        String release_time, multimedia, content1;
        int user_id, visibility, is_showName;
        //从前端获取
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

            if (release_time == null||"".equals(release_time)) {
                blog.setRelease_time((int) (System.currentTimeMillis() / 1000));
            } else {
                blog.setRelease_time(Integer.parseInt(release_time));
            }

            if (multimedia == null||"".equals(multimedia)) {
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
            blog.setType(2);
            blog.setIs_edit(0);

            int bid = BlogDao.insertBlog(blog);

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
            System.out.println(resultMap);
        } catch (NullPointerException ne) {
            ne.printStackTrace();
            resultMap = PowerfulTools.format("101", "内容为空或者过长", null);
        }
        return SUCCESS;
    }

    @Action(value = "thumbUp", results = {
            @Result(name = "success", type = "json", params = {"root", "resultMap"})
    })
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

    @Action(value = "forwardBlog", results = {
            @Result(name = "success", type = "json", params = {"root", "resultMap"})
    })
    @Authority("")
    public String forwardBlog() {//转发微博
        Blog blog = new Blog();
        int user_id, bid;
        //从前端获取
        User user = (User) request.getSession().getAttribute("user");
        user_id = user.getUid();
        bid = Integer.parseInt(request.getParameter("bid"));

        try {
            BlogDao.forwordBlog(bid, user_id);
            // 封装响应数据
            resultMap = PowerfulTools.format("200", "转发成功", user);

        } catch (NullPointerException ne) {
            ne.printStackTrace();
            resultMap = PowerfulTools.format("101", "转发失败", user);
        }
        return SUCCESS;
    }

    @Action(value = "searchBlog", results = {
            @Result(name = "success", type = "json", params = {"root", "resultMap"})
    })
    public String searchBlog() {
        String keyword, userid, pageNum, pageCap;
        long nowtime;
        Map<String, Object> map = new HashMap();
        try {
            // 获得参数
            keyword = request.getParameter("keyword");
            pageNum = request.getParameter("pageNum");
            pageCap = request.getParameter("pageCap");
            pageCap = request.getParameter("pageCap");
            userid = request.getParameter("userid");

            // 封装参数
            map.put("keyword", keyword);
            map.put("userid", userid);
            // 计算分页 开始项和结束项
            if (null == pageNum || "".equals(pageNum)) pageNum = "1";
            int pageN = Integer.parseInt(pageNum);
            int pageC = Integer.parseInt(pageCap);
            int startNum = (pageN - 1) * pageC;
            int endNum = pageN * pageC;
            map.put("startNum", startNum);
            map.put("endNum", endNum);
            // 获得当前时间戳
            nowtime = new java.util.Date().getTime() / 1000;
            map.put("nowtime", nowtime);
            // 调用Dao层 获取数据
            List blogList = BlogDao.getBlogByKeyword(map);

            // 写入搜索记录(用户登陆状态下)
            if (userid != null && !"".equals(userid)) BlogDao.insertSearchBlog(map);

            // 封装响应数据
            resultMap = PowerfulTools.format("200", "成功", blogList);

            // 转换为JSON字符串

        } catch (NullPointerException ne) {
            ne.printStackTrace();
            resultMap = PowerfulTools.format("500", "系统异常", null);
        }
        return SUCCESS;
    }

    @Action(value = "selectBlogByTime", results = {
            @Result(name = "success", type = "json", params = {"root", "resultMap"})
    })
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
            nowtime = ((int) (System.currentTimeMillis() / 1000)) - 18000;

            // 封装参数
            map.put("release_time", nowtime);
            // 调用Dao层 获取数据
            List blogList = BlogDao.selectBlogByTime(map);

            // 封装响应数据
            resultMap = PowerfulTools.format("200", "成功", blogList);

            // 转换为JSON字符串

        } catch (Exception ne) {
            ne.printStackTrace();
            resultMap = PowerfulTools.format("500", "系统异常", null);
        }
        return SUCCESS;
    }

    @Action(value = "collectBlog", results = {
            @Result(name = "success", type = "json", params = {"root", "resultMap"})
    })
    @Authority("")
    public String collectBlog() {//收藏微博
        Favorite Favorite_blog = new Favorite();
        int user_id, bid;
        //从前端获取
        user_id = Integer.parseInt(request.getParameter("user_id"));
        bid = Integer.parseInt(request.getParameter("bid"));

        try {
            Favorite_blog.setUser_id(user_id);
            Favorite_blog.setBlog_id(bid);
            BlogDao.collectBlog(Favorite_blog);
            // 封装响应数据
            resultMap = PowerfulTools.format("200", "收藏成功", null);

            // 转换为JSON字符串

        } catch (NullPointerException ne) {
            ne.printStackTrace();
            resultMap = PowerfulTools.format("101", "收藏失败", null);
        }
        return SUCCESS;
    }

    @Action(value = "reportBlog", results = {
            @Result(name = "success", type = "json", params = {"root", "resultMap"})
    })
    @Authority("")
    public String reportBlog() {//举报微博
        Sensitivity Sensitivity_blog = new Sensitivity();
        String details;
        int bid;
        //从前端获取
        bid = Integer.parseInt(request.getParameter("bid"));
        details = request.getParameter("details");
        try {
            if (details == null) {
                Sensitivity_blog.setDetails("");
            } else {
                Sensitivity_blog.setDetails(details);
            }
            Sensitivity_blog.setBlog_id(bid);
            Sensitivity_blog.setType(0);

            BlogDao.reportBlog(Sensitivity_blog);
            // 封装响应数据
            resultMap = PowerfulTools.format("200", "举报成功", null);

            // 转换为JSON字符串

        } catch (NullPointerException ne) {
            ne.printStackTrace();
            resultMap = PowerfulTools.format("101", "举报失败", null);
        }
        return SUCCESS;
    }


    @Action(value = "getFollowBlog", results = {
            @Result(name = "success", type = "json", params = {"root", "resultMap"})
    })
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

            // 封装响应数据
            resultMap = PowerfulTools.format("200", "成功", blogList);

            // 转换为JSON字符串

        } catch (NullPointerException ne) {
            ne.printStackTrace();
            resultMap = PowerfulTools.format("500", "系统异常", null);
        }
        return SUCCESS;
    }


    @Action(value = "getHotspot", results = {
            @Result(name = "success", type = "json", params = {"root", "resultMap"})
    })
    public String getHotspot() {

        Map<String, Object> map = new HashMap();
        try {
            // 调用Dao层 获取数据
            List blogList = BlogDao.getTodayHostBlog(map);

            // 对今日微博进行热点排序
            blogList.sort((Comparator<Map<String, Object>>) (o1, o2) -> {
                float f1 = PowerfulTools.HotBlogSort(o1.get("likeNum"), o1.get("reshareNum"), o1.get("commentNum"));
                float f2 = PowerfulTools.HotBlogSort(o2.get("likeNum"), o2.get("reshareNum"), o2.get("commentNum"));
                return (f1 > f2) ? -1 : 1;
            });

            // 封装响应数据
            resultMap = PowerfulTools.format("200", "成功", blogList);

            // 转换为JSON字符串

        } catch (NullPointerException ne) {
            ne.printStackTrace();
            resultMap = PowerfulTools.format("500", "系统异常", null);
        }
        return SUCCESS;
    }

    @Action(value = "getUserBlog")
    public String getUserBlog() {
        String userid;
        Map<String, Object> map = new HashMap();
        try {
            // 获得参数
            userid = request.getParameter("userid");

            // 封装参数
            map.put("userid", userid);

            // 调用Dao层 获取数据
            List blogList = BlogDao.getUserBlog(map);

            // 封装响应数据
            resultMap = PowerfulTools.format("200", "成功", blogList);

            // 转换为JSON字符串

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
