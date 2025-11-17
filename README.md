
# Learning Platform — Spring Boot учебная платформа с PostgreSQL и Hibernate/JPA

# Описание проекта
project:
  "Learning Platform"
  "Учебное веб-приложение для управления курсами, уроками, заданиями, тестами, пользователями и отзывами."

# Стек технологий
stack:
  - Java 17+
  - Spring Boot
  - Spring Data JPA
  - Hibernate
  - PostgreSQL
  - Maven
  - Lombok
  - Spring Web
  - JUnit / SpringBootTest

# Возможности системы
features:
  - Управление пользователями (студенты, преподаватели)
  - Профиль пользователя (One-to-One)
  - Создание курсов и назначение преподавателя
  - Модули и уроки
  - Домашние задания и отправка решений
  - Тесты, вопросы и варианты ответов
  - Прохождение тестов и сохранение результата
  - Запись студентов на курс (Enrollment)
  - Теги курсов (Many-to-Many)
  - Отзывы студентов
  - Полный набор CRUD операций
  - Интеграционные тесты

# Сущности (Entities)
entities:
  - User
  - Profile
  - Course
  - Module
  - Lesson
  - Assignment
  - Submission
  - Enrollment
  - CourseReview
  - Quiz
  - Question
  - AnswerOption
  - QuizSubmission
  - Tag
  - QuestionType

# Репозитории (Repositories)
repositories:
  - AnswerOptionRepository
  - AssignmentRepository
  - CourseRepository
  - CourseReviewRepository
  - EnrollmentRepository
  - LessonRepository
  - ModuleRepository
  - ProfileRepository
  - QuestionRepository
  - QuizRepository
  - QuizSubmissionRepository
  - SubmissionRepository
  - TagRepository
  - UserRepository

# Сервисы (Services)
services:
  - AssignmentService
  - CourseService
  - CourseReviewService
  - EnrollmentService
  - LessonService
  - ModuleService
  - QuizService
  - QuizSubmissionService
  - SubmissionService
  - UserService

# Контроллеры (REST API)
controllers:
  - AssignmentController
  - CourseController
  - CourseReviewController
  - EnrollmentController
  - LessonController
  - QuizController
  - QuizSubmissionController
  - UserController

# DTO объекты
dto:
  - AssignmentDTO
  - CourseDTO
  - CourseReviewDTO
  - EnrollmentDTO
  - LessonDTO
  - QuizDTO
  - QuizSubmissionDTO
  - UserDTO
  - ModuleDTO

# Конфигурация базы данных
database:
  type: PostgreSQL
  url: jdbc:postgresql://localhost:5432/learning_platform
  username: postgres
  password: pDamnmadam1
  hibernate_ddl_auto: update
  show_sql: true


# Запуск проекта
run:
  - Создать базу данных PostgreSQL: CREATE DATABASE learning_platform;
  - Настроить application.yml или application.properties
  - Запустить проект: mvn spring-boot:run


