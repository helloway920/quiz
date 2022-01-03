package com.example.quiz.controller;

import com.example.quiz.domain.QuizDomain;
import com.example.quiz.domain.QuizScreenDomain;
import com.example.quiz.domain.UserDomain;
import com.example.quiz.entity.User;

import com.example.quiz.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Controller
public class QuizController {

    private QuizService quizService;

    @Autowired
    public QuizController(QuizService quizService) {
        this.quizService = quizService;
    }


    @PostMapping("/home")
    public String quiz(Model model) {

        List<QuizDomain> quizDomainList = quizService.getAllQuiz();
        model.addAttribute("quizzes", quizDomainList);
        return "home";
    }
    @GetMapping("/getquizscreen")
    public ModelAndView getQuizScreen(@RequestParam Integer id){
        HashMap<String, Object> model = new HashMap<>();
        QuizScreenDomain quizScreenDomain = quizService.getQuizScreen(id);
        model.put("quizscreens", quizScreenDomain);
        return new ModelAndView("quizScreen", model);
    }
}

