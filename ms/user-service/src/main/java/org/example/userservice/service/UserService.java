package org.example.userservice.service;

import org.example.userservice.model.User;

import java.util.List;
import java.util.UUID;

public interface UserService {

    User createUser(User user);
    User getUser(UUID id);
    List<User> getUsers();
    User update(User user);
    void deleteUser(UUID id);

}
