package com.learn.mybatis.model;

public class Student2 {
    private int id;
    private String name;
    private int tid;

    public Student2(String name, int tid) {
        this.name = name;
        this.tid = tid;
    }

    public Student2() {
    }

    public Student2(int id, String name, int tid) {
        this.id = id;
        this.name = name;
        this.tid = tid;
    }

    @Override
    public String toString() {
        return "Student2{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", tid=" + tid +
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

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }
}
