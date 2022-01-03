package com.example.quiz.entity;

import lombok.*;

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Choice {
    private int id;
    private int answer;
    private String description;

}
