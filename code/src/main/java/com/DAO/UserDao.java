package com.DAO;

import com.model.CallAt;
import com.model.User;
import com.tool.MybatisTool;
import org.apache.ibatis.session.SqlSession;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Amadeus on 2018/3/15.
 */
public class UserDao {
    public static int signup(User user) {
        SqlSession sqlSession = MybatisTool.getSqlSession();
        try {
            sqlSession.insert("weibo/UserMapper.insertUser", user);
            sqlSession.commit();
        } finally {
            sqlSession.close();
        }
        return user.getUid();
    }

    public static List<User> getAllUser() {
        SqlSession sqlSession = MybatisTool.getSqlSession();
        List<User> userList = null;
        try {
            userList = sqlSession.selectList("weibo/UserMapper.selectAllUser");
        } finally {
            sqlSession.close();
        }
        return userList;
    }

    public static List<User> getFiveUser(String nickname) {//at用户前模糊查询获得五个用户
        SqlSession sqlSession = MybatisTool.getSqlSession();
        List<User> userList = null;
        try {
            userList = sqlSession.selectList("weibo/BlogMapper.getFiveUser",nickname);
        } finally {
            sqlSession.close();
        }
        return userList;
    }

    public static int addAtUser(CallAt user) {//at用户添加到表
        SqlSession sqlSession = MybatisTool.getSqlSession();
        try {
           sqlSession.insert("weibo/BlogMapper.atUser",user);
        } finally {
            sqlSession.close();
        }
        return user.getCid();
    }

    public static List<Map> getUserByKeyword(Map<String, Object> map) {
        SqlSession sqlSession = MybatisTool.getSqlSession();
        List<Map> userList = null;
        try {
            userList = sqlSession.selectList("weibo/UserMapper.selectUser", map);
        } finally {
            sqlSession.close();
        }
        return userList;
    }

//    public static int testSignup(){
//        User user = new User();
//        user.setNickname("超级鹳狸猿");
//        user.setUsername("admin");
//        user.setPassword("admin");
//        user.setAge(0);
//        user.setSex(Boolean.FALSE);
//        return signup(user);
//    }
//
//    public static void main(String[] args) {
//        System.out.println(testSignup()+" ");
//
////        List users = getAllUser();
////        for (Object u:
////             users) {
////            System.out.println(u.toString());
////        }
//
//    }
}
