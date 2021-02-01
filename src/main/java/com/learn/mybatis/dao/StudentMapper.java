package com.learn.mybatis.dao;

import com.learn.mybatis.model.Student;
import com.learn.mybatis.model.Teacher;

// 多对一
public interface StudentMapper {

    Student getStudent(int id);

    Student getStudent2(int id);

}
