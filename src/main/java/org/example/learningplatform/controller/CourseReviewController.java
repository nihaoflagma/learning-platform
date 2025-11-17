package org.example.learningplatform.controller;

import org.example.learningplatform.entity.Course;
import org.example.learningplatform.entity.CourseReview;
import org.example.learningplatform.entity.User;
import org.example.learningplatform.repository.CourseRepository;
import org.example.learningplatform.repository.CourseReviewRepository;
import org.example.learningplatform.repository.UserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reviews")
public class CourseReviewController {

    private final CourseReviewRepository reviewRepository;
    private final CourseRepository courseRepository;
    private final UserRepository userRepository;

    public CourseReviewController(CourseReviewRepository reviewRepository,
                                  CourseRepository courseRepository,
                                  UserRepository userRepository) {
        this.reviewRepository = reviewRepository;
        this.courseRepository = courseRepository;
        this.userRepository = userRepository;
    }

    // Создать новый отзыв
    @PostMapping("/course/{courseId}/student/{studentId}")
    public CourseReview createReview(@PathVariable Long courseId,
                                     @PathVariable Long studentId,
                                     @RequestParam int rating,
                                     @RequestParam String comment) {

        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new RuntimeException("Курс не найден"));
        User student = userRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Студент не найден"));

        CourseReview review = new CourseReview();
        review.setCourse(course);
        review.setStudent(student); // исправлено
        review.setRating(rating);
        review.setComment(comment); // исправлено

        return reviewRepository.save(review);
    }

    // Получить все отзывы
    @GetMapping
    public List<CourseReview> getAllReviews() {
        return reviewRepository.findAll();
    }

    // Получить отзывы по курсу
    @GetMapping("/course/{courseId}")
    public List<CourseReview> getReviewsByCourse(@PathVariable Long courseId) {
        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new RuntimeException("Курс не найден"));
        return reviewRepository.findByCourse(course);
    }

    // Получить отзывы студента
    @GetMapping("/student/{studentId}")
    public List<CourseReview> getReviewsByStudent(@PathVariable Long studentId) {
        User student = userRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Студент не найден"));
        return reviewRepository.findByStudent(student);
    }

    // Удалить отзыв
    @DeleteMapping("/{reviewId}")
    public void deleteReview(@PathVariable Long reviewId) {
        reviewRepository.deleteById(reviewId);
    }
}
