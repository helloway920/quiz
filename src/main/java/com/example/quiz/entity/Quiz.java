package com.example.quiz.entity;

import lombok.*;

import java.util.List;
@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Quiz {
    private Integer id;
    private String name;
    private int timeLimit;
    private String description;
    private List<Question> questions;

}
