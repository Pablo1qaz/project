package com.poleszczak.project.repositories.company;

import com.poleszczak.project.models.company.Review;
import com.poleszczak.project.models.company.Service;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {}