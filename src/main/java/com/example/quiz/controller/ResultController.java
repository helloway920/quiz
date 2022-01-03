package com.example.quiz.controller;

import com.example.quiz.domain.QuizDomain;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@Controller
public class ResultController {
    @PostMapping("/createResult")
    public String createPerson(HttpServletRequest req, Model model, @ModelAttribute("person") @Valid PersonDomain personDomain,
                               BindingResult result) {

        if (result.hasErrors()) {
            return "addPerson";
        }
        try {
            PersonDomain newPersonDomain = personService.createPerson(personDomain);
            return "redirect:" + "/all/and";
        } catch (PersonSaveException e) {
            model.addAttribute("exception", e.getMessage());
            model.addAttribute("url", req.getRequestURL());
            return "errorPage";
        }
    }
}
