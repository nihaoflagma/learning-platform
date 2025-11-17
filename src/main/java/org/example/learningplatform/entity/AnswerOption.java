package org.example.learningplatform.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "answer_options")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AnswerOption {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 1000, nullable = false)
    private String text;

    // Булевое поле для корректного ответа
    @Column(nullable = false)
    private boolean correct;

    // Связь с вопросом (Many-to-One)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "question_id", nullable = false)
    private Question question;

    // Удобный метод для DTO / API
    public boolean isCorrect() {
        return correct;
    }
}
