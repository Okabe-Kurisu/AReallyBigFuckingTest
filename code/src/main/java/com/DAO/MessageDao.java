package com.DAO;

import com.tool.MybatisTool;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.Map;

public class MessageDao {

    public static void sendMassage(Map<String, Object> map) {
            SqlSession sqlSession = MybatisTool.getSqlSession();
            List<Map> blogList = null;
            try {
                blogList = sqlSession.selectList("weibo/MessageMapper.sendMassage",map);
                sqlSession.commit();
            } finally {
                sqlSession.close();
            }
    }
    public static List<Map> getSendMassageUserid(Map<String, Object> map) {
        SqlSession sqlSession = MybatisTool.getSqlSession();
        List<Map> blogList = null;
        try {
            blogList = sqlSession.selectList("weibo/MessageMapper.getSendMassageUserid",map);
        } finally {
            sqlSession.close();
        }
        return blogList;
    }
    public static List<Map> getMassageUseridAndAccpeter(Map<String, Object> map) {
        SqlSession sqlSession = MybatisTool.getSqlSession();
        List<Map> blogList = null;
        try {
            blogList = sqlSession.selectList("weibo/MessageMapper.getMassageUseridAndAccpeter",map);
        } finally {
            sqlSession.close();
        }
        return blogList;
    }
    public static void yesRead(Map<String, Object> map){
        SqlSession sqlSession = MybatisTool.getSqlSession();
        try {
            sqlSession.selectList("weibo/MessageMapper.yesRead",map);
            sqlSession.commit();
        } finally {
            sqlSession.close();
        }
    }

    public static void delSession(Map<String, Object> map) {
        SqlSession sqlSession = MybatisTool.getSqlSession();
        try {
            sqlSession.delete("weibo/MessageMapper.delSession",map);
            sqlSession.commit();
        } finally {
            sqlSession.close();
        }
    }
}
