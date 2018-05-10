package com.DAO;

import com.google.gson.Gson;
import com.model.*;
import com.tool.MybatisTool;
import org.apache.ibatis.session.SqlSession;

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
