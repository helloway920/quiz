package com.example.quiz.domain;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@Builder
@ToString
public class QuestionDomain {
 private Integer id;
 private String description;
 private List<ChoiceDomain> clist;

}
