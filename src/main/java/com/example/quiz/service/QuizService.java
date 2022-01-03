package com.example.quiz.service;

import com.example.quiz.domain.QuizDomain;
import com.example.quiz.domain.QuizScreenDomain;

import java.util.List;

public interface QuizService {
    List<QuizDomain> getAllQuiz();
    QuizScreenDomain getQuizScreen(int id);
}
