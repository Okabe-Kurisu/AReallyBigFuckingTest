package com.DAO;

import com.google.gson.Gson;
import com.model.*;
import com.tool.MybatisTool;
import org.apache.ibatis.session.SqlSession;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

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
            System.out.print("   " + (int)blogList.get(0).get("is_edit"));
            //获得前一天时间戳
            SimpleDateFormat dft = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date beginDate = new Date();
            Calendar date = Calendar.getInstance();
            date.setTime(beginDate);
            date.set(Calendar.DATE, date.get(Calendar.DATE) - 1);
            Date endDate = dft.parse(dft.format(date.getTime()));
            release_time = (int) endDate.getTime();
            sqlSession.commit();

            if ((int)blogList.get(0).get("is_edit") > 5 && release_time > (int)blogList.get(0).get("release_time")) {
                sqlSession.update("weibo/BlogMapper.clearUpdateNum", blog_id);
                sqlSession.commit();
                System.out.print("情况1");
                flag = 0;
                return flag;
            } else if ((int)blogList.get(0).get("is_edit") <= 5) {
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
    public static void forwordBlog(int bid, int user_id) {
        SqlSession sqlSession = MybatisTool.getSqlSession();
        Blog blog = new Blog();
        try {
            blog = sqlSession.selectOne("weibo/BlogMapper.forwardBlog", bid);
            sqlSession.commit();
            if (blog.getUser_id() != user_id) {
                blog.setUser_id(user_id);
                blog.setType(1);
                blog.setRelease_time((int) (System.currentTimeMillis() / 1000));
                sqlSession.insert("weibo/BlogMapper.submitBlog", blog);
                sqlSession.commit();
            } else {
            }
        } finally {
            sqlSession.close();
        }

    }

    //收藏微博
    public static int collectBlog(Favorite blog) {
        SqlSession sqlSession = MybatisTool.getSqlSession();
        try {
            sqlSession.insert("weibo/BlogMapper.collectBlog", blog);
            sqlSession.commit();
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
        List<Map> blogList = null;
        try {
            sqlSession.insert("weibo/BlogMapper.insertSearchBlog", map);
            sqlSession.commit();
        } finally {
            sqlSession.close();
        }
    }
    //获得一段时间前的微博
    public static List<Map>selectBlogByTime(Map<String, Object> map){
        SqlSession sqlSession = MybatisTool.getSqlSession();
        List<Map> blogList = null;
        try {
            blogList = sqlSession.selectList("weibo/BlogMapper.selectBlogByTime", map);
        } finally {
            sqlSession.close();
        }
        return blogList;
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

    public static List<Map> getUserBlog(Map<String, Object> map) {
        SqlSession sqlSession = MybatisTool.getSqlSession();
        List<Map> blogList = null;
        try {
            blogList = sqlSession.selectList("weibo/BlogMapper.getUserBlogByUserid", map);
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
