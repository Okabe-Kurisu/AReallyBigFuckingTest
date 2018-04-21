package com.DAO;

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

}
