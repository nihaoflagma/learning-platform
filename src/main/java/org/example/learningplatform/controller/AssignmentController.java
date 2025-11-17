package org.example.learningplatform.controller;

import org.example.learningplatform.entity.Assignment;
import org.example.learningplatform.entity.Submission;
import org.example.learningplatform.entity.User;
import org.example.learningplatform.service.AssignmentService;
import org.example.learningplatform.service.SubmissionService;
import org.example.learningplatform.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api")
public class AssignmentController {

    private final AssignmentService assignmentService;
    private final SubmissionService submissionService;
    private final UserService userService;

    public AssignmentController(AssignmentService assignmentService,
                                SubmissionService submissionService,
                                UserService userService) {
        this.assignmentService = assignmentService;
        this.submissionService = submissionService;
        this.userService = userService;
    }

    
    @GetMapping("/assignments")
    public List<Assignment> getAllAssignments() {
        return assignmentService.getAllAssignments();
    }

    
    @GetMapping("/assignments/{id}")
    public Assignment getAssignment(@PathVariable Long id) {
        return assignmentService.getAssignmentById(id)
                .orElseThrow(() -> new RuntimeException("Задание не найдено"));
    }

    
    @PostMapping("/assignments/{id}/submit")
    public Submission submitAssignment(@PathVariable Long id,
                                       @RequestParam Long studentId,
                                       @RequestBody String content) {
        Assignment assignment = assignmentService.getAssignmentById(id)
                .orElseThrow(() -> new RuntimeException("Задание не найдено"));
        User student = userService.getUserById(studentId)
                .orElseThrow(() -> new RuntimeException("Студент не найден"));

        Submission submission = new Submission();
        submission.setAssignment(assignment);
        submission.setStudent(student);
        submission.setContent(content);
        submission.setSubmittedAt(LocalDateTime.now());

        return submissionService.submitAssignment(submission);
    }

    
    @GetMapping("/submissions/student/{studentId}")
    public List<Submission> getStudentSubmissions(@PathVariable Long studentId) {
        User student = userService.getUserById(studentId)
                .orElseThrow(() -> new RuntimeException("Студент не найден"));
        return student.getSubmissions();
    }
}
