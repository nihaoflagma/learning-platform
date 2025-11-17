package org.example.learningplatform.service;
import org.example.learningplatform.entity.Module;
import org.example.learningplatform.entity.*;
import org.example.learningplatform.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class DataInitializer implements CommandLineRunner {

    private final UserRepository userRepository;
    private final CourseRepository courseRepository;
    private final ModuleRepository moduleRepository;
    private final LessonRepository lessonRepository;
    private final AssignmentRepository assignmentRepository;
    private final SubmissionRepository submissionRepository;

    public DataInitializer(UserRepository userRepository,
                           CourseRepository courseRepository,
                           ModuleRepository moduleRepository,
                           LessonRepository lessonRepository,
                           AssignmentRepository assignmentRepository,
                           SubmissionRepository submissionRepository) {
        this.userRepository = userRepository;
        this.courseRepository = courseRepository;
        this.moduleRepository = moduleRepository;
        this.lessonRepository = lessonRepository;
        this.assignmentRepository = assignmentRepository;
        this.submissionRepository = submissionRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // ===== Создаем пользователей =====
        User teacher = new User();
        teacher.setName("Иван Иванов");
        teacher.setEmail("teacher@example.com");
        teacher.setRole(User.Role.TEACHER);
        userRepository.save(teacher);

        User student = new User();
        student.setName("Петр Петров");
        student.setEmail("student@example.com");
        student.setRole(User.Role.STUDENT);
        userRepository.save(student);

        // ===== Создаем курс =====
        Course course = new Course();
        course.setTitle("Основы Hibernate");
        course.setDescription("Учимся работать с ORM в Java");
        course.setTeacher(teacher);
        courseRepository.save(course);

        // ===== Создаем модуль =====
        Module module = new Module();
        module.setTitle("Модуль 1: Введение в JPA");
        module.setCourse(course);
        moduleRepository.save(module);

        // ===== Создаем урок =====
        Lesson lesson = new Lesson();
        lesson.setTitle("Урок 1: Сущности и аннотации");
        lesson.setModule(module);
        lesson.setContent("Содержимое урока...");
        lessonRepository.save(lesson);

        // ===== Создаем задание =====
        Assignment assignment = new Assignment();
        assignment.setTitle("Домашнее задание 1");
        assignment.setDescription("Создать сущность User и Course");
        assignment.setDueDate(LocalDateTime.now().plusDays(7)); // теперь LocalDateTime
        assignment.setLesson(lesson);
        assignmentRepository.save(assignment);

        // ===== Студент отправляет решение =====
        Submission submission = new Submission();
        submission.setAssignment(assignment);
        submission.setStudent(student);
        submission.setContent("Мой код сущностей...");
        submission.setSubmittedAt(LocalDateTime.now()); // тоже LocalDateTime
        submissionRepository.save(submission);

        System.out.println("=== Тестовые данные успешно созданы ===");
    }
}
