package com.poleszczak.project.models.company;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "services")
@Data
public class Service {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long serviceId;

    @Column(nullable = false)
    private String serviceName;

    @Column
    private String description;

    @Column
    private String priceRange;

    @ManyToMany(mappedBy = "services")
    private List<Company> companies;

    // Getters and Setters
}

