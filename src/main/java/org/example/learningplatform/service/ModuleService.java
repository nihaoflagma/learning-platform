package org.example.learningplatform.service;

import org.example.learningplatform.entity.Lesson;
import org.example.learningplatform.entity.Module;
import org.example.learningplatform.repository.LessonRepository;
import org.example.learningplatform.repository.ModuleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ModuleService {

    private final ModuleRepository moduleRepository;
    private final LessonRepository lessonRepository;

    public ModuleService(ModuleRepository moduleRepository, LessonRepository lessonRepository) {
        this.moduleRepository = moduleRepository;
        this.lessonRepository = lessonRepository;
    }

    public List<Module> getAllModules() {
        return moduleRepository.findAll();
    }

    public Optional<Module> getModuleById(Long id) {
        return moduleRepository.findById(id);
    }

    public Module createModule(Module module) {
        return moduleRepository.save(module);
    }

    public Module updateModule(Module module) {
        return moduleRepository.save(module);
    }

    public void deleteModule(Long id) {
        moduleRepository.deleteById(id);
    }

    // Добавить урок к модулю
    public Lesson addLessonToModule(Long moduleId, Lesson lesson) {
        Module module = moduleRepository.findById(moduleId)
                .orElseThrow(() -> new RuntimeException("Module not found"));
        lesson.setModule(module);
        return lessonRepository.save(lesson);
    }
}
