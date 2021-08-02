package com.crudtest.demo.filter;

import com.crudtest.demo.model.Student;
import com.crudtest.demo.repository.StudentRepository;
import com.crudtest.demo.util.AgeRange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Component
public class StudentFilter {

    @Autowired
    private StudentRepository repository;

    private Student student;

    // default Constructor is necessary
    public StudentFilter() {}

    public StudentFilter(Student studentInfo, StudentRepository studentRepository) {
        this.student = studentInfo;
        this.repository = studentRepository;
    }

    public List<Student> getResult() {
        List<Student> studentList = new ArrayList<Student>();

//        if (!this.student.getAge().isEmpty()) {
//            this.getByAgeFilter().forEach(stud -> studentList.add(stud));
//        } else if (!this.student.getName().isEmpty()) {
//            System.out.println("NAME SEARCH");
//            this.getByNameFilter().forEach(stud -> studentList.add(stud));
//        } else {
//            this.all().forEach(stud -> studentList.add(stud));
//        }

        this.getByNameFilter().forEach(stud -> studentList.add(stud));
        return studentList;

    }

    public List<Student> all() {
        return this.repository.findAll();
    }

    public List<Student> getByNameFilter() {
        return this.repository.findByName(this.student.getName());
    }

    public List<Student> getByAgeFilter() {
        AgeRange range = new AgeRange(this.student.getAge());
        return this.repository.finByAge(range.getAgeFrom(), range.getAgeTo());
    }


}
