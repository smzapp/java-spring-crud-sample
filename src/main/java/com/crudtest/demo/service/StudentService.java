package com.crudtest.demo.service;

import com.crudtest.demo.exception.DuplicateEntryException;
import com.crudtest.demo.model.Student;
import com.crudtest.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public Student create(Student student) throws Exception {
        if (studentRepository.existsByStudentNumber(student.getStudentNumber())) {
            throw new DuplicateEntryException("student_number", "Student number already exists");
        }
        return studentRepository.save(student);
    }

    public List<Student> allStudents() {
        List<Student> student = new ArrayList<Student>();
        studentRepository.findAll().forEach(stud -> student.add(stud));
        return student;
    }
}
