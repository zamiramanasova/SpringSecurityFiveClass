package com.example.springsecurityfivecass.repository;

import com.example.springsecurityfivecass.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

    Course getCourseById(Long id);
}