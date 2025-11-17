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

   
    @Transactional
    public QuizSubmission submitQuiz(QuizSubmission submission) {
        
        return quizSubmissionRepository.save(submission);
    }

    
    public List<QuizSubmission> getAllSubmissions() {
        return quizSubmissionRepository.findAll();
    }

    
    public Optional<QuizSubmission> getSubmissionById(Long id) {
        return quizSubmissionRepository.findById(id);
    }

    
    public List<QuizSubmission> getSubmissionsByStudent(User student) {
        return quizSubmissionRepository.findByStudent(student);
    }

    
    public List<QuizSubmission> getSubmissionsByQuiz(Quiz quiz) {
        return quizSubmissionRepository.findByQuiz(quiz);
    }
}
