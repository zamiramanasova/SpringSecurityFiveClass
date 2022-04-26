package com.example.springsecurityfivecass.repository;

import com.example.springsecurityfivecass.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    Student findStudentsByFirstName(String name);

}