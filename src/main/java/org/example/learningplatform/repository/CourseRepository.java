package org.example.learningplatform.repository;

import org.example.learningplatform.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// Репозиторий для работы с сущностью Course (курсы)
// Позволяет выполнять CRUD: создать, получить, обновить, удалить курс
@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
}
