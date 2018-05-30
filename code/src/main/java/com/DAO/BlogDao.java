package com.DAO;

import com.google.gson.Gson;
import com.model.*;
import com.tool.MybatisTool;
import org.apache.ibatis.session.SqlSession;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 主要是与Blog表有关的操作
 *
 * @author Zhongxu Fan
 * @create 2018-03-25 19:29
 **/

public class BlogDao {
    //发布微博
    public static int insertBlog(Blog blog) {
        SqlSession sqlSession = MybatisTool.getSqlSession();
        try {
            blog.setIp_address("");
            sqlSession.insert("weibo/BlogMapper.submitBlog", blog);
            sqlSession.commit();
        } finally {
            sqlSession.close();
        }
        return blog.getBid();
    }

    //删除微博
    public static void delBlog(int bid) {
        SqlSession sqlSession = MybatisTool.getSqlSession();
        try {
            sqlSession.insert("weibo/BlogMapper.delBlog", bid);
            sqlSession.commit();
        } finally {
            sqlSession.close();
        }
    }

    //查看人员是否被封禁
    public static int checkAdmin(int user_id) {
        SqlSession sqlSession = MybatisTool.getSqlSession();
        int is_ban;
        try {
            is_ban = sqlSession.selectOne("weibo/BlogMapper.checkAdmin", user_id);
            sqlSession.commit();
        } finally {
            sqlSession.close();
        }
        return is_ban;
    }

    public static Map getBlogById(int bid) {
        SqlSession sqlSession = MybatisTool.getSqlSession();
        Map blog;
        try {
            blog = sqlSession.selectOne("weibo/BlogMapper.getBlogById", bid);
            sqlSession.commit();
        } finally {
            sqlSession.close();
        }
        return blog;
    }

    //修改微博
    public static void setBlog(Blog blog) {
        SqlSession sqlSession = MybatisTool.getSqlSession();
        try {
            sqlSession.insert("weibo/BlogMapper.setBlog", blog);
            sqlSession.commit();
        } finally {
            sqlSession.close();
        }
    }

    //微博修改次数
    public static int SetBlogNum(int blog_id) {
        SqlSession sqlSession = MybatisTool.getSqlSession();
        int release_time;
        int flag = 0;
        List<Map> blogList = null;
        try {
            System.out.print("enter");
            blogList = sqlSession.selectList("weibo/BlogMapper.checkUpdateNum", blog_id);
            System.out.print("   " + (int) blogList.get(0).get("is_edit"));
            //获得前一天时间戳
            SimpleDateFormat dft = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date beginDate = new Date();
            Calendar date = Calendar.getInstance();
            date.setTime(beginDate);
            date.set(Calendar.DATE, date.get(Calendar.DATE) - 1);
            Date endDate = dft.parse(dft.format(date.getTime()));
            release_time = (int) endDate.getTime();
            sqlSession.commit();

            if ((int) blogList.get(0).get("is_edit") > 5 && release_time > (int) blogList.get(0).get("release_time")) {
                sqlSession.update("weibo/BlogMapper.clearUpdateNum", blog_id);
                sqlSession.commit();
                System.out.print("情况1");
                flag = 0;
                return flag;
            } else if ((int) blogList.get(0).get("is_edit") <= 5) {
                System.out.print("情况2");
                flag = 0;
                return flag;
            } else {
                System.out.print("情况3");
                flag = 1;
                return flag;
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
        System.out.print("flag=" + flag);
        return flag;
    }

    //发布评论
    public static int commit(Blog blog) {
        SqlSession sqlSession = MybatisTool.getSqlSession();
        try {
            sqlSession.insert("weibo/BlogMapper.commit", blog);
            sqlSession.commit();
        } finally {
            sqlSession.close();
        }
        return blog.getBid();
    }

    //获得微博发布者的id
    public static int getUidByBid(int bid) {
        int uid;
        SqlSession sqlSession = MybatisTool.getSqlSession();
        try {
            uid = sqlSession.selectOne("weibo/UserMapper.getUserByBid", bid);
            sqlSession.commit();
        } finally {
            sqlSession.close();
        }
        return uid;
    }

    //点赞微博
    public static void thumbUp(ThumbUp thumb) {
        SqlSession sqlSession = MybatisTool.getSqlSession();
        List<Map> blogList = null;
        try {
            blogList = sqlSession.selectList("weibo/BlogMapper.checkThumbUp", thumb);
            if (blogList.isEmpty()) {

                sqlSession.insert("weibo/BlogMapper.addThumbUp", thumb);
            } else {
                sqlSession.delete("weibo/BlogMapper.delThumbUp", blogList.get(0));
            }
            sqlSession.commit();
        } finally {
            sqlSession.close();
        }
    }

    //转发微博
    public static int forwordBlog(int bid, String content, int user_id) {
        SqlSession sqlSession = MybatisTool.getSqlSession();
        Blog blog = new Blog();
        Map<String, Object> maps = new HashMap();
        int blogid = 0;
        System.out.println("bid=" + bid);
        maps.put("comment_on", bid);
        maps.put("user_id", user_id);
        try {
            blogid = sqlSession.insert("weibo/BlogMapper.submitBlog", blog);
            sqlSession.commit();
        } finally {
            sqlSession.close();
        }
        System.out.println("转发微博");
        return blogid;
    }

    //收藏微博
    public static int collectBlog(Favorite blog) {
        SqlSession sqlSession = MybatisTool.getSqlSession();
        Map<String, Object> maps = new HashMap();
        Favorite fblog = new Favorite();
        maps.put("user_id", blog.getUser_id());
        maps.put("blog_id", blog.getBlog_id());
        try {
            fblog = sqlSession.selectOne("weibo/BlogMapper.Checkcollect", maps);
            if (fblog != null) {
                //取消收藏
                sqlSession.delete("weibo/BlogMapper.delcollect", fblog.getFid());
                sqlSession.commit();
                System.out.println("取消收藏");
                return 0;
            } else {
                sqlSession.insert("weibo/BlogMapper.collectBlog", blog);
                sqlSession.commit();
                System.out.println("收藏博客");
            }

        } finally {
            sqlSession.close();
        }
        return blog.getFid();
    }

    //举报微博
    public static int reportBlog(Sensitivity blog) {
        SqlSession sqlSession = MybatisTool.getSqlSession();
        try {
            sqlSession.insert("weibo/BlogMapper.reportBlog", blog);
            sqlSession.commit();
        } finally {
            sqlSession.close();
        }
        return blog.getSid();
    }

    public static List<Map> getBlogByKeyword(Map<String, Object> map) {
        SqlSession sqlSession = MybatisTool.getSqlSession();
        List<Map> blogList = null;
        try {
            blogList = sqlSession.selectList("weibo/BlogMapper.selectBlog", map);
        } finally {
            sqlSession.close();
        }
        return blogList;
    }

    public static void insertSearchBlog(Map<String, Object> map) {
        SqlSession sqlSession = MybatisTool.getSqlSession();
        try {
            sqlSession.insert("weibo/BlogMapper.insertSearchBlog", map);
            sqlSession.commit();
        } finally {
            sqlSession.close();
        }
    }

    //获得一段时间前的微博
    public static List<Map> selectBlogByTime(Map<String, Object> map) {
        SqlSession sqlSession = MybatisTool.getSqlSession();
        List<Map> blogList = null;
        try {
            blogList = sqlSession.selectList("weibo/BlogMapper.selectBlogByTime", map);
        } finally {
            sqlSession.close();
        }
        return blogList;
    }

    //获得五个#话题
    public static List<Discuss> selectDiscuss(Map<String, Object> map) {
        SqlSession sqlSession = MybatisTool.getSqlSession();
        List<Discuss> DiscussList = null;
        try {
            DiscussList = sqlSession.selectList("weibo/BlogMapper.getFiveDiscuss", map);
            sqlSession.commit();
            System.out.println(DiscussList);
        } finally {
            sqlSession.close();
        }
        return DiscussList;
    }

    public static int addDisBlog(BlogDiscuss blogDiscuss) {//#话题添加到表
        SqlSession sqlSession = MybatisTool.getSqlSession();
        try {
            sqlSession.insert("weibo/BlogMapper.addDisBlog", blogDiscuss);
            sqlSession.commit();
        } finally {
            sqlSession.close();
        }
        return blogDiscuss.getBdid();
    }

    public static List<Map> getFollowBlogByUserid(Map<String, Object> map) {
        SqlSession sqlSession = MybatisTool.getSqlSession();
        List<Map> blogList = null;
        try {
            blogList = sqlSession.selectList("weibo/BlogMapper.getFollowBlogByUserid", map);
        } finally {
            sqlSession.close();
        }
        return blogList;
    }

    public static List<Map> getTodayHostBlog(Map<String, Object> map) {
        SqlSession sqlSession = MybatisTool.getSqlSession();
        List<Map> blogList = null;
        try {
            blogList = sqlSession.selectList("weibo/BlogMapper.getTodayHostBlog", map);
        } finally {
            sqlSession.close();
        }
        return blogList;
    }

    public static List<Map> getUserBlog(int uid) {
        SqlSession sqlSession = MybatisTool.getSqlSession();
        List<Map> blogList = null;
        try {
            blogList = sqlSession.selectList("weibo/BlogMapper.getUserBlogByUserid", uid);
        } finally {
            sqlSession.close();
        }
        return blogList;
    }


    //收集最近一段时间被关注的微博
    public static List<Map> nowTimeHot(int date) {
        SqlSession sqlSession = MybatisTool.getSqlSession();
        List<Map> blogList = null;
        try {
            blogList = sqlSession.selectList("weibo/BlogMapper.nowTimeHot", date);
        } finally {
            sqlSession.close();
        }
        return blogList;
    }

    //收集最近一段时间被关注的微博
    public static List<Map> lastTimeHot() {
        SqlSession sqlSession = MybatisTool.getSqlSession();
        List<Map> blogList = null;
        try {
            blogList = sqlSession.selectList("weibo/BlogMapper.lastTimeHot");
        } finally {
            sqlSession.close();
        }
        return blogList;
    }

    //得到用户所评论过的，转发过的，收藏过的，点赞过的全部内容
    public static List<Map> allAboutUser() {
        SqlSession sqlSession = MybatisTool.getSqlSession();
        List<Map> blogList = null;
        try {
            blogList = sqlSession.selectList("weibo/BlogMapper.allAboutUser");
        } finally {
            sqlSession.close();
        }
        return blogList;
    }

    // 插入blog_discuss  （在某个话题下发布微博，需要在该表插入一条关联记录）
    public static void insertBlogDiscuss(BlogDiscuss blogDiscuss) {
        SqlSession sqlSession = MybatisTool.getSqlSession();
        List<Map> blogList = null;
        try {
            blogList = sqlSession.selectList("weibo/BlogMapper.getUserBlogByUserid", blogDiscuss);
        } finally {
            sqlSession.close();
        }
    }


}
