package com.example.springsecurityfivecass.service;

import com.example.springsecurityfivecass.entity.Company;
import com.example.springsecurityfivecass.repository.CompanyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CompanyService {

    private final CompanyRepository companyrepository;

    public List<Company> getAllCompany(){
        return companyrepository.findAll();
    }

    public Company save(Company company){
        companyrepository.save(company);
        return company;
    }

    public Company update(Company company){
        companyrepository.save(company);
        return company;
    }

    public Company getById(Long id){
        return companyrepository.findById(id).get();
    }

    public void delete(Long id){
        companyrepository.deleteById(id);
    }
}
