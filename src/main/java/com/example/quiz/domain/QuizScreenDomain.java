package com.example.quiz.domain;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@Builder
@ToString
public class QuizScreenDomain {
    private List<QuestionDomain> qlist;
}
