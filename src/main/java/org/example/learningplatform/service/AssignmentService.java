package org.example.learningplatform.service;

import org.example.learningplatform.entity.Assignment;
import org.example.learningplatform.entity.Lesson;
import org.example.learningplatform.repository.AssignmentRepository;
import org.example.learningplatform.repository.LessonRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AssignmentService {

    private final AssignmentRepository assignmentRepository;
    private final LessonRepository lessonRepository;

    public AssignmentService(AssignmentRepository assignmentRepository, LessonRepository lessonRepository) {
        this.assignmentRepository = assignmentRepository;
        this.lessonRepository = lessonRepository;
    }

    public List<Assignment> getAllAssignments() {
        return assignmentRepository.findAll();
    }

    public Optional<Assignment> getAssignmentById(Long id) {
        return assignmentRepository.findById(id);
    }

    public Assignment createAssignment(Assignment assignment) {
        return assignmentRepository.save(assignment);
    }

    public Assignment updateAssignment(Assignment assignment) {
        return assignmentRepository.save(assignment);
    }

    public void deleteAssignment(Long id) {
        assignmentRepository.deleteById(id);
    }

    
    public List<Assignment> getAssignmentsByLesson(Long lessonId) {
        Lesson lesson = lessonRepository.findById(lessonId)
                .orElseThrow(() -> new RuntimeException("Урок не найден"));
        return assignmentRepository.findByLesson(lesson);
    }
}
