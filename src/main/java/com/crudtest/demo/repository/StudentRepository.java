package com.crudtest.demo.repository;

import com.crudtest.demo.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    Boolean existsByStudentNumber(String studentNumber);

    List<Student> findByName(String name);
}
