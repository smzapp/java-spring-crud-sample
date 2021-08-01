package com.crudtest.demo.service;

import com.crudtest.demo.exception.DuplicateEntryException;
import com.crudtest.demo.model.Student;
import com.crudtest.demo.repository.StudentRepository;
import com.crudtest.demo.util.AgeRange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public List<Student> filterStudents(Student studentInfo) {

        if (! studentInfo.getAge().isEmpty()) {
            AgeRange range = new AgeRange(studentInfo.getAge());
            return studentRepository.finByAge(range.getAgeFrom(), range.getAgeTo());
        }

        if (! studentInfo.getName().isEmpty()) {
            return studentRepository.findByName(studentInfo.getName());
        }

        List<Student> studentList = new ArrayList<Student>();
        studentRepository.findAll().forEach(stud -> studentList.add(stud));
        return studentList;
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
