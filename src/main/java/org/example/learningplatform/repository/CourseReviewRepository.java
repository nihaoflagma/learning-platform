package org.example.learningplatform.repository;

import org.example.learningplatform.entity.Course;
import org.example.learningplatform.entity.CourseReview;
import org.example.learningplatform.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseReviewRepository extends JpaRepository<CourseReview, Long> {

    
    List<CourseReview> findByCourse(Course course);

    
    List<CourseReview> findByStudent(User student);
}
