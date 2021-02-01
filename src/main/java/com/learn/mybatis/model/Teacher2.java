package com.learn.mybatis.model;

import java.util.List;

public class Teacher2 {
    private int id;
    private String name;

    // 一个老师拥有多个学生
    private List<Student2> students;

    public Teacher2(String name, List<Student2> students) {
        this.name = name;
        this.students = students;
    }

    public Teacher2(int id, String name, List<Student2> students) {
        this.id = id;
        this.name = name;
        this.students = students;
    }

    public Teacher2() {
    }

    @Override
    public String toString() {
        return "Teacher2{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", students=" + students +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Student2> getStudents() {
        return students;
    }

    public void setStudents(List<Student2> students) {
        this.students = students;
    }
}
