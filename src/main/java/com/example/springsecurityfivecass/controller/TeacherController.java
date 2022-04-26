package com.example.springsecurityfivecass.controller;

import com.example.springsecurityfivecass.entity.Teacher;
import com.example.springsecurityfivecass.exception.EntityNotFoundException;
import com.example.springsecurityfivecass.service.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/teacher")
public class TeacherController {

    private final TeacherService teacherService;

    @GetMapping()
    public String index(Model model) {
        List<Teacher> teacherList = teacherService.getAllTeacher();
        model.addAttribute("teacherList", teacherList);
        return "views/teacher/index";
    }

    @GetMapping("/new")
    public String newTeacher(Model model) {
        Teacher teacher = new Teacher();
        model.addAttribute("teacher", teacher);
        return "views/teacher/new_teacher";
    }

    @PostMapping()
    public String save(@ModelAttribute("teacher") Teacher teacher) throws EntityNotFoundException {
        teacherService.save(teacher);
        return "redirect:teacher";
    }

    @GetMapping("/teach/{id}")
    public String getById(@PathVariable("id") Long id, Model model) {
        model.addAttribute("teacher", teacherService.getById(id));
        return "views/teacher/show";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, Model model) throws EntityNotFoundException{
        Teacher teacher = teacherService.getById(id);
        model.addAttribute("teacher", teacher);
        return "views/teacher/edit";
    }

    @PostMapping("/update/{id}")
    public String update(Teacher teacher) throws EntityNotFoundException{
        teacherService.update(teacher);
        return "redirect:/teacher";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id){
        teacherService.delete(id);
        return "redirect:/teacher";
    }
}
