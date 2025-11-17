package org.example.learningplatform.repository;

import org.example.learningplatform.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// Репозиторий для работы с пользователями (User)
// CRUD операции + можно добавить поиск по email, роли и т.д.
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
