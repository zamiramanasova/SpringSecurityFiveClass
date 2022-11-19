package com.example.springsecurityfivecass.entity.mappers;

import com.example.springsecurityfivecass.entity.Course;
import com.example.springsecurityfivecass.repository.CompanyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CourseMapper {

    @Autowired
    private CompanyRepository companyRepository;

    public Course mapToEntity(Course course){
        Course course1 = new Course();
        course1.setCourseName(course.getCourseName());
        course1.setDuration(course.getDuration());
        course1.setCompany(companyRepository.findById(course.getCompany().getId()));
        return course1;
    }
}
