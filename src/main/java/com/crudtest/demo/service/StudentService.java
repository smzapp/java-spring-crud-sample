package com.crudtest.demo.service;

import com.crudtest.demo.exception.DuplicateEntryException;
import com.crudtest.demo.exception.EntityIdNotFound;
import com.crudtest.demo.exception.SearchEntryException;
import com.crudtest.demo.filter.StudentFilter;
import com.crudtest.demo.model.Student;
import com.crudtest.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public List<Student> filterStudents(Student studentInfo) throws SearchEntryException {
        StudentFilter studentFilter = new StudentFilter(studentInfo, studentRepository);
        return studentFilter.getResult();
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

    public Student update(Student request, Long id){
        request.setId(id);
        return studentRepository.save(request);
    }

    public Map<String, Object> delete(Long id) throws EntityIdNotFound {
        try {
            Map<String, Object> response = new HashMap<>();
            response.put("message", "Successfully deleted");
            response.put("ID", id);
            studentRepository.deleteById(id);
            return response;
        } catch (Exception e) {
            throw new EntityIdNotFound("There is a problem while deleting.");
        }
    }
}
