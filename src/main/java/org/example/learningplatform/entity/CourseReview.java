package org.example.learningplatform.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "course_reviews")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CourseReview {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Курс, к которому относится отзыв
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "course_id", nullable = false)
    private Course course;

    // Студент, который оставил отзыв
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "student_id", nullable = false)
    private User student;

    @Column(nullable = false)
    private int rating; // оценка, например 1-5

    @Column(length = 1000)
    private String comment;

    private LocalDateTime createdAt;

    // Автоматически проставляем дату при создании
    @PrePersist
    public void prePersist() {
        this.createdAt = LocalDateTime.now();
    }
}
