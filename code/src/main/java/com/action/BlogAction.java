package com.action;

import com.DAO.BlogDao;
import com.annotations.Authority;
import com.google.gson.Gson;
import com.model.Blog;
import com.model.Favorite;
import com.model.Sensitivity;
import com.model.ThumbUp;
import com.opensymphony.xwork2.ActionSupport;
import com.tool.PowerfulTools;
import com.tool.SensitivewordFilter;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.ServletRequestAware;

import javax.servlet.http.HttpServletRequest;
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

    String message;

    @Action(value = "submitBlog", results = {
            @Result(name = "succsee", type = "json", params = {"root", "message"})
    })
    //@Authority("")
    public String submitBlog() {//提交微博
        Blog blog = new Blog();
        SensitivewordFilter filter = new SensitivewordFilter();
        Map<String, Object> resultMap;
        String release_time, multimedia, content;
        int user_id, visibility,is_showName;
        //从前端获取
        user_id = Integer.parseInt(request.getParameter("user_id"));
        content = request.getParameter("content");
        release_time = request.getParameter("release_time");
        visibility = Integer.parseInt(request.getParameter("visibility"));
        multimedia = request.getParameter("multimedia");
        is_showName=Integer.parseInt(request.getParameter("is_showName"));
        try {
            Set<String> set = filter.getSensitiveWord(content, 1);

            if (release_time == null) {
                blog.setRelease_time((int) (System.currentTimeMillis() / 1000));
            } else {
                blog.setRelease_time(Integer.parseInt(release_time));
            }

            if (multimedia == null) {
                blog.setMultimedia("");
            } else {
                blog.setMultimedia(multimedia);
            }
            blog.setUser_id(user_id);
            blog.setContent(content);
            blog.setVisibility(visibility);
            blog.setIs_showName(is_showName);
            //后台添加
            String userAgent = request.getHeader("user-agent");//获取浏览器信息
            String ip = request.getHeader("X-Forwarded-For");//获取IP地址
            blog.setBrowser_sign(userAgent);
            System.out.print("------------------user_id:"+user_id);
            System.out.print("------------------ip address:"+ip);
            blog.setIp_address(ip);
            blog.setComment_on(0);
            blog.setType(0);
            blog.setIs_edit(0);

            int bid=BlogDao.insertBlog(blog);
            if(set.size()>0){
                Sensitivity Sensitivity_blog=new Sensitivity();
                Sensitivity_blog.setBlog_id(bid);
                Sensitivity_blog.setDetails("");
                Sensitivity_blog.setType(0);
                Sensitivity_blog.setTime((int) (System.currentTimeMillis() / 1000));
                BlogDao.reportBlog(Sensitivity_blog);
            }
            // 封装响应数据
            resultMap = PowerfulTools.format("200", "发布成功", null);

            // 转换为JSON字符串
            Gson gson = new Gson();
            message = gson.toJson(resultMap);

        } catch (NullPointerException ne) {
            ne.printStackTrace();
            resultMap = PowerfulTools.format("101", "内容为空或者过长", null);
            Gson gson = new Gson();
            message = gson.toJson(resultMap);
        }
        return SUCCESS;
    }

    @Action(value = "setBlog", results = {
            @Result(name = "succsee", type = "json", params = {"root", "message"})
    })
    @Authority("")
    public String setBlog() {//修改微博
        Blog blog = new Blog();
        Map<String, Object> resultMap;
        String release_time, multimedia, content;
        int bid, visibility;
        //从前端获取
        bid = Integer.parseInt(request.getParameter("bid"));
        content = request.getParameter("content");
        release_time = request.getParameter("release_time");
        multimedia = request.getParameter("multimedia");
        visibility = Integer.parseInt(request.getParameter("visibility"));
        try {
            if (release_time == null) {
                blog.setRelease_time((int) (System.currentTimeMillis() / 1000));
            } else {
                blog.setRelease_time(Integer.parseInt(release_time));
            }

            if (multimedia == null) {
                blog.setMultimedia("");
            } else {
                blog.setMultimedia(multimedia);
            }
            blog.setBid(bid);
            blog.setContent(content);
            blog.setVisibility(visibility);


            //后台添加
            blog.setComment_on(0);
            blog.setType(0);

            BlogDao.setBlog(blog);
            // 封装响应数据
            resultMap = PowerfulTools.format("200", "修改成功", null);

            // 转换为JSON字符串
            Gson gson = new Gson();
            message = gson.toJson(resultMap);

        } catch (NullPointerException ne) {
            ne.printStackTrace();
            resultMap = PowerfulTools.format("101", "内容为空或者过长", null);
            Gson gson = new Gson();
            message = gson.toJson(resultMap);
        }
        return SUCCESS;
    }

    @Action(value = "delBlog", results = {
            @Result(name = "success", type = "json", params = {"root", "message"})
    })
    @Authority("")
    public String delBlog() {
        int bid;
        Map<String, Object> resultMap;
        bid = Integer.parseInt(request.getParameter("bid"));
        try {
            BlogDao.delBlog(bid);
            resultMap = PowerfulTools.format("200", "删除成功", null);

            // 转换为JSON字符串
            Gson gson = new Gson();
            message = gson.toJson(resultMap);
        } catch (NullPointerException ne) {
            ne.printStackTrace();
            resultMap = PowerfulTools.format("101", "内容为空或者过长", null);
            Gson gson = new Gson();
            message = gson.toJson(resultMap);
        }
        return SUCCESS;
    }

    @Action(value = "commitBlog", results = {
            @Result(name = "succsee", type = "json", params = {"root", "message"})
    })
    @Authority("")
    public String commit() {//评论微博
        Blog blog = new Blog();
        Map<String, Object> resultMap;
        String multimedia, content;
        int user_id, bid;
        //从前端获取
        user_id = Integer.parseInt(request.getParameter("user_id"));
        bid = Integer.parseInt(request.getParameter("bid"));
        content = request.getParameter("content");
        multimedia = request.getParameter("multimedia");
        try {
            if (multimedia == null) {
                blog.setMultimedia("");
            } else {
                blog.setMultimedia(multimedia);
            }
            blog.setUser_id(user_id);
            blog.setContent(content);
            blog.setComment_on(bid);

            //后台添加
            blog.setVisibility(0);
            blog.setType(2);
            blog.setRelease_time((int) (System.currentTimeMillis() / 1000));

            BlogDao.commit(blog);
            // 封装响应数据
            resultMap = PowerfulTools.format("200", "评论成功", null);

            // 转换为JSON字符串
            Gson gson = new Gson();
            message = gson.toJson(resultMap);

        } catch (NullPointerException ne) {
            ne.printStackTrace();
            resultMap = PowerfulTools.format("101", "内容为空或者过长", null);
            Gson gson = new Gson();
            message = gson.toJson(resultMap);
        }
        return SUCCESS;
    }

    @Action(value = "thumbUp", results = {
            @Result(name = "succsee", type = "json", params = {"root", "message"})
    })
    @Authority("")
    public String thumbUp() {//点赞微博
        ThumbUp thumbup = new ThumbUp();
        Map<String, Object> resultMap;
        int user_id, bid;
        //从前端获取
        user_id = Integer.parseInt(request.getParameter("user_id"));
        bid = Integer.parseInt(request.getParameter("bid"));
        try {
            thumbup.setUser_id(user_id);
            thumbup.setBlog_id(bid);
            //后台添加
            thumbup.setDate((int) (System.currentTimeMillis() / 1000));
            BlogDao.thumbUp(thumbup);
            // 封装响应数据
            resultMap = PowerfulTools.format("200", "点赞成功", null);

            // 转换为JSON字符串
            Gson gson = new Gson();
            message = gson.toJson(resultMap);

        } catch (NullPointerException ne) {
            ne.printStackTrace();
            resultMap = PowerfulTools.format("101", "点赞失败", null);
            Gson gson = new Gson();
            message = gson.toJson(resultMap);
        }
        return SUCCESS;
    }

    @Action(value = "forwardBlog", results = {
            @Result(name = "succsee", type = "json", params = {"root", "message"})
    })
    @Authority("")
    public String forwardBlog() {//转发微博
        Blog blog = new Blog();
        Map<String, Object> resultMap;
        int user_id, bid;
        //从前端获取
        user_id = Integer.parseInt(request.getParameter("user_id"));
        bid = Integer.parseInt(request.getParameter("bid"));

        try {
           BlogDao.forwordBlog(bid,user_id);
            // 封装响应数据
            resultMap = PowerfulTools.format("200", "转发成功", null);

            // 转换为JSON字符串
            Gson gson = new Gson();
            message = gson.toJson(resultMap);

        } catch (NullPointerException ne) {
            ne.printStackTrace();
            resultMap = PowerfulTools.format("101", "转发失败", null);
            Gson gson = new Gson();
            message = gson.toJson(resultMap);
        }
        return SUCCESS;
    }
    @Action(value = "searchBlog", results = {
            @Result(name = "success", type = "json", params = {"root", "message"})
    })
    public String searchBlog() {
        String keyword, userid, pageNum, pageCap;
        long nowtime;
        Map<String, Object> map = new HashMap();
        Map<String, Object> resultMap;
        try {
            // 获得参数
            keyword = request.getParameter("keyword");
            pageNum = request.getParameter("pageNum");
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
            nowtime = new Date().getTime() / 1000;
            map.put("nowtime", nowtime);
            // 调用Dao层 获取数据
            List blogList = BlogDao.getBlogByKeyword(map);

            // 写入搜索记录(用户登陆状态下)
            if (userid != null && !"".equals(userid)) BlogDao.insertSearchBlog(map);

            // 封装响应数据
            resultMap = PowerfulTools.format("200", "成功", blogList);

            // 转换为JSON字符串
            Gson gson = new Gson();
            message = gson.toJson(resultMap);

        } catch (NullPointerException ne) {
            ne.printStackTrace();
            resultMap = PowerfulTools.format("500", "系统异常", null);
            Gson gson = new Gson();
            message = gson.toJson(resultMap);
        }
        return SUCCESS;
    }

    @Action(value = "collectBlog", results = {
            @Result(name = "succsee", type = "json", params = {"root", "message"})
    })
    @Authority("")
    public String collectBlog() {//收藏微博
        Favorite Favorite_blog = new Favorite();
        Map<String, Object> resultMap;
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
            Gson gson = new Gson();
            message = gson.toJson(resultMap);

        } catch (NullPointerException ne) {
            ne.printStackTrace();
            resultMap = PowerfulTools.format("101", "收藏失败", null);
            Gson gson = new Gson();
            message = gson.toJson(resultMap);
        }
        return SUCCESS;
    }

    @Action(value = "reportBlog", results = {
            @Result(name = "succsee", type = "json", params = {"root", "message"})
    })
    @Authority("")
    public String reportBlog() {//举报微博
        Sensitivity Sensitivity_blog = new Sensitivity();
        Map<String, Object> resultMap;
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
            Gson gson = new Gson();
            message = gson.toJson(resultMap);

        } catch (NullPointerException ne) {
            ne.printStackTrace();
            resultMap = PowerfulTools.format("101", "举报失败", null);
            Gson gson = new Gson();
            message = gson.toJson(resultMap);
        }
        return SUCCESS;
    }




    @Action(value = "getFollowBlog", results = {
            @Result(name = "success", type = "json", params = {"root", "message"})
    })
    public String getFollowBlog() {
        String userid;
        Map<String, Object> map = new HashMap();
        Map<String, Object> resultMap;
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
            Gson gson = new Gson();
            message = gson.toJson(resultMap);

        } catch (NullPointerException ne) {
            ne.printStackTrace();
            resultMap = PowerfulTools.format("500", "系统异常", null);
            Gson gson = new Gson();
            message = gson.toJson(resultMap);
        }
        return SUCCESS;
    }


    @Action(value = "getHotspot", results = {
            @Result(name = "success", type = "json", params = {"root", "message"})
    })
    public String getHotspot() {

        Map<String, Object> map = new HashMap();
        Map<String, Object> resultMap;
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
            Gson gson = new Gson();
            message = gson.toJson(resultMap);

        } catch (NullPointerException ne) {
            ne.printStackTrace();
            resultMap = PowerfulTools.format("500", "系统异常", null);
            Gson gson = new Gson();
            message = gson.toJson(resultMap);
        }
        return SUCCESS;
    }

    @Action(value = "getUserBlog", results = {
            @Result(name = "success", type = "json", params = {"root", "message"})
    })
    public String getUserBlog() {
        String userid;
        Map<String, Object> map = new HashMap();
        Map<String, Object> resultMap;
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
            Gson gson = new Gson();
            message = gson.toJson(resultMap);

        } catch (NullPointerException ne) {
            ne.printStackTrace();
            resultMap = PowerfulTools.format("500", "系统异常", null);
            Gson gson = new Gson();
            message = gson.toJson(resultMap);
        }
        return SUCCESS;
    }


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


    @Override
    public void setServletRequest(javax.servlet.http.HttpServletRequest request) {
        this.request = request;
    }
}
