package com.learn.mybatis.dao;

import com.learn.mybatis.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    // 查询全部用户
    List<User> getUserList();

    // 注解查询
    // 无法解决实体类和数据库表中不一致的情况，mapper和注解需要看情况使用
    @Select("select * from user")
    List<User> getUserList2();

    @Insert("insert user (name, password) values (#{name},#{password})")
    void createUser2(User user);

    // 根据ID查询用户
    User getUserById(int id);

    User getUserById2(Map<String, Object> map);

    // 注解查询
    @Select("select * from user where id=#{id}")
    User getUserById3(int id);

    List<User> getUserByLike(String name);

    // 新建用户
    void createUser(User user);

    void createUserByMap(Map<String, Object> map);

    // 删除用户
    void deleteUser(int id);

    // 更新用户
    void updateUser(User user);

    // 分页
    List<User> getUserByLimit(Map<String,Object> map);

    // 注解更新
    @Update("update user set name=#{name},password=#{password} where id=#{id}")
    void updateUser2(User user);
}
