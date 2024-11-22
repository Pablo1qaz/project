package com.poleszczak.project.services.company;

import com.poleszczak.project.models.company.Company;
import com.poleszczak.project.repositories.company.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    // Get all companies
    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

    // Get company by ID
    public Optional<Company> getCompanyById(Long companyId) {
        return companyRepository.findById(companyId);
    }

    // Create or update a company
    public Company saveCompany(Company company) {
        return companyRepository.save(company);
    }

    // Delete a company by ID
    public void deleteCompany(Long companyId) {
        companyRepository.deleteById(companyId);
    }
}

