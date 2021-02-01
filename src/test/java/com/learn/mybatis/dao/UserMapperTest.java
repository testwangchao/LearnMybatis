package com.learn.mybatis.dao;

import com.learn.mybatis.model.User;
import com.learn.mybatis.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserMapperTest {
    @Test
    public void testGetAllUser() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        // 第一步：获取SqlSession对象
        try {
            // 第二步：方式1：执行sql
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            List<User> userList = userMapper.getUserList();
            // 第二不：方式二：不推荐
//        List<User> userList = sqlSession.selectList("com.learn.mybatis.dao.UserDao.getUserList");
            userList.forEach(System.out::println);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            assert sqlSession != null;
            sqlSession.close();
        }
    }

    @Test
    public void testGetUer() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        try {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            User user = userMapper.getUserById(1);
            System.out.println(user);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            assert sqlSession != null;
            sqlSession.close();
        }
    }

    // 多个字段进行筛选
    @Test
    public void testGetUer2() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        try {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            HashMap<String, Object> map = new HashMap<>();
            map.put("userId", 3);
            map.put("userName", "更新测试");
            User user = userMapper.getUserById2(map);

            System.out.println(user);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            assert sqlSession != null;
            sqlSession.close();
        }
    }
    // 通过map传参创建用户
    @Test
    public void testCreateUser() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        try {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            User user1 = new User("大萨达332", "45345345");
            userMapper.createUser(user1);
            sqlSession.commit();
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            assert sqlSession != null;
            sqlSession.close();
        }
    }

    // 删除用户
    @Test
    public void testDeleteUser() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        try {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            userMapper.deleteUser(4);
            sqlSession.commit();
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            assert sqlSession != null;
            sqlSession.close();
        }
    }

    // 更新用户
    @Test
    public void testUpdateUser() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        try {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            User user = userMapper.getUserById(3);
            user.setName("更新测试");
            userMapper.updateUser(user);
            sqlSession.commit();
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            assert sqlSession != null;
            sqlSession.close();
        }
    }

    // 通过Map传参创建用户
    @Test
    public void testCreateUserByMap(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        try {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            Map<String, Object> objectMap = new HashMap<>();
            objectMap.put("userName", "这是map创建的");
            objectMap.put("userPasswd", "这是map创建的密码");
            userMapper.createUserByMap(objectMap);
            sqlSession.commit();
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            assert sqlSession != null;
            sqlSession.close();
        }
    }

    // 模糊查询
    @Test
    public void testGerUserByLike() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        try {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            List<User> userList = userMapper.getUserByLike("%3%");
            userList.forEach(System.out::println);
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            assert sqlSession != null;
            sqlSession.close();
        }
    }

    // 分页
    @Test
    public void testGetUserLimit() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        try {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            HashMap<String, Object> map = new HashMap<>();
            map.put("startIndex", 3);
            map.put("endIndex", 3);
            List<User> userList = userMapper.getUserByLimit(map);
            userList.forEach(System.out::println);
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            assert sqlSession != null;
            sqlSession.close();
        }
    }

    // 注解查询
    @Test
    public void testGetAllUser2() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        try {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            List<User> userList = userMapper.getUserList2();
            userList.forEach(System.out::println);
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            assert sqlSession != null;
            sqlSession.close();
        }
    }

    // 注解插入
    @Test
    public void testCreateUser2() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        try {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            User user = new User("注解插入", "7387283");
            userMapper.createUser2(user);
            sqlSession.commit();
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            assert sqlSession != null;
            sqlSession.close();
        }
    }

    // 注解根据ID查询
    @Test
    public void testGetUserById(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        try {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            User user = userMapper.getUserById3(1);
            System.out.println(user);
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            assert sqlSession != null;
            sqlSession.close();
        }
    }

    // 注解更新
    @Test
    public void testUpdateUser2() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        try {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            User user = userMapper.getUserById3(1);
            user.setName("注解更新");
            userMapper.updateUser2(user);
            sqlSession.commit();
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            assert sqlSession != null;
            sqlSession.close();
        }
    }
}
