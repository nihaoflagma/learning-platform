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

    // Найти все сдачи конкретного студента
    List<QuizSubmission> findByStudent(User student);

    // Найти все сдачи конкретного теста
    List<QuizSubmission> findByQuiz(Quiz quiz);

    // Найти сдачу студента на конкретный тест (одна попытка)
    Optional<QuizSubmission> findByStudentAndQuiz(User student, Quiz quiz);
}
