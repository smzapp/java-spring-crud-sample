package com.crudtest.demo.controller;

import com.crudtest.demo.model.Student;
import com.crudtest.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/students")
    public List<Student> index() {
        return this.studentService.allStudents();
    }

    @PostMapping("/students")
    public ResponseEntity<Student> createStudent(@Valid @RequestBody Student student) {
        Student stud = studentService.create(student);
        return new ResponseEntity<>(stud, HttpStatus.CREATED);
    }

}
