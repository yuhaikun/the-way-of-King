package com.kuang.dao;

import com.kuang.pojo.User;
import com.kuang.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;

public class UserDaoTest {



    @Test
    public void test() {

        //第一步：获得SqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        try {

            //方式一：getMapper
            UserMapper userDao = sqlSession.getMapper(UserMapper.class);

            List<User> userList = userDao.getUserList();

            //方式二：（被淘汰）
//        List<User> userList = sqlSession.selectList("com.kuang.dao.UserDao.getUserList");


            for (User user: userList) {
                System.out.println(user);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            //关闭SqlSession
            sqlSession.close();
        }




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
    public void getUserById2() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        HashMap<String, Object> map = new HashMap<String,Object>();

        map.put("id",1);
        map.put("name","狂神");


        User userById2 = mapper.getUserById2(map);



        sqlSession.commit();

        sqlSession.close();

        System.out.println(userById2);

    }


    //增删改需要提交事务
    @Test
    public  void addUser() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        int res = mapper.addUser(new User(5, "haha", "1227845"));

        if (res>0) {
            System.out.println("插入成功");
        }
        //提交事务
        sqlSession.commit();

        sqlSession.close();

    }



    @Test
    public void updateUser() {

        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        mapper.updateUser(new User(5,"hehe","123456"));

        sqlSession.commit();

        sqlSession.close();

    }
    @Test
    public void deleteUser() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        mapper.deleteUser(5);

        sqlSession.commit();

        sqlSession.close();

    }


}
