package org.example.learningplatform;

import org.example.learningplatform.entity.*;
import org.example.learningplatform.entity.User.Role;
import org.example.learningplatform.entity.QuestionType;
import org.example.learningplatform.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootApplication
public class LearningPlatformApplication {

    public static void main(String[] args) {
        SpringApplication.run(LearningPlatformApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(UserRepository userRepository,
                             CourseRepository courseRepository,
                             ModuleRepository moduleRepository,
                             LessonRepository lessonRepository,
                             AssignmentRepository assignmentRepository,
                             EnrollmentRepository enrollmentRepository,
                             QuizRepository quizRepository,
                             QuestionRepository questionRepository,
                             AnswerOptionRepository answerOptionRepository,
                             QuizSubmissionRepository quizSubmissionRepository) {
        return args -> {

            // Создаем пользователей
            User teacher = User.builder()
                    .name("Иван Иванов")
                    .email("ivan@example.com")
                    .role(Role.TEACHER)
                    .build();
            userRepository.save(teacher);

            User student1 = User.builder()
                    .name("Петр Петров")
                    .email("petr@example.com")
                    .role(Role.STUDENT)
                    .build();
            userRepository.save(student1);

            User student2 = User.builder()
                    .name("Сергей Сергеев")
                    .email("sergey@example.com")
                    .role(Role.STUDENT)
                    .build();
            userRepository.save(student2);

            // Создаем курс
            Course course = Course.builder()
                    .title("Основы Hibernate")
                    .description("Курс по Hibernate и JPA")
                    .teacher(teacher)
                    .build();
            courseRepository.save(course);

            // Создаем модули курса
            org.example.learningplatform.entity.Module module1 = org.example.learningplatform.entity.Module.builder()
                    .title("Введение")
                    .course(course)
                    .build();
            moduleRepository.save(module1);

            org.example.learningplatform.entity.Module module2 = org.example.learningplatform.entity.Module.builder()
                    .title("Продвинутые темы")
                    .course(course)
                    .build();
            moduleRepository.save(module2);

            // Создаем уроки
            Lesson lesson1 = Lesson.builder()
                    .title("Урок 1")
                    .content("Содержание урока 1")
                    .module(module1)
                    .build();
            lessonRepository.save(lesson1);

            Lesson lesson2 = Lesson.builder()
                    .title("Урок 2")
                    .content("Содержание урока 2")
                    .module(module2)
                    .build();
            lessonRepository.save(lesson2);

            // Создаем задание
            Assignment assignment1 = Assignment.builder()
                    .title("Домашнее задание 1")
                    .description("Выполнить упражнение")
                    .lesson(lesson1)
                    .build();
            assignmentRepository.save(assignment1);

            // Создаем записи на курс
            Enrollment enrollment1 = Enrollment.builder()
                    .course(course)
                    .student(student1)
                    .enrolledAt(LocalDateTime.now())
                    .build();
            enrollmentRepository.save(enrollment1);

            Enrollment enrollment2 = Enrollment.builder()
                    .course(course)
                    .student(student2)
                    .enrolledAt(LocalDateTime.now())
                    .build();
            enrollmentRepository.save(enrollment2);

            // Создаем тест
            Quiz quiz = Quiz.builder()
                    .title("Тест по модулю 1")
                    .module(module1)
                    .build();
            quizRepository.save(quiz);

            // Создаем вопросы
            Question question1 = Question.builder()
                    .text("Что такое JPA?")
                    .quiz(quiz)
                    .type(QuestionType.SINGLE_CHOICE)
                    .build();
            questionRepository.save(question1);

            // Создаем варианты ответов
            AnswerOption option1 = AnswerOption.builder()
                    .text("Java Persistence API")
                    .question(question1)
                    .correct(true)
                    .build();
            answerOptionRepository.save(option1);

            AnswerOption option2 = AnswerOption.builder()
                    .text("Java Personal Application")
                    .question(question1)
                    .correct(false)
                    .build();
            answerOptionRepository.save(option2);

            // Сохраняем результат прохождения теста
            QuizSubmission submission = QuizSubmission.builder()
                    .quiz(quiz)
                    .student(student1)
                    .score(100.0)
                    .submittedAt(LocalDateTime.now())
                    .build();
            quizSubmissionRepository.save(submission);

            System.out.println("Тестовые данные успешно созданы!");
        };
    }
}
