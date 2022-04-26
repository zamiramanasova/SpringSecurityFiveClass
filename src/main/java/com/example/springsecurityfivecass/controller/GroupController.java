package com.example.springsecurityfivecass.controller;

import com.example.springsecurityfivecass.entity.Group;
import com.example.springsecurityfivecass.exception.EntityNotFoundException;
import com.example.springsecurityfivecass.service.GroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("group")
public class GroupController {

    private final GroupService groupService;

    @GetMapping()
    public String index(Model model) {
        List<Group> groupList = groupService.getAllGroup();
        model.addAttribute("groupList", groupList);
        return "views/group/index";
    }

    @GetMapping("/new")
    public String newGroup(Model model) {
        Group group = new Group();
        model.addAttribute("group", group);
        return "views/group/new_group";
    }

    @PostMapping()
    public String save(@ModelAttribute("group")Group group) throws EntityNotFoundException {
        groupService.save(group);
        return "redirect:group";
    }

    @GetMapping("/gro/{id}")
    public String getById(@PathVariable("id") Long id, Model model) {
        model.addAttribute("group", groupService.getById(id));
        return "views/group/show";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, Model model) throws EntityNotFoundException{
        Group group = groupService.getById(id);
        model.addAttribute("group", group);
        return "views/group/edit";
    }

    @PostMapping("/update/{id}")
    public String update(Group group) throws EntityNotFoundException{
        groupService.update(group);
        return "redirect:/group";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id){
        groupService.delete(id);
        return "redirect:/group";
    }
}
