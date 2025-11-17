package org.example.learningplatform.service;

import org.example.learningplatform.entity.Course;
import org.example.learningplatform.entity.Module;
import org.example.learningplatform.repository.CourseRepository;
import org.example.learningplatform.repository.ModuleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    private final CourseRepository courseRepository;
    private final ModuleRepository moduleRepository;

    public CourseService(CourseRepository courseRepository, ModuleRepository moduleRepository) {
        this.courseRepository = courseRepository;
        this.moduleRepository = moduleRepository;
    }

    // Получить все курсы
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    // Получить курс по ID
    public Optional<Course> getCourseById(Long id) {
        return courseRepository.findById(id);
    }

    // Создать новый курс
    public Course createCourse(Course course) {
        return courseRepository.save(course);
    }

    // Обновить курс
    public Course updateCourse(Course course) {
        return courseRepository.save(course);
    }

    // Удалить курс по ID
    public void deleteCourse(Long id) {
        courseRepository.deleteById(id);
    }

    // Добавить модуль к курсу
    public Module addModuleToCourse(Long courseId, Module module) {
        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new RuntimeException("Course not found"));
        module.setCourse(course);
        return moduleRepository.save(module);
    }

    // Получить курс с модулями и уроками (инициализация ленивых коллекций)
    public Course getCourseWithModulesAndLessons(Long courseId) {
        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new RuntimeException("Course not found"));
        course.getModules().forEach(m -> m.getLessons().size()); // ленивые коллекции инициализируем
        return course;
    }
}
