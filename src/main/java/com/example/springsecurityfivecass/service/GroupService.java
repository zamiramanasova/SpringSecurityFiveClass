package com.example.springsecurityfivecass.service;


import com.example.springsecurityfivecass.entity.Course;
import com.example.springsecurityfivecass.entity.Group;
import com.example.springsecurityfivecass.repository.CourseRepository;
import com.example.springsecurityfivecass.repository.GroupRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GroupService {

    private final GroupRepository groupRepository;

    public List<Group> getAllGroup(){
        return groupRepository.findAll();
    }

    public Group save(Group group){
         groupRepository.save(group);
        return group;
    }

    public Group update(Group group){
        groupRepository.save(group);
        return group;
    }

    public Group getById(Long id){
        return groupRepository.findById(id).get();
    }

    public void delete(Long id){
        groupRepository.deleteById(id);
    }

}
