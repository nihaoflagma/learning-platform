package org.example.learningplatform.repository;

import org.example.learningplatform.entity.Course;
import org.example.learningplatform.entity.Enrollment;
import org.example.learningplatform.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EnrollmentRepository extends JpaRepository<Enrollment, Long> {

    boolean existsByCourseAndStudent(Course course, User student);

    List<Enrollment> findByStudent(User student);

    List<Enrollment> findByCourse(Course course);

    Optional<Enrollment> findByCourseAndStudent(Course course, User student);
}
