package org.example.learningplatform.repository;

import org.example.learningplatform.entity.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// Репозиторий для профиля пользователя (Profile)
// CRUD операции
@Repository
public interface ProfileRepository extends JpaRepository<Profile, Long> {
}
