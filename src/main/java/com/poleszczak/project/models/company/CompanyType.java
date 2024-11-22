package com.poleszczak.project.models.company;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "company_types")
@Data
public class CompanyType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long companyTypeId;

    @Column(name = "type_name", nullable = false, unique = true)
    private String typeName;

    @Column
    private String description;

    @OneToMany(mappedBy = "companyType", cascade = CascadeType.ALL)
    private List<Company> companies;

    // Getters and Setters
}
