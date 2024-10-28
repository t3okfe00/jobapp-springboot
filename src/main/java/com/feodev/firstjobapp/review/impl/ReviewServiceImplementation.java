package com.feodev.firstjobapp.review.impl;

import com.feodev.firstjobapp.company.Company;
import com.feodev.firstjobapp.company.CompanyService;
import com.feodev.firstjobapp.job.Job;
import com.feodev.firstjobapp.job.JobRepository;
import com.feodev.firstjobapp.review.Review;
import com.feodev.firstjobapp.review.ReviewRepository;
import com.feodev.firstjobapp.review.ReviewService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ReviewServiceImplementation implements ReviewService {

    ReviewRepository reviewRepository;
    private CompanyService companyService;

    public ReviewServiceImplementation(ReviewRepository reviewRepository, CompanyService companyService) {
        this.reviewRepository = reviewRepository;
        this.companyService = companyService;
    }


    @Override
    public List<Review> findByCompanyId(Long companyId) {
        List<Review> reviews = reviewRepository.findByCompanyId(companyId);
        return reviews;
    }

    @Override
    public Review createNewReview(Long companyId, Review review) {
        Company company = companyService.getCompanyById(companyId);
        if (company != null) {
            review.setCompany(company);

            reviewRepository.save(review);
            return review;

        } else {
            return null;

        }


    }

    @Override
    public Review getReview(Long companyId, Long reviewId) {
        List<Review> reviews = reviewRepository.findByCompanyId(companyId);
        return reviews.stream().filter(review -> review.getId().equals(reviewId)).findFirst().orElse(null);

    }

    @Override

    public Review updateReview(Long companyId, Long reviewId, Review review) {
        if (companyService.getCompanyById(companyId) != null && reviewRepository.existsById(reviewId)) {
            Review reviewToUpdate = reviewRepository.findById(reviewId).orElse(null);
            if (reviewToUpdate != null) {
                reviewToUpdate.setCompany(companyService.getCompanyById(companyId));
                reviewToUpdate.setDescription(review.getDescription());
                reviewRepository.save(reviewToUpdate);
                return reviewToUpdate;
            }
            return null;

        } else {
            return null;
        }
    }

    @Override
    public Boolean deleteReviewById(Long id) {
        try {
            reviewRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }


}
