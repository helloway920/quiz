package com.example.quiz.domain;

import lombok.*;

@Data
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDomain {
    public String username;
    public String password;
}
