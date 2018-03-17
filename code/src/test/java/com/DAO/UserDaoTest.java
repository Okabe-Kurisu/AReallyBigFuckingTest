package com.DAO;

import com.model.User;
import com.tool.MybatisTool;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Amadeus on 2018/3/17.
 */
public class UserDaoTest {

    @Test
    public void testSignup() throws Exception {
        User user = new User();
        user.setNickname("超级鹳狸猿");
        user.setUsername("admin");
        user.setPassword("admin");
        user.setAge(0);
        user.setSex(Boolean.FALSE);
        SqlSession sqlSession = MybatisTool.getSqlSession();
        sqlSession.insert("User.signup", user);
        sqlSession.close();
    }

}