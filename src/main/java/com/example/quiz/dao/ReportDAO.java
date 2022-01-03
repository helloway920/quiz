package com.example.quiz.dao;

import com.example.quiz.config.MySqlDS;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class ReportDAO {
    private DataSource ds;
    private Connection conn;
    private ResultSet rs;
    private PreparedStatement ps;


    private static final String ADD_SUBMISSION = "INSERT INTO reports(submissionId,questionId,selectIdx,answerIdx) VALUES(?,?,?,?)";
    //private static final String GET_SUBMISSION = "INSERT INTO reports(submissionId,questionId,selectIdx,answerIdx) VALUES(?,?,?,?)";

    public int addReport(int submissionId, List<Integer> questionIds, Map<Integer, Integer> selectIds, Map<Integer, Integer> answerIds) {
        try {
            this.conn = ds.getConnection();
            this.ps = conn.prepareStatement(ADD_SUBMISSION);
            ps.setInt(1, submissionId);
            ps.setString(2, questionIds.toString());
            ps.setString(3, selectIds.toString());
            ps.setString(4, answerIds.toString());
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
