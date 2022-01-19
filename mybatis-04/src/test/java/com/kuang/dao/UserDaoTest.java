package com.kuang.dao;

import com.github.pagehelper.PageHelper;
import com.kuang.dao.UserMapper;
import com.kuang.pojo.User;
import com.kuang.utils.MybatisUtils;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;

public class UserDaoTest {

//    static Logger logger = LogManager.getLogger(UserDaoTest.class);

    @Test
    public void getUserByRowBounds() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);


//        RowBounds rowBounds = new RowBounds(1, 2);
//
//
//        //通过java代码层面实现分页
//        List<User> users = sqlSession.selectList("com.kuang.dao.UserMapper.getUserByRowBounds",null,rowBounds);

        PageHelper.startPage(0,2);

        List<User> userList1 = mapper.getUserByRowBounds();

        for (User user :
                userList1) {
            System.out.println(user);
        }

        sqlSession.close();

    }


    @Test
    public void getUserByLimit() {

        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        HashMap<String, Integer> map = new HashMap<String,Integer>();

        map.put("startIndex",0);
        map.put("pageSize",2);

        List<User> userList = mapper.getUserByLimit(map);

        for (User user: userList) {
            System.out.println(user);
        }


        sqlSession.close();

    }

    @Test
    public void getUserById() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        User user = mapper.getUserById(1);

        System.out.println(user);

        sqlSession.close();
    }

    @Test
    public void testLog4j() {

        Logger logger = LogManager.getLogger("AsyncFileLogger"); // Logger的名称

        logger.trace("trace level");
        logger.debug("debug level");
        logger.info("info level");
        logger.warn("warn level");
        logger.error("error level");
        logger.fatal("fatal level");


    }

}