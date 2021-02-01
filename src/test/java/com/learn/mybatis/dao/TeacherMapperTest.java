package com.learn.mybatis.dao;

import com.learn.mybatis.model.Teacher2;
import com.learn.mybatis.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;


public class TeacherMapperTest {
    @Test
    public void test1() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        try {
            TeacherMapper teacherMapper = sqlSession.getMapper(TeacherMapper.class);
            System.out.println(teacherMapper.getTeacher(1));
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
            TeacherMapper2 teacherMapper2 = sqlSession.getMapper(TeacherMapper2.class);
            System.out.println(teacherMapper2.getTeachers());
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
            TeacherMapper2 teacherMapper2 = sqlSession.getMapper(TeacherMapper2.class);
            Teacher2 teacher2 = teacherMapper2.getTeacherInfo(1);
            teacher2.getStudents().forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            assert sqlSession != null;
            sqlSession.close();
        }
    }
}
