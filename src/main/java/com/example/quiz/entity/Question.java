package com.example.quiz.entity;

import lombok.*;

import java.util.ArrayList;
import java.util.List;
@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Question {
    private int id;
    private String description;
    private int selectIdx;
    private int answerIdx;
    private List<Choice> choices;
}
