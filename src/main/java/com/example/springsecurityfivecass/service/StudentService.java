package com.example.springsecurityfivecass.service;

import com.example.springsecurityfivecass.entity.Group;
import com.example.springsecurityfivecass.entity.Student;
import com.example.springsecurityfivecass.repository.GroupRepository;
import com.example.springsecurityfivecass.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;
    private final GroupRepository groupRepository;

    public List<Student> getAllStudent(){
        return studentRepository.findAll();
    }

    public Student save(Student student){
        Student student1 = mapToEntity(student);
        studentRepository.save(student1);
        return student1;
    }

    public Student update(Student student){
        studentRepository.save(student);
        return student;
    }

    public Student getById(Long id){
        return studentRepository.findById(id).get();
    }

    public void delete(Long id){
        studentRepository.deleteById(id);
    }

    public Student mapToEntity(Student student){
        Student student1 = new Student();
        student1.setFirstName(student.getFirstName());
        student1.setEmail(student.getEmail());
        student1.setLastName(student.getLastName());
        student1.setStudyFormat(student.getStudyFormat());
        student1.setGroup(groupRepository.getById(student.getGroup().getId()));
        return student1;
    }

    // метод поиска студентов
    public Student findStudentsByFirstName(String name){
        Student student = studentRepository.findStudentsByFirstName(name);
        return student;
    }
    // метод колличества студентов
    public Long countStudent(){
        Long count = studentRepository.count();
        return count;
    }
}
