package com.example.springsecurityfivecass.service;

import com.example.springsecurityfivecass.entity.Teacher;
import com.example.springsecurityfivecass.entity.mappers.TeacherMappers;
import com.example.springsecurityfivecass.repository.TeacherRepository;
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
class TeacherServiceTest {

    @Autowired
    @InjectMocks
    private TeacherService teacherService;
    @Mock
    private TeacherRepository teacherRepository;
    @Mock
    private TeacherMappers teacherMappers;
    private Teacher teacher1;
    private Teacher teacher2;

    @BeforeEach
    public void setup() {
        teacher1 = new Teacher(1L, "Sveta", "sveta@mail.com", "Monova",null);
        teacher2 = new Teacher(2L, "Vova", "vova@mail.com", "Vovinov",null);

    }

    @Test
    @Order(1)
    @DisplayName("JUnit test for {1} should save Teacher")
    void shouldSaveTeacherAfterCreate() {
        Mockito.when(teacherMappers.mapToEntity(teacher1)).thenReturn(teacher1);
        teacherService.save(teacher1);

        Mockito.verify(teacherRepository, Mockito.times(1))
                .save(ArgumentMatchers.any(Teacher.class));
        System.out.println("Teacher " + teacher1 + " saved successfully! ");
    }

    @Test
    @Order(2)
    @DisplayName("JUnit test for {2} should update Teacher by id")
    void shouldUpdateTeacher() {
        teacher1.setFirstName("Pasha");

        Mockito.when(teacherRepository.save(teacher1)).thenReturn(teacher1);
        teacherService.update(teacher1);

        Mockito.verify(teacherRepository, Mockito.times(1))
                .save(ArgumentMatchers.any(Teacher.class));

        System.out.println("Teacher " + teacher1.getFirstName() + " updated successfully! ");

    }

    @Test
    @Order(3)
    @DisplayName("JUnit test for {3} should find Teacher by id")
    void shouldGetByIdTeacher() {
        Mockito.when(teacherRepository.findById(1L)).thenReturn(Optional.of(teacher1));
        Teacher teacher = teacherService.getById(1L);

        org.assertj.core.api.Assertions.assertThat(teacher.getId()).isEqualTo(teacher1.getId());
        org.assertj.core.api.Assertions.assertThat(teacher.getFirstName()).isEqualTo(teacher1.getFirstName());

        System.out.println("Teacher get id:" + teacher1.getId() + " , " + teacher1.getFirstName() + " successfully! ");
    }

    @Test
    @Order(4)
    @DisplayName("JUnit test for {4} delete Teacher by id")
    void shouldDeleteTeacher() {
        teacherService.delete(1L);

        System.out.println("Teacher get id:" + teacher1.getId() + " deleted successfully! ");
    }

    @Test
    @Order(7)
    @DisplayName("JUnit test for {7} should get all Teachers")
    void shouldGetAllTeacher() {
        List<Teacher> teacherList = new ArrayList<>();
        teacherList.add(teacher1);
        teacherList.add(teacher2);

        Mockito.when(teacherRepository.findAll()).thenReturn(teacherList);
        teacherService.getAllTeacher();

        org.assertj.core.api.Assertions.assertThat(teacherList.size()).isEqualTo(2);

        System.out.println("In the list of teacher are: "+ teacherList.size());
    }

    @AfterEach
    public void tearDown() {
        teacher1  = teacher2 = null;
    }
}