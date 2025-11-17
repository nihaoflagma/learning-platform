package org.example.learningplatform.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "users") // чтобы не конфликтовать с SQL-словами
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    // связи

    // один пользователь может иметь один профиль
    @OneToOne(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Profile profile;

    // студент может иметь много решений
    @OneToMany(mappedBy = "student", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Submission> submissions;

    // студент может иметь много результатов тестов
    @OneToMany(mappedBy = "student", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<QuizSubmission> quizSubmissions;

    // роли пользователя
    public enum Role {
        STUDENT,
        TEACHER,
        ADMIN
    }
}
