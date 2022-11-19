package com.example.springsecurityfivecass.service;

import com.example.springsecurityfivecass.entity.Group;
import com.example.springsecurityfivecass.repository.GroupRepository;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
@TestMethodOrder(MethodOrderer.DisplayName.class)
class GroupServiceTest {

    @Autowired
    @InjectMocks
    private GroupService groupService;
    @Mock
    private GroupRepository groupRepository;

    private Group group1;
    private Group group2;

    @BeforeEach
    public void setup() {
        group1 = new Group(1L,"GroupOne", null,null,null,null);
        group2 = new Group(2L,"GroupTwo", null,null,null,null);
    }

    @Test
    @Order(1)
    @DisplayName("JUnit test for {1} should save Group")
    void shouldSaveGroupAfterCreate() {
        Mockito.when(groupRepository.save(group1)).thenReturn(group1);
        groupService.save(group1);

        Mockito.verify(groupRepository, Mockito.times(1))
                .save(ArgumentMatchers.any(Group.class));
        System.out.println("Group " + group1 + " saved successfully! ");
    }

    @Test
    @Order(2)
    @DisplayName("JUnit test for {2} should update Group by id")
    void shouldUpdateGroup() {
        group1.setGroupName("Jet Brains");

        Mockito.when(groupRepository.save(group1)).thenReturn(group1);
        groupService.update(group1);

        Mockito.verify(groupRepository, Mockito.times(1))
                .save(ArgumentMatchers.any(Group.class));

        System.out.println("Group " + group1.getGroupName() + " updated successfully! ");

    }

    @Test
    @Order(3)
    @DisplayName("JUnit test for {3} should find Group by id")
    void shouldGetByIdGroup() {
        Mockito.when(groupRepository.findById(1L)).thenReturn(Optional.of(group1));
        Group group = groupService.getById(1L);

        org.assertj.core.api.Assertions.assertThat(group.getId()).isEqualTo(group1.getId());
        org.assertj.core.api.Assertions.assertThat(group.getGroupName()).isEqualTo(group1.getGroupName());

        System.out.println("Group get id:" + group1.getId() + " , "+ group1.getGroupName() + " successfully! ");

    }

    @Test
    @Order(4)
    @DisplayName("JUnit test for {4} delete Group by id")
    void shouldDeleteGroup() {
        groupService.delete(1L);
        System.out.println("Group get id:" + group1.getId() + " deleted successfully! ");

    }

    @Test
    @Order(5)
    @DisplayName("JUnit test for {5} should get all Group")
    void shouldGetAllGroup() {
        List<Group> groupList = new ArrayList<>();
        groupList.add(group1);
        groupList.add(group2);

        Mockito.when(groupRepository.findAll()).thenReturn(groupList);
        groupService.getAllGroup();

        org.assertj.core.api.Assertions.assertThat(groupList.size()).isEqualTo(2);

        System.out.println("In the list of group are: "+ groupList.size());

    }

    @AfterEach
    public void tearDown() {
        group1  = group2 = null;
    }
}