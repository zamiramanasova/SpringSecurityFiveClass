package com.example.springsecurityfivecass.service;

import com.example.springsecurityfivecass.entity.Course;
import com.example.springsecurityfivecass.repository.CompanyRepository;
import com.example.springsecurityfivecass.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseService {

    private final CourseRepository courserepository;
    private final CompanyRepository companyRepository;

    public List<Course> getAllCourse(){
        return courserepository.findAll();
    }

    public Course save(Course course){
        Course course1 = mapToEntity(course);
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

    public long getByCourseId(Long id){
        courserepository.findById(id).get();
        return id;
    }

    public void delete(Long id){
        courserepository.deleteById(id);
    }

    public Course mapToEntity(Course course){
        Course course1 = new Course();
        course1.setCourseName(course.getCourseName());
        course1.setDuration(course.getDuration());
        course1.setCompany(companyRepository.getById(course.getCompany().getId()));
        return course1;
    }
}
