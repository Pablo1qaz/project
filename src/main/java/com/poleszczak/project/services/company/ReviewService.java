package com.poleszczak.project.services.company;

import com.poleszczak.project.models.company.Review;
import com.poleszczak.project.repositories.company.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    // Get all reviews
    public List<Review> getAllReviews() {
        return reviewRepository.findAll();
    }

    // Get reviews by company ID
    /*public List<Review> getReviewsByCompanyId(Long companyId) {
        return reviewRepository.findByCompanyCompanyId(companyId);
    }*/

    // Get review by ID
    public Optional<Review> getReviewById(Long reviewId) {
        return reviewRepository.findById(reviewId);
    }

    // Create or update a review
    public Review saveReview(Review review) {
        return reviewRepository.save(review);
    }

    // Delete a review by ID
    public void deleteReview(Long reviewId) {
        reviewRepository.deleteById(reviewId);
    }
}

