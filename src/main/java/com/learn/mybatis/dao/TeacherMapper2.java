package com.learn.mybatis.dao;

import com.learn.mybatis.model.Teacher2;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface TeacherMapper2 {
    @Select("select * from teacher t")
    List<Teacher2> getTeachers();

    // 获取指定老师教的学生及老师的信息
    Teacher2 getTeacherInfo(@Param("tid") int id);
}
