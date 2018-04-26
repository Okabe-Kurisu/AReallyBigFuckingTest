package com.DAO;

import com.model.Discuss;
import com.tool.MybatisTool;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.Map;

/**
 * Created by Amadeus on 2018/3/21.
 */
public class DiscussDao {
    public static List<Discuss> selectAllDiscuss() {
        SqlSession sqlSession = MybatisTool.getSqlSession();
        List<Discuss> discussList;
        try {
            discussList = sqlSession.selectList("weibo/DiscussMapper.selectAllDiscuss");
        } finally {
            sqlSession.close();
        }
        return discussList;
    }

    public static Discuss selectDiscussById(int did) {
        SqlSession sqlSession = MybatisTool.getSqlSession();
        Discuss discuss;
        try {
            discuss = sqlSession.selectOne("weibo/DiscussMapper.selectDiscussById", did);
        } finally {
            sqlSession.close();
        }
        return discuss;
    }

    public static List<Discuss> quickQueryDiscuss(String key) {
        SqlSession sqlSession = MybatisTool.getSqlSession();
        List<Discuss> discussList;
        try {
            discussList = sqlSession.selectList("weibo/DiscussMapper.quickQueryDiscuss", key);
        } finally {
            sqlSession.close();
        }
        return discussList;
    }

    public static List<Discuss> selectDiscussLike(Map map) {
        SqlSession sqlSession = MybatisTool.getSqlSession();
        List<Discuss> discussList;
        try {
            discussList = sqlSession.selectList("weibo/DiscussMapper.selectDiscussLike", map);
        } finally {
            sqlSession.close();
        }
        return discussList;
    }

    public static List<Map> selectBlogInDiscuss(Map map) {
        SqlSession sqlSession = MybatisTool.getSqlSession();
        List<Map> BlogList;
        try {
            BlogList = sqlSession.selectList("weibo/DiscussMapper.selectBlogInDiscuss", map);
        } finally {
            sqlSession.close();
        }
        return BlogList;
    }

    public static Integer insertDiscuss(Map map) {
        SqlSession sqlSession = MybatisTool.getSqlSession();
        int discussId;
        try {
            discussId = sqlSession.insert("weibo/DiscussMapper.insertDiscuss", map);
        } finally {
            sqlSession.close();
        }

        return discussId;
    }

    public static Integer updateDiscuss(Discuss discuss) {
        SqlSession sqlSession = MybatisTool.getSqlSession();
        try {
            sqlSession.update("weibo/DiscussMapper.updateDiscuss", discuss);
        } finally {
            sqlSession.close();
        }
        return discuss.getDid();
    }

}
