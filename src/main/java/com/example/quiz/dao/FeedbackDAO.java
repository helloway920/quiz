package com.example.quiz.dao;

import com.example.quiz.config.MySqlDS;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FeedbackDAO {
    private DataSource ds;
    private Connection conn;
    private ResultSet rs;
    private PreparedStatement ps;



    private static final String ADD_FEEDBACK="INSERT INTO feedbacks(quizTypeId,rating,description) VALUES(?,?,?)";

    public int addFeedback(int quizTypeId,int rating,String feedback){
        try {
            this.conn = ds.getConnection();
            this.ps = conn.prepareStatement(ADD_FEEDBACK);
            ps.setInt(1,quizTypeId);
            ps.setInt(2,rating);
            ps.setString(3,feedback);
            return ps.executeUpdate();
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
        return 0;
    }
}
