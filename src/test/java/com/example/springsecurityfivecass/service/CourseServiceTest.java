package com.example.springsecurityfivecass.service;

import com.example.springsecurityfivecass.entity.Company;
import com.example.springsecurityfivecass.entity.Course;
import com.example.springsecurityfivecass.entity.mappers.CourseMapper;
import com.example.springsecurityfivecass.repository.CourseRepository;
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
class CourseServiceTest {

    @Autowired
    @InjectMocks
    private CourseService courseService;

    @Mock
    private CourseRepository courseRepository;
    @Mock
    private CourseMapper courseMapper;

    private Course course1;
    private Course course2;
    private Company company1;

    @BeforeEach
    public void setup() {
        company1 = new Company(1L,"Yandex","Russia",null);
        course1 = new Course(1L,"Java",9,null,null);
        course2 = new Course(2L,"JavaScript",9,null,null);

    }

    @Test
    @Order(1)
    @DisplayName("JUnit test for {1} should save Course")
    void shouldSaveCourseAfterCreat() {
        Mockito.when(courseMapper.mapToEntity(course1)).thenReturn(course1);
        courseService.save(course1);

        Mockito.verify(courseRepository, Mockito.times(1))
                .save(ArgumentMatchers.any(Course.class));
        System.out.println("Course " + course1 + " saved successfully! ");
    }

    @Test
    @Order(2)
    @DisplayName("JUnit test for {2} should update Course by id")
    void shouldUpdateCourse() {
        course1.setCourseName("PHP");

        Mockito.when(courseRepository.save(course1)).thenReturn(course1);
        courseService.update(course1);

        Mockito.verify(courseRepository, Mockito.times(1))
                .save(ArgumentMatchers.any(Course.class));

        System.out.println("Course " + course1.getCourseName() + " updated successfully! ");

    }

    @Test
    @Order(3)
    @DisplayName("JUnit test for {3} should find Course by id")
    void shouldGetByIdCourse() {
        Mockito.when(courseRepository.findById(1L)).thenReturn(Optional.of(course1));
        Course course = courseService.getById(1L);

        org.assertj.core.api.Assertions.assertThat(course.getId()).isEqualTo(course1.getId());
        org.assertj.core.api.Assertions.assertThat(course.getCourseName()).isEqualTo(course1.getCourseName());

        System.out.println("Course get id:" + course1.getId() + " , " + course1.getCourseName() + " successfully! ");

    }

    @Test
    @Order(4)
    @DisplayName("JUnit test for {4} delete Course by id")
    void shouldDeleteCourse() {
        courseService.delete(1L);

        System.out.println("Course get id:" + course1.getId() + " deleted successfully! ");

    }

    @Test
    @Order(5)
    @DisplayName("JUnit test for {5} should get all Course")
    void shouldGetAllCourse() {
        List<Course> courseList = new ArrayList<>();
        courseList.add(course1);
        courseList.add(course2);

        Mockito.when(courseRepository.findAll()).thenReturn(courseList);
        courseService.getAllCourse();

        org.assertj.core.api.Assertions.assertThat(courseList.size()).isEqualTo(2);

        System.out.println("In the list of courses are: "+ courseList.size());
    }

    @AfterEach
    public void tearDown() {
        course1  = course2 = null;
    }
}