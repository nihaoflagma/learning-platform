package org.example.learningplatform.service;

import org.example.learningplatform.entity.Assignment;
import org.example.learningplatform.entity.Submission;
import org.example.learningplatform.entity.User;
import org.example.learningplatform.repository.AssignmentRepository;
import org.example.learningplatform.repository.SubmissionRepository;
import org.example.learningplatform.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubmissionService {

    private final SubmissionRepository submissionRepository;
    private final UserRepository userRepository;
    private final AssignmentRepository assignmentRepository;

    public SubmissionService(SubmissionRepository submissionRepository,
                             UserRepository userRepository,
                             AssignmentRepository assignmentRepository) {
        this.submissionRepository = submissionRepository;
        this.userRepository = userRepository;
        this.assignmentRepository = assignmentRepository;
    }

    public List<Submission> getAllSubmissions() {
        return submissionRepository.findAll();
    }

    public Optional<Submission> getSubmissionById(Long id) {
        return submissionRepository.findById(id);
    }

    public Submission submitAssignment(Submission submission) {
        // Можно проверить, что студент существует и задание существует
        userRepository.findById(submission.getStudent().getId())
                .orElseThrow(() -> new RuntimeException("Студент не найден"));
        assignmentRepository.findById(submission.getAssignment().getId())
                .orElseThrow(() -> new RuntimeException("Задание не найдено"));

        return submissionRepository.save(submission);
    }

    public Submission gradeSubmission(Submission submission) {
        return submissionRepository.save(submission);
    }

    public void deleteSubmission(Long id) {
        submissionRepository.deleteById(id);
    }

    public List<Submission> getSubmissionsByStudent(Long studentId) {
        User student = userRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Студент не найден"));
        return submissionRepository.findByStudentId(student.getId());
    }

    public List<Submission> getSubmissionsByAssignment(Long assignmentId) {
        Assignment assignment = assignmentRepository.findById(assignmentId)
                .orElseThrow(() -> new RuntimeException("Задание не найдено"));
        return submissionRepository.findByAssignmentId(assignment.getId());
    }
}
