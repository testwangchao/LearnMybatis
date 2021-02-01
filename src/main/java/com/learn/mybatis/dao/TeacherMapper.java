package com.learn.mybatis.dao;

import com.learn.mybatis.model.Teacher;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface TeacherMapper {
    @Select("select * from teacher where id=#{id}")
    Teacher getTeacher(int id);
}
