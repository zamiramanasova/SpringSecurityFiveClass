package com.example.springsecurityfivecass.controller;

import com.example.springsecurityfivecass.entity.Course;
import com.example.springsecurityfivecass.exception.EntityNotFoundException;
import com.example.springsecurityfivecass.service.CompanyService;
import com.example.springsecurityfivecass.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/course")
public class CourseController {

    private final CourseService courseService;

    @GetMapping()
    public String list(Model model) {
        List<Course> courseList = courseService.getAllCourse();
        model.addAttribute("courseList", courseList);
        return "views/course/list";
    }

    @GetMapping("/new")
    public String newCourse(Model model) {
        Course course = new Course();
        model.addAttribute("course", course);
        return "views/course/new_course";
    }

    @PostMapping()
    public String save(@ModelAttribute("course") Course course) {
        courseService.save(course);
        return "redirect:course";
    }

    @GetMapping("/cour/{id}")
    public String getById(@PathVariable("id") Long id, Model model) throws EntityNotFoundException {
        model.addAttribute("course", courseService.getById(id));
        return "views/course/show";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, Model model) throws EntityNotFoundException{
        Course course = courseService.getById(id);
        model.addAttribute("course", course);
        return "views/course/edit";
    }

    @PostMapping("/update/{id}")
    public String update(Course course) throws EntityNotFoundException{
        courseService.update(course);
        return "redirect:/course";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id){
        courseService.delete(id);
        return "redirect:/course";
    }
}
