package com.example.quiz.service.impl;

import com.example.quiz.dao.QuizDAO;
import com.example.quiz.dao.UserDAO;
import com.example.quiz.domain.ChoiceDomain;
import com.example.quiz.domain.QuestionDomain;
import com.example.quiz.domain.QuizDomain;
import com.example.quiz.domain.QuizScreenDomain;
import com.example.quiz.entity.Choice;
import com.example.quiz.entity.Question;
import com.example.quiz.entity.Quiz;
import com.example.quiz.entity.User;
import com.example.quiz.service.QuizService;
import com.example.quiz.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@Service
public class QuizServiceImpl implements QuizService {
    private QuizDAO quizDAO;

    @Autowired
    public QuizServiceImpl(QuizDAO quizDAO) {
        this.quizDAO = quizDAO;
    }

    @Override
    public List<QuizDomain> getAllQuiz() {
        List<Quiz> quizzes = quizDAO.getAllQuiz();
        List<QuizDomain> qlist = new ArrayList<>();
        for(Quiz quiz : quizzes){
            QuizDomain quizDomain = QuizDomain.builder().id(quiz.getId()).name(quiz.getName()).build();
            qlist.add(quizDomain);
        }
        return qlist;
    }

    @Override
    public QuizScreenDomain getQuizScreen(int id) {
        Quiz quiz = quizDAO.getQuiz(id);
        List<QuestionDomain> questionDomainList = new ArrayList<>();
        for(Question question : quiz.getQuestions()){
            List<ChoiceDomain> choiceDomainList = new ArrayList<>();
            for(Choice choice : question.getChoices()){
                ChoiceDomain choiceDomain = ChoiceDomain.builder().id(choice.getId()).description(choice.getDescription()).correct(choice.getAnswer()).build();
                choiceDomainList.add(choiceDomain);
            }
            QuestionDomain questionDomain = QuestionDomain.builder().id(question.getId()).description(question.getDescription()).clist(choiceDomainList).build();
            questionDomainList.add(questionDomain);
        }
        QuizScreenDomain quizScreenDomain = QuizScreenDomain.builder().qlist(questionDomainList).build();
        return quizScreenDomain;
    }

}
