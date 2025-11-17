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

    
    public List<Quiz> getAllQuizzes() {
        return quizRepository.findAll();
    }

    
    public Optional<Quiz> getQuizById(Long id) {
        return quizRepository.findById(id);
    }

    
    public Quiz createQuiz(Quiz quiz) {
        return quizRepository.save(quiz);
    }

    
    public Quiz updateQuiz(Quiz quiz) {
        return quizRepository.save(quiz);
    }

    // Удалить тест
    public void deleteQuiz(Long id) {
        quizRepository.deleteById(id);
    }
}
