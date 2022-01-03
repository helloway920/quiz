package com.example.quiz.domain;

import lombok.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@ToString
@Builder
public class QuizDomain {
   String name;
   int id;
}
