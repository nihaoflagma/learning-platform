package org.example.learningplatform.service;

import org.example.learningplatform.entity.Quiz;
import org.example.learningplatform.repository.QuizRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuizService {

    private final QuizRepository quizRepository;

    public QuizService(QuizRepository quizRepository) {
        this.quizRepository = quizRepository;
    }

    // Получить все тесты
    public List<Quiz> getAllQuizzes() {
        return quizRepository.findAll();
    }

    // Получить тест по ID
    public Optional<Quiz> getQuizById(Long id) {
        return quizRepository.findById(id);
    }

    // Создать новый тест
    public Quiz createQuiz(Quiz quiz) {
        return quizRepository.save(quiz);
    }

    // Обновить тест
    public Quiz updateQuiz(Quiz quiz) {
        return quizRepository.save(quiz);
    }

    // Удалить тест
    public void deleteQuiz(Long id) {
        quizRepository.deleteById(id);
    }
}
