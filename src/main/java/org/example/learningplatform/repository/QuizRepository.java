package org.example.learningplatform.repository;

import org.example.learningplatform.entity.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// Репозиторий для тестов/викторин (Quiz)
// CRUD операции
@Repository
public interface QuizRepository extends JpaRepository<Quiz, Long> {
}
