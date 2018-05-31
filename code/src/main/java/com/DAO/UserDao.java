package com.DAO;

import com.model.CallAt;
import com.model.Favorite;
import com.model.Follow;
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
    public static Integer updateUser(User user) {
        SqlSession sqlSession = MybatisTool.getSqlSession();
        System.out.println(user);
        try {
            sqlSession.update("weibo/UserMapper.updateUser", user);
            sqlSession.commit();
        } finally {
            sqlSession.close();
        }
        return user.getUid();
    }
    public static int userLeave(int uid) {
        SqlSession sqlSession = MybatisTool.getSqlSession();
        try {
            sqlSession.update("weibo/UserMapper.userLeave",uid);
            sqlSession.update("weibo/BlogMapper.userLeave",uid);
            sqlSession.commit();
        } finally {
            sqlSession.close();
        }
        return uid;
    }
    public static int follow(Follow follow) {
        SqlSession sqlSession = MybatisTool.getSqlSession();
        try {
            sqlSession.delete("weibo/UserMapper.unfollow", follow);
        }finally {
            try {
                sqlSession.insert("weibo/UserMapper.follow",follow);
                sqlSession.commit();
            } finally {
                sqlSession.close();
            }
        }

        return 0;
    }
    public static int unfollow(Follow follow) {
        SqlSession sqlSession = MybatisTool.getSqlSession();
        try {
            sqlSession.insert("weibo/UserMapper.unfollow",follow);
            sqlSession.commit();
        } finally {
            sqlSession.close();
        }
        return 0;
    }
    public static int initUser(User user) {
        SqlSession sqlSession = MybatisTool.getSqlSession();
        System.out.println(user);
        try {
            sqlSession.insert("weibo/UserMapper.initUser",user);
            sqlSession.commit();
        } finally {
            sqlSession.close();
        }
        return 0;
    }
    public static Map getUserByUid(int uid) {
        HashMap user = null;
        SqlSession sqlSession = MybatisTool.getSqlSession();
        try {
            user = sqlSession.selectOne("weibo/UserMapper.getUserByUid",uid);
        }catch (Exception e){
            e.printStackTrace();
        }
        finally {
            sqlSession.close();
        }
        return user;
    }
    public static List<HashMap> getFanAvatarByUid(int uid) {
        List<HashMap> user = null;
        SqlSession sqlSession = MybatisTool.getSqlSession();
        try {
            user = sqlSession.selectList("weibo/UserMapper.getFanAvatarByUid", uid);
        }catch (Exception e){
            e.printStackTrace();
        }
        finally {
            sqlSession.close();
        }
        return user;
    }
    public static List<Follow> getFollow(int uid) {
        List<Follow> follows = null;
        SqlSession sqlSession = MybatisTool.getSqlSession();
        try {
            follows = sqlSession.selectList("weibo/UserMapper.getFollow", uid);
        }catch (Exception e){
            e.printStackTrace();
        }
        finally {
            sqlSession.close();
        }
        return follows;
    }
    public static List<Favorite> getFavorite(int uid) {
        List<Favorite> follows = null;
        SqlSession sqlSession = MybatisTool.getSqlSession();
        try {
            follows = sqlSession.selectList("weibo/UserMapper.getFavorite", uid);
        }catch (Exception e){
            e.printStackTrace();
        }
        finally {
            sqlSession.close();
        }
        return follows;
    }
    public static List<CallAt> getCallat(int uid) {
        List<CallAt> follows = null;
        SqlSession sqlSession = MybatisTool.getSqlSession();
        try {
            follows = sqlSession.selectList("weibo/UserMapper.getCallat", uid);
        }catch (Exception e){
            e.printStackTrace();
        }
        finally {
            sqlSession.close();
        }
        return follows;
    }

    public static int setImg(User user) {
        SqlSession sqlSession = MybatisTool.getSqlSession();
        try {
            sqlSession.insert("weibo/UserMapper.setImg", user);
            sqlSession.commit();
        } finally {
            sqlSession.close();
        }
        return user.getUid();
    }
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
    public static User checkPassword(String username) {
        SqlSession sqlSession = MybatisTool.getSqlSession();

        User user = new User();
        try {
            user = sqlSession.selectOne("weibo/UserMapper.checkPassword", username);
            sqlSession.commit();

        } finally {
            sqlSession.close();
        }
        return user;
    }
    public static User getAvatar(User user) {
        SqlSession sqlSession = MybatisTool.getSqlSession();
        User user1 = new User();
        System.out.println(user.getUid());
        try {
            user1 = sqlSession.selectOne("weibo/UserMapper.getAvatar", user);
            sqlSession.commit();
        } finally {
            sqlSession.close();
        }
        System.out.println(user1.getAvatar()+"1111111111111111111111111111111111");
        return user1;
    }
    public static User checkusername(String username) {
        SqlSession sqlSession = MybatisTool.getSqlSession();
        System.out.println(username);
        User user = new User();
        try {
            user = sqlSession.selectOne("weibo/UserMapper.checkusername", username);
            sqlSession.commit();
        } finally {
            sqlSession.close();
        }
        return user;
    }
    public static User checknickname(String nickname) {
        SqlSession sqlSession = MybatisTool.getSqlSession();
        User user = new User();
        try {
            user =  sqlSession.selectOne("weibo/UserMapper.checknickname", nickname);
            sqlSession.commit();
        } finally {
            sqlSession.close();
        }
        return user;
    }

    public static List<Map> getAllUser() {
        SqlSession sqlSession = MybatisTool.getSqlSession();
        List<Map> userList = null;
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

    public static List<User> hotUser(int date) {
        SqlSession sqlSession = MybatisTool.getSqlSession();
        List<User> userList = null;
        try {
            userList = sqlSession.selectList("weibo/BlogMapper.hotUser",date);
        } finally {
            sqlSession.close();
        }
        return userList;
    }

    public static int addAtUser(CallAt user) {//at用户添加到表
        SqlSession sqlSession = MybatisTool.getSqlSession();
        try {
            sqlSession.insert("weibo/BlogMapper.atUser",user);
            sqlSession.commit();
        } finally {
            sqlSession.close();
        }
        return user.getCid();
    }

    public static void setWeight(Map map) {
        SqlSession sqlSession = MybatisTool.getSqlSession();
        try {
            sqlSession.insert("weibo/UserMapper.setWeight",map);
            sqlSession.commit();
        }
        finally {
            sqlSession.close();
        }
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

    public static List<Map> daisuki(Map map) {
        SqlSession sqlSession = MybatisTool.getSqlSession();
        List<Map> userList = null;
        try {
            userList = sqlSession.selectList("weibo/UserMapper.daisuki", map);
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
