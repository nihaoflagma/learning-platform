package org.example.learningplatform.service;

import org.example.learningplatform.entity.Course;
import org.example.learningplatform.entity.CourseReview;
import org.example.learningplatform.repository.CourseReviewRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseReviewService {

    private final CourseReviewRepository reviewRepository;

    public CourseReviewService(CourseReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    
    public List<CourseReview> getAllReviews() {
        return reviewRepository.findAll();
    }

    
    public List<CourseReview> getReviewsByCourse(Course course) {
        return reviewRepository.findByCourse(course);
    }

   
    public CourseReview createReview(CourseReview review) {
        return reviewRepository.save(review);
    }

    
    public void deleteReview(Long id) {
        reviewRepository.deleteById(id);
    }

    
    public Optional<CourseReview> getReviewById(Long id) {
        return reviewRepository.findById(id);
    }
}
