package com.example.quiz.dao;

import com.example.quiz.config.MySqlDS;
import com.example.quiz.entity.Choice;
import com.example.quiz.entity.Question;
import com.example.quiz.entity.Quiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class QuizDAO {
    private DataSource ds;
    private Connection conn;
    private ResultSet rs;
    private PreparedStatement ps;


    private static final String SELECT_QUIZ = "SELECT a.ID AS id,NAME,a.timerequires AS timerequires,a.description AS description,b.ID AS questionId,b.description AS questionDescription,c.ID AS choiceID,c.description AS choiceDescription,c.correct AS correct FROM quiz_type a INNER JOIN (\n" +
            "SELECT ID,description,quiz_type_ID FROM questions WHERE quiz_type_ID=? ORDER BY RAND() LIMIT 10) b ON a.ID=b.quiz_type_ID INNER JOIN choices c ON b.ID=c.questionID";
    private static final String SELECT_ALL_QUIZ = "select * from quiz_type";

    @Autowired
    public QuizDAO(DataSource ds) {
        this.ds = ds;
    }

    public List<Quiz> getAllQuiz() {
        List<Quiz> quizzes = null;
        try {
            this.conn = ds.getConnection();
            this.ps = conn.prepareStatement(SELECT_ALL_QUIZ);
            rs = ps.executeQuery();
            quizzes = new ArrayList<>();
            while (rs.next()) {
                Quiz quiz = new Quiz();
                quiz.setTimeLimit(rs.getInt("timerequires"));
                quiz.setName(rs.getString("name"));
                quiz.setId(rs.getInt("id"));
                quiz.setDescription(rs.getString("description"));
                quizzes.add(quiz);
            }
            return quizzes;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return quizzes;
    }


    public Quiz getQuiz(int id) {
        Quiz quiz = new Quiz();
        try {
            this.conn = ds.getConnection();
            this.ps = conn.prepareStatement(SELECT_QUIZ);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            Question question = null;
            Choice choice;
            if (quiz.getQuestions() == null) quiz.setQuestions(new ArrayList<>());
            while (rs.next()) {
                if (quiz.getId() == null) quiz.setId(rs.getInt("id"));
                if (quiz.getName() == null) quiz.setName(rs.getString("NAME"));
                if (quiz.getTimeLimit() == 0) quiz.setTimeLimit(rs.getInt("timerequires"));
                int questionId = rs.getInt("questionId");
                if (question == null) {
                    question = new Question();
                    question.setId(questionId);
                    question.setChoices(new ArrayList<>());
                    question.setDescription(rs.getString("questionDescription"));
                }
                choice = new Choice();
                choice.setId(rs.getInt("choiceID"));
                choice.setAnswer(rs.getShort("correct"));
                choice.setDescription(rs.getString("choiceDescription"));
                if (questionId != question.getId()) {
                    quiz.getQuestions().add(question);
                    question = new Question();
                    question.setChoices(new ArrayList<>());
                    question.setId(questionId);
                    question.setDescription(rs.getString("questionDescription"));
                }
                question.getChoices().add(choice);
            }
            quiz.getQuestions().add(question);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return quiz;
    }
}
