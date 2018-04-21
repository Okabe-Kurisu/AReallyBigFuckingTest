package com.DAO;

import com.tool.MybatisTool;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.Map;

public class SensitivityDao {
    public static List<Map> getReportedBlog() {
        SqlSession sqlSession = MybatisTool.getSqlSession();
        List<Map> blogList = null;
        try {
            blogList = sqlSession.selectList("weibo/SensitivityMapper.getReportedBlog");
        } finally {
            sqlSession.close();
        }
        return blogList;
    }
    public static List<Map> BanByUserId(Map<String, Object> map) {
        SqlSession sqlSession = MybatisTool.getSqlSession();
        List<Map> blogList = null;
        try {
            blogList = sqlSession.selectList("weibo/SensitivityMapper.banByUserId", map);
        } finally {
            sqlSession.close();
        }
        return blogList;
    }
    public static List<Map> OpenByUserId(Map<String, Object> map) {
        SqlSession sqlSession = MybatisTool.getSqlSession();
        List<Map> blogList = null;
        try {
            blogList = sqlSession.selectList("weibo/SensitivityMapper.OpenByUserId", map);
        } finally {
            sqlSession.close();
        }
        return blogList;
    }
}
