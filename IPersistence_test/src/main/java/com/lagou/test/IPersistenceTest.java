package com.lagou.test;

import com.lagou.dao.IUserDao;
import com.lagou.io.Resources;
import com.lagou.pojo.User;
import com.lagou.sqlSession.SqlSession;
import com.lagou.sqlSession.SqlSessionFactory;
import com.lagou.sqlSession.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;

public class IPersistenceTest {

    @Test
    public void test() throws Exception {
        InputStream resourceAsSteam = Resources.getResourceAsSteam("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsSteam);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //调用
//        User user = new User();
//        user.setId(1);
//        user.setUsername("lucy");
//        User user2 = sqlSession.selectOne("com.lagou.dao.IUserDao.selectOne", user);
//        System.out.println(user2);

//        List<User> users = sqlSession.selectList("user.selectList");
//        for (User user1 : users) {
//            System.out.println(user1);
//        }

        IUserDao userDao = sqlSession.getMapper(IUserDao.class);

//        List<User> all = userDao.findAll();
//        for (User user1 : all) {
//            System.out.println(user1);
//        }

        //测试更新方法
//        User user = new User();
//        user.setId(1);
//        user.setPassword("369369");
//        Integer result = userDao.updateByCondition(user);
//        System.out.println(result);

        //测试删除方法
        User user = new User();
        user.setId(2);
        user.setUsername("tom");
        Integer result = userDao.deleteByCondition(user);
        System.out.println(result);


    }



}
