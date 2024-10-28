package com.feodev.firstjobapp.review;

import java.util.List;
import java.util.Optional;

public interface ReviewService {
    List<Review> findByCompanyId(Long companyId);

    Review createNewReview(Long companyId, Review review);

    Review getReview(Long companyId, Long reviewId);

    Review updateReview(Long companyId, Long reviewId, Review review);

    Boolean deleteReviewById(Long id);
}
