package com.poleszczak.project.models;


import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name="users")
@Data
public class NewUsers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;

    private String firstName;
    private String lastName;

    @Column(unique = true, nullable = false)
    private String email;

    private String phoneNumber;
    private String address;
    private String password;
    private String role;
    private Date createdAt;
}
