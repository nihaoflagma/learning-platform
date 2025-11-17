package org.example.learningplatform.controller;

import org.example.learningplatform.dto.CourseDTO;
import org.example.learningplatform.dto.ModuleDTO;
import org.example.learningplatform.dto.LessonDTO;
import org.example.learningplatform.entity.Course;
import org.example.learningplatform.entity.Module;
import org.example.learningplatform.entity.Lesson;
import org.example.learningplatform.service.CourseService;
import org.example.learningplatform.service.ModuleService;
import org.example.learningplatform.service.LessonService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/courses")
public class CourseController {

    private final CourseService courseService;
    private final ModuleService moduleService;
    private final LessonService lessonService;

    public CourseController(CourseService courseService,
                            ModuleService moduleService,
                            LessonService lessonService) {
        this.courseService = courseService;
        this.moduleService = moduleService;
        this.lessonService = lessonService;
    }

    @GetMapping
    public List<CourseDTO> getAllCourses() {
        return courseService.getAllCourses().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public CourseDTO getCourse(@PathVariable Long id) {
        Course course = courseService.getCourseById(id)
                .orElseThrow(() -> new RuntimeException("Курс не найден"));
        return convertToDTO(course);
    }

    @GetMapping("/{id}/modules")
    public List<ModuleDTO> getModulesOfCourse(@PathVariable Long id) {
        Course course = courseService.getCourseById(id)
                .orElseThrow(() -> new RuntimeException("Курс не найден"));
        return moduleService.getAllModules().stream()
                .filter(module -> module.getCourse().getId().equals(course.getId()))
                .map(this::convertModuleToDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}/lessons")
    public List<LessonDTO> getLessonsOfCourse(@PathVariable Long id) {
        Course course = courseService.getCourseById(id)
                .orElseThrow(() -> new RuntimeException("Курс не найден"));
        return lessonService.getAllLessons().stream()
                .filter(lesson -> lesson.getModule().getCourse().getId().equals(course.getId()))
                .map(this::convertLessonToDTO)
                .collect(Collectors.toList());
    }

    
    private CourseDTO convertToDTO(Course course) {
        CourseDTO dto = new CourseDTO();
        dto.setId(course.getId());
        dto.setTitle(course.getTitle());
        dto.setDescription(course.getDescription());
        dto.setDuration(course.getDuration());
        dto.setStartDate(course.getStartDate());
        if (course.getTeacher() != null) {
            dto.setTeacherId(course.getTeacher().getId());
            dto.setTeacherName(course.getTeacher().getName());
        }
        return dto;
    }

    private ModuleDTO convertModuleToDTO(Module module) {
        ModuleDTO dto = new ModuleDTO();
        dto.setId(module.getId());
        dto.setTitle(module.getTitle());
        dto.setOrderIndex(module.getOrderIndex());
        dto.setCourseId(module.getCourse().getId());
        return dto;
    }


    private LessonDTO convertLessonToDTO(Lesson lesson) {
        LessonDTO dto = new LessonDTO();
        dto.setId(lesson.getId());
        dto.setTitle(lesson.getTitle());
        dto.setContent(lesson.getContent());
        dto.setModuleId(lesson.getModule().getId());
        return dto;
    }
}
