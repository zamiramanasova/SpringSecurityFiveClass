package com.example.springsecurityfivecass.entity.mappers;

import com.example.springsecurityfivecass.entity.Student;
import com.example.springsecurityfivecass.repository.GroupRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class StudentMappers {
    @Autowired
    private GroupRepository groupRepository;
    public Student mapToEntity(Student student){
        Student student1 = new Student();
        student1.setFirstName(student.getFirstName());
        student1.setEmail(student.getEmail());
        student1.setLastName(student.getLastName());
        student1.setStudyFormat(student.getStudyFormat());
        student1.setGroup(groupRepository.getById(student.getGroup().getId()));
        return student1;
    }
}
