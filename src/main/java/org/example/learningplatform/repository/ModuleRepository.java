package org.example.learningplatform.repository;

import org.example.learningplatform.entity.Module;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// Репозиторий для работы с модулями курса (Module)
// CRUD + поиск модулей по курсу можно добавить через @Query
@Repository
public interface ModuleRepository extends JpaRepository<Module, Long> {
}
