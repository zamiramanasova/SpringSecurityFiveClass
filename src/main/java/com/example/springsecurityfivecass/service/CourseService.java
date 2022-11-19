package com.example.springsecurityfivecass.service;

import com.example.springsecurityfivecass.entity.Course;
import com.example.springsecurityfivecass.entity.mappers.CourseMapper;
import com.example.springsecurityfivecass.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseService {

    private final CourseRepository courserepository;
    private final CourseMapper courseMapper;

    public List<Course> getAllCourse(){
        return courserepository.findAll();
    }

    public Course save(Course course){
        Course course1 = courseMapper.mapToEntity(course);
        courserepository.save(course1);
        return course1;
    }

    public Course update(Course course){
        courserepository.save(course);
        return course;
    }

    public Course getById(Long id){
        return courserepository.findById(id).get();
    }

    public void delete(Long id){
        courserepository.deleteById(id);
    }

}
