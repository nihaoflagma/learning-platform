package org.example.learningplatform.controller;

import org.example.learningplatform.entity.Course;
import org.example.learningplatform.entity.User;
import org.example.learningplatform.service.EnrollmentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/enrollments")
public class EnrollmentController {

    private final EnrollmentService enrollmentService;

    public EnrollmentController(EnrollmentService enrollmentService) {
        this.enrollmentService = enrollmentService;
    }

    // Записать студента на курс
    @PostMapping("/enroll")
    public String enrollStudent(@RequestParam Long courseId, @RequestParam Long studentId) {
        enrollmentService.enrollStudent(courseId, studentId);
        return "Студент записан на курс";
    }

    // Отписать студента от курса
    @PostMapping("/unenroll")
    public String unenrollStudent(@RequestParam Long courseId, @RequestParam Long studentId) {
        enrollmentService.unenrollStudent(courseId, studentId);
        return "Студент отписан от курса";
    }

    // Получить всех студентов курса
    @GetMapping("/course/{courseId}/students")
    public List<User> getStudentsInCourse(@PathVariable Long courseId) {
        return enrollmentService.getStudentsInCourse(courseId);
    }

    // Получить все курсы студента
    @GetMapping("/student/{studentId}/courses")
    public List<Course> getCoursesOfStudent(@PathVariable Long studentId) {
        return enrollmentService.getCoursesOfStudent(studentId);
    }
}
