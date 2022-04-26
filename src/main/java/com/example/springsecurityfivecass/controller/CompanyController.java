package com.example.springsecurityfivecass.controller;

import com.example.springsecurityfivecass.entity.Company;
import com.example.springsecurityfivecass.exception.EntityNotFoundException;
import com.example.springsecurityfivecass.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("company")
public class CompanyController {

    private final CompanyService companyService;

    @GetMapping()
    public String index(Model model) {
        List<Company> companyList = companyService.getAllCompany();
        model.addAttribute("companyList", companyList);
        return "views/company/index";
    }

    @GetMapping("/new")
    public String newCompany(Model model){
            model.addAttribute("company", new Company());
        return "views/company/new_company";
    }

    @PostMapping()
    public String save(@ModelAttribute("company") Company company) throws EntityNotFoundException {
            companyService.save(company);
        return "redirect:company";
    }

    @GetMapping("/comp/{id}")
    public String getById(@PathVariable("id") Long id, Model model) throws EntityNotFoundException{
        model.addAttribute("company", companyService.getById(id));
        return "views/company/show";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, Model model){
        Company company = companyService.getById(id);
        model.addAttribute("company", company);
        return "views/company/edit";
    }

    @PostMapping("/update/{id}")
    public String update(Company company){
        companyService.update(company);
        return "redirect:/company";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id){
        companyService.delete(id);
        return "redirect:/company";
    }

}

