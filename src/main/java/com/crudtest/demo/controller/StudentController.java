package com.crudtest.demo.controller;

import com.crudtest.demo.exception.DuplicateEntryException;
import com.crudtest.demo.exception.EntityIdNotFound;
import com.crudtest.demo.exception.SearchEntryException;
import com.crudtest.demo.model.Student;
import com.crudtest.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

/**
 * By Samuel
 */
@RestController
@RequestMapping("/api/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping
    public List<Student> index(
            @RequestParam(value = "age", required = false) String age,
            @RequestParam(value = "name", required = false) String name
    ) throws SearchEntryException {
        return this.studentService.filterStudents(new Student(name, age));
    }

    @PostMapping
    public ResponseEntity<Student> createStudent(@Valid @RequestBody Student student) throws DuplicateEntryException {
        Student stud = studentService.create(student);
        return new ResponseEntity<>(stud, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> findById(@PathVariable("id") Long id) {
        Student student = studentService.getByStudentId(id);
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Student> update(@Valid @RequestBody Student student,@PathVariable("id") Long id) {
        Student stud = studentService.update(student, id);
        return new ResponseEntity<>(stud, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public Map<String, Object> delete(@PathVariable("id") Long id) throws EntityIdNotFound {
        return studentService.delete(id);
    }
}
