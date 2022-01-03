package com.example.quiz.controller;

import com.example.quiz.domain.UserDomain;
import com.example.quiz.entity.User;
import com.example.quiz.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
public class LoginController {
    private UserService userService;
    @Autowired
    public LoginController(UserService userService) {
        this.userService = userService;
    }



    @GetMapping()
    public String initMethod(Model model) {
        model.addAttribute("user", new UserDomain());
        return "loginForm";
    }

    @PostMapping("/login")
    public String login(HttpServletRequest req, @ModelAttribute("user") @Valid UserDomain userDomain, BindingResult result, Model model) {
        User user = userService.getUser(userDomain.getUsername(), userDomain.getPassword());
        if (user != null) {
            return "forward:/" + "home";
        } else {
            model.addAttribute("exception", "Wrong UserName or Password");
            model.addAttribute(   "url", req.getRequestURL());

            return "errorPage";
        }
    }
}

