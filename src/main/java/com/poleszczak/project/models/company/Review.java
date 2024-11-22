package com.poleszczak.project.models.company;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "reviews")
@Data
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reviewId;

    @ManyToOne
    @JoinColumn(name = "company_id", nullable = false)
    private Company company;

    @Column(nullable = false)
    private String reviewerName;

    @Column
    private String reviewText;

    @Column(nullable = false)
    private int rating;

    @Column
    private LocalDateTime reviewDate;

    @PrePersist
    public void prePersist() {
        this.reviewDate = LocalDateTime.now();
    }

    // Getters and Setters
}

