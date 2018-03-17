package com.tool;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;

/**
 * Created by Amadeus on 2018/3/15.
 */
public class MybatisToolTest {
    @Test
    public void getSqlSession() throws Exception {
        InputStream inputStream = this.getClass().getResourceAsStream("/mybatis/mybatisConfig.xml");
        System.out.println(inputStream);
        System.out.println(this.getClass().getResource("/mybatis/mybatisConfig.xml").getPath());
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);    // 创建 SqlSessionFactory

        SqlSession sqlSession = sqlSessionFactory.openSession();    // 获取到 SqlSession
    }

}