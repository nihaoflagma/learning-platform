package org.example.learningplatform.repository;

import org.example.learningplatform.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// Репозиторий для вопросов теста (Question)
// CRUD операции
@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {
}
