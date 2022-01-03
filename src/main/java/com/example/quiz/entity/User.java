package com.example.quiz.entity;

import lombok.*;

@Data
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private int ID;
    private String username;
    private String password;
    private String firstname;
    private String lastname;
    private int admin;

}
