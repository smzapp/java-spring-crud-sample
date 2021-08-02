package com.crudtest.demo.repository;

import com.crudtest.demo.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    Boolean existsByStudentNumber(String studentNumber);

    List<Student> findByName(String name);

    @Query(value = "SELECT * FROM students WHERE age >= :ageFrom AND age <= :ageTo", nativeQuery = true)
    List<Student> finByAge(int ageFrom, int ageTo);
}
