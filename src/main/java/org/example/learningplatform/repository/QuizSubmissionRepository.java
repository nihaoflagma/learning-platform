package org.example.learningplatform.repository;

import org.example.learningplatform.entity.Quiz;
import org.example.learningplatform.entity.QuizSubmission;
import org.example.learningplatform.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface QuizSubmissionRepository extends JpaRepository<QuizSubmission, Long> {

    
    List<QuizSubmission> findByStudent(User student);

    
    List<QuizSubmission> findByQuiz(Quiz quiz);

    
    Optional<QuizSubmission> findByStudentAndQuiz(User student, Quiz quiz);
}
