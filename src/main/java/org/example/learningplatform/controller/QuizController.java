package org.example.learningplatform.controller;

import org.example.learningplatform.entity.Quiz;
import org.example.learningplatform.entity.Lesson;
import org.example.learningplatform.service.QuizService;
import org.example.learningplatform.service.LessonService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/quizzes")
public class QuizController {

    private final QuizService quizService;
    private final LessonService lessonService;

    public QuizController(QuizService quizService, LessonService lessonService) {
        this.quizService = quizService;
        this.lessonService = lessonService;
    }

    
    @GetMapping
    public List<Quiz> getAllQuizzes() {
        return quizService.getAllQuizzes();
    }

    
    @GetMapping("/{id}")
    public Quiz getQuiz(@PathVariable Long id) {
        return quizService.getQuizById(id)
                .orElseThrow(() -> new RuntimeException("Тест не найден"));
    }

    
    @GetMapping("/lesson/{lessonId}")
    public List<Quiz> getQuizzesByLesson(@PathVariable Long lessonId) {
        Lesson lesson = lessonService.getLessonById(lessonId)
                .orElseThrow(() -> new RuntimeException("Урок не найден"));
        return quizService.getAllQuizzes()
                .stream()
                .filter(q -> q.getLesson().getId().equals(lesson.getId()))
                .toList();
    }
}
