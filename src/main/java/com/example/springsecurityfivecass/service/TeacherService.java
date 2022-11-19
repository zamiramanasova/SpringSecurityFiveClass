package com.example.springsecurityfivecass.service;

import com.example.springsecurityfivecass.entity.Teacher;
import com.example.springsecurityfivecass.entity.mappers.TeacherMappers;
import com.example.springsecurityfivecass.repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeacherService {

    private final TeacherRepository teacherRepository;
    private final TeacherMappers teacherMappers;

    public List<Teacher> getAllTeacher(){
        return teacherRepository.findAll();
    }

    public Teacher save(Teacher teacher){
        Teacher teacher1 = teacherMappers.mapToEntity(teacher);
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

}
