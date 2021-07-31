package com.crudtest.demo.model;


import com.crudtest.demo.validation.AgeConstraint;
import com.crudtest.demo.validation.ContactConstraint;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotEmpty
    @Column(name = "name")
    private String name;

    @NotEmpty
    @Email(message = "Email address must be a valid email.")
    @Column(name = "email")
    private String email;

    @NotEmpty
    @Column(name = "contact_no")
    @ContactConstraint
    private String contactNo;

    @NotNull
    @Column(name = "age")
    @AgeConstraint
    private String age;

    @NotEmpty
    @Column(name = "student_no", unique = true)
    private String studentNumber;

    public Student() {}

    public Student(String name, String email, String contactNo, String age, String studentNumber) {
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

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }
}
