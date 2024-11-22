package com.poleszczak.project.models.company;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "companies")
@Data
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long companyId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String contactEmail;

    @Column
    private String contactPhone;

    @Column
    private String address;

    @Column
    private String website;

    @ManyToOne
    @JoinColumn(name = "company_type_id")
    private CompanyType companyType;

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL)
    private List<Review> reviews;

    @ManyToMany
    @JoinTable(
            name = "company_services",
            joinColumns = @JoinColumn(name = "company_id"),
            inverseJoinColumns = @JoinColumn(name = "service_id")
    )
    private List<Service> services;

    // Getters and Setters
}
