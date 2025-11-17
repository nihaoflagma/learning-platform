package org.example.learningplatform.service;

import org.example.learningplatform.entity.Lesson;
import org.example.learningplatform.repository.LessonRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LessonService {

    private final LessonRepository lessonRepository;

    public LessonService(LessonRepository lessonRepository) {
        this.lessonRepository = lessonRepository;
    }

    public List<Lesson> getAllLessons() {
        return lessonRepository.findAll();
    }

    public Optional<Lesson> getLessonById(Long id) {
        return lessonRepository.findById(id);
    }

    public Lesson createLesson(Lesson lesson) {
        return lessonRepository.save(lesson);
    }

    public Lesson updateLesson(Lesson lesson) {
        return lessonRepository.save(lesson);
    }

    public void deleteLesson(Long id) {
        lessonRepository.deleteById(id);
    }
}
