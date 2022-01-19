package com.kuang.dao;

import com.kuang.pojo.User;
import com.kuang.utils.MybatisUtils;
import com.kuang.dao.UserMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class UserMapperTest {

    @Test
    public void test() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper mappper = sqlSession.getMapper(UserMapper.class);

        mappper.deleteUser(7);

//        mappper.updateUser(new User(7,"to","456131"));

//        mappper.addUser(new User(7,"Hello","123123"));


//        userMapper.getUsers().forEach(System.out::println);

//        User userByID = mappper.getUserByID(1);
//
//        System.out.println(userByID);
        

        sqlSession.close();
    }
}
