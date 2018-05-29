package com.DAO;

import com.model.Discuss;
import com.tool.MybatisTool;
import org.apache.ibatis.session.SqlSession;

import java.util.HashMap;
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

    public static List<Discuss> selectDiscussByUserId(int uid) {
        SqlSession sqlSession = MybatisTool.getSqlSession();
        List<Discuss> discusses;
        try {
            discusses = sqlSession.selectList("weibo/DiscussMapper.selectSpecUserDiscuss", uid);
        } finally {
            sqlSession.close();
        }
        return discusses;
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

    public static List<Map> selectDiscuss(Map map) {
        SqlSession sqlSession = MybatisTool.getSqlSession();
        List<Map> discussList;
        try {
            discussList = sqlSession.selectList("weibo/DiscussMapper.selectDiscuss", map);
        } finally {
            sqlSession.close();
        }
        return discussList;
    }

    public static List<Map> selectHotDiscuss() {
        SqlSession sqlSession = MybatisTool.getSqlSession();
        List<Map> discussList;
        try {
            discussList = sqlSession.selectList("weibo/DiscussMapper.selectHotDiscuss");
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

    public static Discuss insertDiscuss(Discuss discuss) {
        SqlSession sqlSession = MybatisTool.getSqlSession();
        try {
            sqlSession.insert("weibo/DiscussMapper.insertDiscuss", discuss);
            System.out.println(discuss.getDid());
            sqlSession.insert("weibo/DiscussMapper.insertFollowDis", discuss);
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }

        return discuss;
    }

    public static Integer updateDiscuss(int userId, Discuss discuss) {
        SqlSession sqlSession = MybatisTool.getSqlSession();
        try {

            sqlSession.update("weibo/DiscussMapper.updateDiscuss", discuss);
            sqlSession.commit();

        } catch (Exception e) {
            e.printStackTrace();
        } finally

        {
            sqlSession.close();
        }
        return discuss.getDid();
    }

    // 关注话题
    public static Integer insertFollowDis(Map map) {
        SqlSession sqlSession = MybatisTool.getSqlSession();
        int id = 0;
        try {
            id = sqlSession.insert("weibo/DiscussMapper.insertFollowDis", map);
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }

        return id;
    }

    // 查找用户所关注话题地全部微博
    public static List<Map> selectFollowDisBlog(Map map) {
        SqlSession sqlSession = MybatisTool.getSqlSession();
        List<Map> BlogList;
        try {
            BlogList = sqlSession.selectList("weibo/DiscussMapper.selectFollowDisBlog", map);
        } finally {
            sqlSession.close();
        }
        return BlogList;
    }

    // 判断指定话题是否是当前用户建立的
    public static boolean judgeUserDiscuss(int userId, int discussId) {
        List<Discuss> discussList;
        // 构建参数
        Map<String, Integer> param = new HashMap<>();
        param.put("userid", userId);
        param.put("did", discussId);

        boolean result = false;

        SqlSession sqlSession = MybatisTool.getSqlSession();
        try {
            discussList = sqlSession.selectList("weibo/DiscussMapper.judgeUserDiscuss", param);
            if (discussList != null && discussList.size() != 0) result = true;
            else result = false;
        } finally {
            sqlSession.close();
            result = false;
        }
        return result;
    }
}
