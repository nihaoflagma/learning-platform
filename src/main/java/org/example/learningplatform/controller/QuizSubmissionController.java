package org.example.learningplatform.controller;

import org.example.learningplatform.entity.Quiz;
import org.example.learningplatform.entity.QuizSubmission;
import org.example.learningplatform.entity.User;
import org.example.learningplatform.service.QuizService;
import org.example.learningplatform.service.QuizSubmissionService;
import org.example.learningplatform.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/quiz-submissions")
public class QuizSubmissionController {

    private final QuizSubmissionService quizSubmissionService;
    private final QuizService quizService;
    private final UserService userService;

    public QuizSubmissionController(QuizSubmissionService quizSubmissionService,
                                    QuizService quizService,
                                    UserService userService) {
        this.quizSubmissionService = quizSubmissionService;
        this.quizService = quizService;
        this.userService = userService;
    }

    // Студент сдает тест
    @PostMapping("/submit")
    public QuizSubmission submitQuiz(@RequestParam Long quizId,
                                     @RequestParam Long studentId,
                                     @RequestBody String answers) {
        Quiz quiz = quizService.getQuizById(quizId)
                .orElseThrow(() -> new RuntimeException("Тест не найден"));
        User student = userService.getUserById(studentId)
                .orElseThrow(() -> new RuntimeException("Студент не найден"));

        QuizSubmission submission = new QuizSubmission();
        submission.setQuiz(quiz);
        submission.setStudent(student);
        submission.setAnswers(answers);
        submission.setSubmittedAt(LocalDateTime.now());

        return quizSubmissionService.submitQuiz(submission);
    }

    // Получить все решения студента
    @GetMapping("/student/{studentId}")
    public List<QuizSubmission> getStudentSubmissions(@PathVariable Long studentId) {
        User student = userService.getUserById(studentId)
                .orElseThrow(() -> new RuntimeException("Студент не найден"));
        return student.getQuizSubmissions();
    }
}
