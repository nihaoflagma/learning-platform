package org.example.learningplatform.dto;

import java.util.List;

public class QuizDTO {
    private Long id;
    private String title;
    private Long lessonId;
    private List<QuestionDTO> questions;

    

    public static class QuestionDTO {
        private String question;
        private List<String> options;
        private int correctOptionIndex;

        
    }
}
