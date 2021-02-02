package com.learn.mybatis.dao;

import com.learn.mybatis.model.Student;
import com.learn.mybatis.model.Teacher;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

// 多对一
public interface StudentMapper {

    List<Student> getStudent(List<Integer> ids);

    List<Student> getStudent2(Map<String, Object> map);

    List<Student> getAllStudents(Map<String, Object> map);
}
