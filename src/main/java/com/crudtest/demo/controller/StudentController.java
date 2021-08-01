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
@RequestMapping("/api/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping
    public List<Student> index() {
        return this.studentService.all();
    }

    @PostMapping
    public ResponseEntity<Student> createStudent(@Valid @RequestBody Student student) throws Exception {
        Student stud = studentService.create(student);
        return new ResponseEntity<>(stud, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Student> update(@Valid @RequestBody Student student,@PathVariable("id") Long id) {
        Student stud = studentService.update(student, id);
        return new ResponseEntity<>(stud, HttpStatus.CREATED);
    }
}
