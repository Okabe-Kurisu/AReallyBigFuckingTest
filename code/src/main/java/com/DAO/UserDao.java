package com.DAO;

import com.model.User;
import com.tool.MybatisTool;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * Created by Amadeus on 2018/3/15.
 */
public class UserDao {
    public static int signup(User user){
        SqlSession sqlSession = MybatisTool.getSqlSession();
        sqlSession.insert("weibo/UserMapper.signup", user);
        sqlSession.commit();
        sqlSession.close();
        return user.getUid();
    }

    public static List<User> getAllUser(){
        SqlSession sqlSession = MybatisTool.getSqlSession();
        List<User> users = sqlSession.selectList("weibo/UserMapper.getAllUser");
        sqlSession.close();
        return users;
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

//    public static void main(String[] args) {
//        System.out.println(testSignup()+" ");
////        List users = getAllUser();
////        for (Object u:
////             users) {
////            System.out.println(u.toString());
////        }
//
//    }
}
