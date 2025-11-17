package org.example.learningplatform.entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Table(name = "quizzes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Quiz {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    // связь с модулем, тест может быть необязательным для модуля
    @OneToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "module_id")
    private Module module;

    // связь с уроком
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "lesson_id")
    private Lesson lesson;

    // вопросы викторины
    @OneToMany(mappedBy = "quiz", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Question> questions;

    // результаты студентов
    @OneToMany(mappedBy = "quiz", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<QuizSubmission> quizSubmissions;
}
