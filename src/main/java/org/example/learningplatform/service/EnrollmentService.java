package org.example.learningplatform.service;

import org.example.learningplatform.entity.Course;
import org.example.learningplatform.entity.Enrollment;
import org.example.learningplatform.entity.User;
import org.example.learningplatform.repository.CourseRepository;
import org.example.learningplatform.repository.EnrollmentRepository;
import org.example.learningplatform.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EnrollmentService {

    private final UserRepository userRepository;
    private final CourseRepository courseRepository;
    private final EnrollmentRepository enrollmentRepository;

    public EnrollmentService(UserRepository userRepository,
                             CourseRepository courseRepository,
                             EnrollmentRepository enrollmentRepository) {
        this.userRepository = userRepository;
        this.courseRepository = courseRepository;
        this.enrollmentRepository = enrollmentRepository;
    }

    // Записать студента на курс
    @Transactional
    public void enrollStudent(Long courseId, Long studentId) {
        User student = userRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Студент не найден"));
        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new RuntimeException("Курс не найден"));

        if (enrollmentRepository.existsByCourseAndStudent(course, student)) {
            throw new RuntimeException("Студент уже записан на курс");
        }

        Enrollment enrollment = new Enrollment();
        enrollment.setCourse(course);
        enrollment.setStudent(student);
        enrollmentRepository.save(enrollment);

        System.out.println("Студент " + student.getName() + " записан на курс " + course.getTitle());
    }

    // Получить всех студентов конкретного курса
    @Transactional(readOnly = true)
    public List<User> getStudentsInCourse(Long courseId) {
        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new RuntimeException("Курс не найден"));

        return enrollmentRepository.findByCourse(course)
                .stream()
                .map(Enrollment::getStudent)
                .toList();
    }

    // Получить все курсы студента
    @Transactional(readOnly = true)
    public List<Course> getCoursesOfStudent(Long studentId) {
        User student = userRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Студент не найден"));

        return enrollmentRepository.findByStudent(student)
                .stream()
                .map(Enrollment::getCourse)
                .toList();
    }

    // Отписать студента от курса
    @Transactional
    public void unenrollStudent(Long courseId, Long studentId) {
        User student = userRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Студент не найден"));
        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new RuntimeException("Курс не найден"));

        Enrollment enrollment = enrollmentRepository.findByCourseAndStudent(course, student)
                .orElseThrow(() -> new RuntimeException("Студент не записан на курс"));

        enrollmentRepository.delete(enrollment);

        System.out.println("Студент " + student.getName() + " отписан от курса " + course.getTitle());
    }
}
