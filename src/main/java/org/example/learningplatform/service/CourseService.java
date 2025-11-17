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

    
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    
    public Optional<Course> getCourseById(Long id) {
        return courseRepository.findById(id);
    }

    
    public Course createCourse(Course course) {
        return courseRepository.save(course);
    }

    
    public Course updateCourse(Course course) {
        return courseRepository.save(course);
    }

    
    public void deleteCourse(Long id) {
        courseRepository.deleteById(id);
    }

    
    public Module addModuleToCourse(Long courseId, Module module) {
        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new RuntimeException("Course not found"));
        module.setCourse(course);
        return moduleRepository.save(module);
    }

    
    public Course getCourseWithModulesAndLessons(Long courseId) {
        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new RuntimeException("Course not found"));
        course.getModules().forEach(m -> m.getLessons().size()); 
        return course;
    }
}
