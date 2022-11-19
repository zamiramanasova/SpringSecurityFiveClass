package com.example.springsecurityfivecass.service;

import com.example.springsecurityfivecass.entity.Student;
import com.example.springsecurityfivecass.entity.mappers.StudentMappers;
import com.example.springsecurityfivecass.enumpackage.StudyFormat;
import com.example.springsecurityfivecass.repository.StudentRepository;
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
class StudentServiceTest {
    @Autowired
    @InjectMocks
    private StudentService studentService;
    @Mock
    private StudentRepository studentRepository;
    @Mock
    private StudentMappers studentMappers;
    private Student student1;
    private Student student2;

    @BeforeEach
    public void setup() {
        student1 = new Student(1L,"Misha", "mishs@mail.ru","Mishivich", StudyFormat.OFFLINE,null);
        student2 = new Student(2L,"Vova", "vova@mail.ru","Vovich", StudyFormat.ONLINE,null);
    }

    @Test
    @Order(1)
    @DisplayName("JUnit test for {1} should save Student")
    void save() {
        Mockito.when(studentMappers.mapToEntity(student1)).thenReturn(student1);
        studentService.save(student1);

        Mockito.verify(studentRepository, Mockito.times(1))
                .save(ArgumentMatchers.any(Student.class));
        System.out.println("Student " + student1 + " saved successfully! ");
    }

    @Test
    @Order(2)
    @DisplayName("JUnit test for {2} should update Student by id")
    void shouldUpdateStudent() {
        student1.setFirstName("Pasha");

        Mockito.when(studentRepository.save(student1)).thenReturn(student1);
        studentService.update(student1);

        Mockito.verify(studentRepository, Mockito.times(1))
                .save(ArgumentMatchers.any(Student.class));

        System.out.println("Student " + student1.getFirstName() + " updated successfully! ");
    }

    @Test
    @Order(3)
    @DisplayName("JUnit test for {3} should find Student by id")
    void shouldGetByIdStudent() {
        Mockito.when(studentRepository.findById(1L)).thenReturn(Optional.of(student1));
        Student student = studentService.getById(1L);

        org.assertj.core.api.Assertions.assertThat(student.getId()).isEqualTo(student1.getId());
        org.assertj.core.api.Assertions.assertThat(student.getFirstName()).isEqualTo(student1.getFirstName());

        System.out.println("Student get id:" + student1.getId() + " , " + student1.getFirstName() + " successfully! ");
    }

    @Test
    @Order(4)
    @DisplayName("JUnit test for {4} delete Student by id")
    void shouldDeleteStudent() {
        studentService.delete(1L);

        System.out.println("Student get id:" + student1.getId() + " deleted successfully! ");
    }

    @Test
    @Order(5)
    @DisplayName("JUnit test for {5} should find Student by name")
    void findStudentsByFirstName() {
        Mockito.when(studentRepository.findStudentsByFirstName("Misha")).thenReturn(student1);
        Student student = studentService.findStudentsByFirstName("Misha");

        org.assertj.core.api.Assertions.assertThat(student.getId()).isEqualTo(student1.getId());
        org.assertj.core.api.Assertions.assertThat(student.getFirstName()).isEqualTo(student1.getFirstName());

        System.out.println("Student get by name:" + student1.getId() + " , " + student1.getFirstName() + " successfully! ");
    }

    @Test
    @Order(6)
    @DisplayName("JUnit test for {6} count Student")
    void shouldCountStudent() {
        Long count = Long.valueOf(2);
        Mockito.when(studentRepository.count()).thenReturn(count.longValue());
        studentService.countStudent();

        org.assertj.core.api.Assertions.assertThat(count.longValue()).isEqualTo(2);

        System.out.println("Students here are : " + count.intValue());
    }

    @Test
    @Order(7)
    @DisplayName("JUnit test for {7} should get all Students")
    void shouldGetAllStudent() {
        List<Student> studentList = new ArrayList<>();
        studentList.add(student1);
        studentList.add(student2);

        Mockito.when(studentRepository.findAll()).thenReturn(studentList);
        studentService.getAllStudent();

        org.assertj.core.api.Assertions.assertThat(studentList.size()).isEqualTo(2);

        System.out.println("In the list of students are: "+ studentList.size());
    }

    @AfterEach
    public void tearDown() {
        student1  = student2 = null;
    }
}