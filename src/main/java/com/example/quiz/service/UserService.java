package com.example.quiz.service;

import com.example.quiz.entity.User;

import java.util.List;

public interface UserService {
    User getUser(String username, String password);
    int addUser(User user);
}
