package com.crudtest.demo.service;

import com.crudtest.demo.exception.DuplicateEntryException;
import com.crudtest.demo.model.Student;
import com.crudtest.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    private final List<Student> studentList = new ArrayList<Student>();

    public List<Student> filterStudents(Student studentInfo) {

//        if(true) {
//            return studentRepository.finByAge(studentInfo.getAge(), studentInfo.getAge());
//        }

        if (! studentInfo.getName().isEmpty()) {
            return this.findByName(studentInfo.getName());
        }

        studentRepository.findAll().forEach(stud -> studentList.add(stud));
        return studentList;
    }

    public List<Student> findByName(String name) {
        return studentRepository.findByName(name);
    }


    public Student create(Student student) throws DuplicateEntryException {
        if (studentRepository.existsByStudentNumber(student.getStudentNumber())) {
            throw new DuplicateEntryException("student_number", "Student number already exists");
        }
        return studentRepository.save(student);
    }

    public Student getByStudentId(Long id) {
        return studentRepository.findById(id).get();
    }

    public Student update(Student student, Long id){
        student.setId(id);
        return studentRepository.save(student);
    }

    public Map<String, Object> delete(Long id) {
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Successfully deleted");
        response.put("ID", id);
        studentRepository.deleteById(id);
        return response;
    }
}
