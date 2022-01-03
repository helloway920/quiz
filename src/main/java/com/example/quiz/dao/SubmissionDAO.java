package com.example.quiz.dao;

import com.example.quiz.config.MySqlDS;

import javax.sql.DataSource;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class SubmissionDAO {
    private DataSource ds;
    private Connection conn;
    private ResultSet rs;
    private PreparedStatement ps;



    private static final String ADD_SUBMISSION = "INSERT INTO submissions(userId,quizTypeId,startTime,endTime,pass) VALUES(?,?,?,?,?)";
    private static final String GET_SUBMISSION_QUIZTYPE = "select quizTypeId,b.`name` from submissions a INNER JOIN quiztypes b on a.quizTypeId = b.id where a.userId = ? GROUP BY a.quizTypeId";

    public int addSubmission(String startTime,String endTime,int quizid,int userId,int isPass){
        try {
            this.conn = ds.getConnection();
            this.ps = conn.prepareStatement(ADD_SUBMISSION, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, userId);
            ps.setInt(2, quizid);
            ps.setString(3,startTime);
            ps.setString(4,endTime);
            ps.setShort(5, (short) isPass);
            ps.executeUpdate();
            rs = ps.getGeneratedKeys();
            if(rs.next()){
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
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

    public Map<String,Integer> getQuizTypeId(int userId){
        Map<String,Integer> quizTypeIds = new HashMap<>();
        try {
            this.conn = ds.getConnection();
            this.ps = conn.prepareStatement(GET_SUBMISSION_QUIZTYPE);
            ps.setInt(1, userId);
            rs = ps.executeQuery();
            while(rs.next()){
                quizTypeIds.put(rs.getString("name"),rs.getInt("quizTypeId"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return quizTypeIds;
    }
}
