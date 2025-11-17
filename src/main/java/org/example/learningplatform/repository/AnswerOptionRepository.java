package org.example.learningplatform.repository;

import org.example.learningplatform.entity.AnswerOption;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AnswerOptionRepository extends JpaRepository<AnswerOption, Long> {
}
