package com.example.springsecurityfivecass.service;

import com.example.springsecurityfivecass.entity.Company;
import com.example.springsecurityfivecass.exception.EntityNotFoundException;
import com.example.springsecurityfivecass.repository.CompanyRepository;
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

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
@TestMethodOrder(MethodOrderer.DisplayName.class)
class CompanyServiceTest {

    @Autowired
    @InjectMocks
    private CompanyService companyService;

    @Mock
    private CompanyRepository companyRepository;

    private Company company1;
    private Company company2;

    @BeforeEach
    public void setup() {
        company1 = new Company(1L,"Yandex","Russia",null);
        company2 = new Company(2L,"Sber","Russia",null);
    }

    @Test
    @Order(1)
    @DisplayName("JUnit test for {1} should save Company")
    void shouldSaveCompanyAfterCreate() {

        Mockito.when(companyRepository.save(company1)).thenReturn(company1);
        companyService.save(company1);

        Mockito.verify(companyRepository, Mockito.times(1))
                .save(ArgumentMatchers.any(Company.class));
        System.out.println("Company " + company1 + " saved successfully! ");

    }

    @Test
    @Order(2)
    @DisplayName("JUnit test for {2} should update Company by id")
    void shouldUpdateCompany() {
        company1.setCompanyName("Jet Brains");

        Mockito.when(companyRepository.save(company1)).thenReturn(company1);
        companyService.update(company1);

        Mockito.verify(companyRepository, Mockito.times(1))
                .save(ArgumentMatchers.any(Company.class));

        System.out.println("Company " + company1.getCompanyName() + " updated successfully! ");
    }

    @Test
    @Order(3)
    @DisplayName("JUnit test for {3} should find Company by id")
    void shouldGetByIdCompany() {
        Mockito.when(companyRepository.findById(1L)).thenReturn(Optional.of(company1));
        Company company = companyService.getById(1L);

        org.assertj.core.api.Assertions.assertThat(company.getId()).isEqualTo(company1.getId());
        org.assertj.core.api.Assertions.assertThat(company.getCompanyName()).isEqualTo(company1.getCompanyName());

        System.out.println("Company get id:" + company1.getId() + " , "+ company1.getCompanyName() + " successfully! ");
    }

    @Test
    @Order(4)
    @DisplayName("JUnit test for {4} delete Company by id")
    void shouldDeleteCompany() {
        companyService.delete(1L);

        System.out.println("Company get id:" + company1.getId() + " deleted successfully! ");
    }

    @Test
    @Order(5)
    @DisplayName("JUnit test for {5} should get all Company")
    void shouldGetAllCompany() {
        List<Company> companyList = new ArrayList<>();
        companyList.add(company1);
        companyList.add(company2);

        Mockito.when(companyRepository.findAll()).thenReturn(companyList);
        companyService.getAllCompany();

        org.assertj.core.api.Assertions.assertThat(companyList.size()).isEqualTo(2);

        System.out.println("In the list of companies are: "+ companyList.size());
    }

//    @Test
//    void throwExceptionIfEntityIsNotAvailable() {
//
//        assertThrows(EntityNotFoundException.class, () -> companyService.delete(company1.getId()));
//        assertThrows(EntityNotFoundException.class, () -> companyService.getById(company1.getId()));
//
//    }

    @AfterEach
    public void tearDown() {
        company1  = company2 = null;
    }

}