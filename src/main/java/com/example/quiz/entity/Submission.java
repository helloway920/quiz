package com.example.quiz.entity;

import java.util.Date;

public class Submission {
    private int id;
    private User user;
    private Quiz quiz;
    private Date startTime;
    private Date endTime;
    private short pass;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Quiz getQuiz() {
        return quiz;
    }

    public void setQuiz(Quiz quiz) {
        this.quiz = quiz;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public short getPass() {
        return pass;
    }

    public void setPass(short pass) {
        this.pass = pass;
    }
}
