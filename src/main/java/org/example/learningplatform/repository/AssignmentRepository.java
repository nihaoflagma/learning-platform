package org.example.learningplatform.repository;

import org.example.learningplatform.entity.Assignment;
import org.example.learningplatform.entity.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AssignmentRepository extends JpaRepository<Assignment, Long> {
    List<Assignment> findByLesson(Lesson lesson);
}
