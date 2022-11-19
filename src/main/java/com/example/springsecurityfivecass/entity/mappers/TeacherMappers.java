package com.example.springsecurityfivecass.entity.mappers;

import com.example.springsecurityfivecass.entity.Teacher;
import com.example.springsecurityfivecass.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TeacherMappers {

    private CourseRepository courseRepository;

    public Teacher mapToEntity(Teacher teacher){
        Teacher teacher1 = new Teacher();
        teacher1.setFirstName(teacher.getFirstName());
        teacher1.setLastName(teacher.getLastName());
        teacher1.setEmail(teacher.getEmail());
        teacher1.setCourse(courseRepository.getById(teacher.getCourse().getId()));
        return teacher1;

    }
}
