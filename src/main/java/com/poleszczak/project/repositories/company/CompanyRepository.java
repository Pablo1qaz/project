package com.poleszczak.project.repositories.company;

import com.poleszczak.project.models.NewUsers;
import com.poleszczak.project.models.company.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {

    public Company findByContactEmail(String contactEmail);

    public List<Company> findByCompanyTypeTypeName(String type);
}
