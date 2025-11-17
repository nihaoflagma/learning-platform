package org.example.learningplatform.repository;

import org.example.learningplatform.entity.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// Репозиторий для уроков (Lesson)
// CRUD + поиск уроков по модулю можно добавить
@Repository
public interface LessonRepository extends JpaRepository<Lesson, Long> {
}
