package com.feodev.firstjobapp.company;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public interface CompanyService {
    List<Company> findAll();

    Company createCompany(Company company);

    Company getCompanyById(Long id);


    boolean deleteCompanyById(Long id);

    Company updateCompanyById(Long id, Company company);

}
