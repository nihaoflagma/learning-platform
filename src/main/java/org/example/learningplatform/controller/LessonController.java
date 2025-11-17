package org.example.learningplatform.controller;

import org.example.learningplatform.entity.Lesson;
import org.example.learningplatform.entity.Assignment;
import org.example.learningplatform.entity.Quiz;
import org.example.learningplatform.service.LessonService;
import org.example.learningplatform.service.AssignmentService;
import org.example.learningplatform.service.QuizService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/lessons")
public class LessonController {

    private final LessonService lessonService;
    private final AssignmentService assignmentService;
    private final QuizService quizService;

    public LessonController(LessonService lessonService,
                            AssignmentService assignmentService,
                            QuizService quizService) {
        this.lessonService = lessonService;
        this.assignmentService = assignmentService;
        this.quizService = quizService;
    }

    
    @GetMapping
    public List<Lesson> getAllLessons() {
        return lessonService.getAllLessons();
    }

    
    @GetMapping("/{id}")
    public Lesson getLesson(@PathVariable Long id) {
        return lessonService.getLessonById(id)
                .orElseThrow(() -> new RuntimeException("Урок не найден"));
    }

    
    @GetMapping("/{id}/assignments")
    public List<Assignment> getAssignmentsOfLesson(@PathVariable Long id) {
        Lesson lesson = lessonService.getLessonById(id)
                .orElseThrow(() -> new RuntimeException("Урок не найден"));
        return assignmentService.getAllAssignments()
                .stream()
                .filter(a -> a.getLesson().getId().equals(lesson.getId()))
                .collect(Collectors.toList());
    }

    
    @GetMapping("/{id}/quizzes")
    public List<Quiz> getQuizzesOfLesson(@PathVariable Long id) {
        Lesson lesson = lessonService.getLessonById(id)
                .orElseThrow(() -> new RuntimeException("Урок не найден"));
        return quizService.getAllQuizzes()
                .stream()
                .filter(q -> q.getLesson().getId().equals(lesson.getId()))
                .collect(Collectors.toList());
    }
}
