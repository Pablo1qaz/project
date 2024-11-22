package com.poleszczak.project.repositories.company;

import com.poleszczak.project.models.company.CompanyType;
import com.poleszczak.project.models.company.Service;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceRepository extends JpaRepository<Service, Long> {}
