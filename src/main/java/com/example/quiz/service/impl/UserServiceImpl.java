package com.example.quiz.service.impl;

import com.example.quiz.dao.UserDAO;
import com.example.quiz.entity.User;
import com.example.quiz.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private UserDAO userDAO;
    @Autowired
    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }


    @Override
    public User getUser(String username, String password){ return userDAO.getUser(username, password);}

    @Override
    public int addUser(User user) {
        return 0;
    }
}
