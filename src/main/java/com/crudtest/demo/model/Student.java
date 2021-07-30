package com.crudtest.demo.model;

import com.crudtest.demo.validation.Age;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;

    @NotNull
    @Email(message = "Email address must be a valid email.")
    @Column(name = "email")
    private String email;

    @Column(name = "contact_no")
    @Size(min = 3, message = "Should have at least 3 numbers")
    private String contactNo;

    @Column(name = "age")
    private int age;

    @Column(name = "student_no")
    private String studentNumber;

    public Student() {
    }

    public Student(String name, String email, String contactNo, int age, String studentNumber) {
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

    public String getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }
}
