package com.example.springsecurityfivecass.controller;

import com.example.springsecurityfivecass.entity.Student;
import com.example.springsecurityfivecass.exception.EntityNotFoundException;
import com.example.springsecurityfivecass.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("student")
public class StudentController {

    public final StudentService studentService;

    @GetMapping()
    public String index(Model model) {
        List<Student> studentList = studentService.getAllStudent();
        model.addAttribute("studentList", studentList);
        return "views/student/index";
    }

    @GetMapping("/new")
    public String newStudent(Model model) {
        Student student = new Student();
        model.addAttribute("student", student);
        return "views/student/new_student";
    }

    @PostMapping()
    public String save(@ModelAttribute("student") Student student) throws EntityNotFoundException {
        studentService.save(student);
        return "redirect:student";
    }

    @GetMapping("/study/{id}")
    public String getById(@PathVariable("id") Long id, Model model) {
        model.addAttribute("student", studentService.getById(id));
        return "views/student/show";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, Model model) throws EntityNotFoundException{
        Student student = studentService.getById(id);
        model.addAttribute("student", student);
        return "views/student/edit";
    }

    @PostMapping("/update/{id}")
    public String update(Student student) throws EntityNotFoundException{
        studentService.update(student);
        return "redirect:/student";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id){
        studentService.delete(id);
        return "redirect:/student";
    }

    @GetMapping("/search/name/{name}")
    public String getByNameStudent(@PathVariable("name") String name, Model model) {
        Student students = studentService.findStudentsByFirstName(name);
        model.addAttribute("students",students);
        return "views/student/show_by_name";
    }

    @GetMapping("/count")
    public Long countStudent(){
        Long count = studentService.countStudent();
        return count;
    }

}

