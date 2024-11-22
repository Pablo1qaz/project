package com.poleszczak.project.repositories.company;

import com.poleszczak.project.models.NewUsers;
import com.poleszczak.project.models.company.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {

    public Company findByContactEmail(String contactEmail);
}
