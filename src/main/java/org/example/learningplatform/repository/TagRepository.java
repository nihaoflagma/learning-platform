package org.example.learningplatform.repository;

import org.example.learningplatform.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// Репозиторий для тегов (Tag), которые прикрепляются к курсам
// CRUD операции
@Repository
public interface TagRepository extends JpaRepository<Tag, Long> {
}
