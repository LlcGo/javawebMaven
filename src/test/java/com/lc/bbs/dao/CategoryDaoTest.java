package com.lc.bbs.dao;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

import static org.junit.Assert.*;

public class CategoryDaoTest {

    @Test
    public void addCategory() throws IOException {
        InputStream is = Resources.getResourceAsStream("mybatis-cfg.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(is);
        SqlSession sqlSession = factory.openSession(true);
        Integer cnt
                = sqlSession.getMapper(CategoryDao.class)
                .addCategory("成人", "...");
        System.out.println(cnt == 1);
    }

}