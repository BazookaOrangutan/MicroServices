package org.example.userservice.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.userservice.model.User;
import org.example.userservice.repository.UserRepository;
import org.example.userservice.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository repository;


    @Override
    public User createUser(User user) {
        return repository.save(user);
    }

    @Override
    public User getUser(UUID id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<User> getUsers() {
        return repository.findAll();
    }

    @Override
    public User update(User user) {
        return repository.save(user);
    }

    @Override
    public void deleteUser(UUID id) {
        repository.deleteById(id);
    }
}
