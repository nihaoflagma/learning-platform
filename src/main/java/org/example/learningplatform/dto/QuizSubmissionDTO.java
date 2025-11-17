package org.example.learningplatform.dto;

import java.util.List;

public class QuizSubmissionDTO {
    private Long id;
    private Long quizId;
    private Long userId;
    private List<Integer> selectedOptions; // индексы выбранных вариантов
    private int score;

    // getters and setters
}
