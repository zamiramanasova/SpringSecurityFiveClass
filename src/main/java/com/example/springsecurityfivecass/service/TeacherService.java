package com.example.springsecurityfivecass.service;

import com.example.springsecurityfivecass.entity.Teacher;
import com.example.springsecurityfivecass.repository.CourseRepository;
import com.example.springsecurityfivecass.repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeacherService {

    private final TeacherRepository teacherRepository;
    private final CourseRepository courseRepository;

    public List<Teacher> getAllTeacher(){
        return teacherRepository.findAll();
    }

    public Teacher save(Teacher teacher){
        Teacher teacher1 = mapToEntity(teacher);
        teacherRepository.save(teacher1);
        return teacher1;
    }

    public Teacher update(Teacher teacher){
        teacherRepository.save(teacher);
        return teacher;
    }

    public Teacher getById(Long id){
        return teacherRepository.findById(id).get();
    }

    public void delete(Long id){
        teacherRepository.deleteById(id);
    }

    public Teacher mapToEntity(Teacher teacher){
        Teacher teacher1 = new Teacher();
        teacher1.setFirstName(teacher.getFirstName());
        teacher1.setLastName(teacher.getLastName());
        teacher1.setEmail(teacher.getEmail());
        teacher1.setCourse(courseRepository.getById(teacher.getCourse().getId()));
        return teacher1;

    }
}
