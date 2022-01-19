package com.kuang.dao;

import com.kuang.pojo.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {

    List<User> getUserLike(String value);

    //获取全部查询用户
    List<User> getUserList();

    //根据ID查询用户
    User getUserById(int id);

    User getUserById2(Map<String,Object> map);

    //insert一个用户
    int addUser(User user);

    //万能的map
    int addUser2(Map<String,Object> map);

    //修改用户
    int updateUser(User user);

    //删除一个用户
    int deleteUser(int id);


}
