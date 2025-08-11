package org.example.service;

import org.example.model.User;
import org.example.model.request.UserCreateRequest;

import java.util.List;

public interface UserService {
    User createUser(UserCreateRequest request);
    List<User> getAllUsers();
    User getUserById(Long id);
}
