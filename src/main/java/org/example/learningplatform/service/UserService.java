package org.example.learningplatform.service;

import org.example.learningplatform.entity.User;
import org.example.learningplatform.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Получить всех пользователей
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // Получить пользователя по ID
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    // Создать нового пользователя
    public User createUser(User user) {
        return userRepository.save(user);
    }

    // Обновить пользователя
    public User updateUser(User user) {
        return userRepository.save(user);
    }

    // Удалить пользователя
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
