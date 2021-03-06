package com.crudtest.demo.model;

public class Student {
    private long id;
    private String name;
    private String email;
    private String contactNo;
    private int age;
    private long studentNumber;

    public Student() {
    }

    public Student(String name, String email, String contactNo, int age, long studentNumber) {
        this.name = name;
        this.email = email;
        this.contactNo = contactNo;
        this.age = age;
        this.studentNumber = studentNumber;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public long getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(long studentNumber) {
        this.studentNumber = studentNumber;
    }
}
