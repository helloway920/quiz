package com.example.quiz.domain;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@Builder
@ToString
public class ChoiceDomain {
    private Integer id;
    private String description;
    private Integer correct;
    private Integer isChoose;
}
