package org.example.learningplatform.service;

import org.example.learningplatform.entity.QuizSubmission;
import org.example.learningplatform.entity.User;
import org.example.learningplatform.entity.Quiz;
import org.example.learningplatform.repository.QuizSubmissionRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class QuizSubmissionService {

    private final QuizSubmissionRepository quizSubmissionRepository;

    public QuizSubmissionService(QuizSubmissionRepository quizSubmissionRepository) {
        this.quizSubmissionRepository = quizSubmissionRepository;
    }

    // Сдать тест
    @Transactional
    public QuizSubmission submitQuiz(QuizSubmission submission) {
        // Можно добавить подсчет баллов, если ответы сохранены
        return quizSubmissionRepository.save(submission);
    }

    // Получить все сдачи тестов
    public List<QuizSubmission> getAllSubmissions() {
        return quizSubmissionRepository.findAll();
    }

    // Получить сдачу по ID
    public Optional<QuizSubmission> getSubmissionById(Long id) {
        return quizSubmissionRepository.findById(id);
    }

    // Получить все сдачи конкретного студента
    public List<QuizSubmission> getSubmissionsByStudent(User student) {
        return quizSubmissionRepository.findByStudent(student);
    }

    // Получить все сдачи конкретного теста
    public List<QuizSubmission> getSubmissionsByQuiz(Quiz quiz) {
        return quizSubmissionRepository.findByQuiz(quiz);
    }
}
