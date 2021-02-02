package com.learn.mybatis.dao;

import com.learn.mybatis.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class StudentMapperTest {

    @Test
    public void test1() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        try {
            StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
            ArrayList<Integer> arrayList = new ArrayList<>();
            arrayList.add(1);
            arrayList.add(2);
            arrayList.add(3);

            studentMapper.getStudent(arrayList).forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            assert sqlSession != null;
            sqlSession.close();
        }
    }

    @Test
    public void test2() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        try {
            StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
            HashMap<String, Object> map = new HashMap<>();
//            map.put("id", 1);
//            map.put("name", "测试1");
            System.out.println(studentMapper.getStudent2(map));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            assert sqlSession != null;
            sqlSession.close();
        }
    }

    @Test
    public void test3() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        try {
            StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
            HashMap<String, Object> map = new HashMap<>();
//            map.put("name", "测试2");
            map.put("id", new ArrayList<>(Collections.singletonList(1)));
            studentMapper.getAllStudents(map).forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            assert sqlSession != null;
            sqlSession.close();
        }
    }
}
