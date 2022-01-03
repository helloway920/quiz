package com.example.quiz.dao;

import com.example.quiz.config.MySqlDS;
import com.example.quiz.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;

@Repository
public class UserDAO {
    private DataSource ds;
    private Connection connect;
    private ResultSet rs;
    private PreparedStatement ps;

    private static final String SELECT_USER = "SELECT * FROM user WHERE username = ? and password = ?;";
    private static final String SELECT_USER_BY_NAME = "SELECT * FROM user WHERE username = ?;";
    private static final String ADD_USER = "INSERT INTO user(username, password, firstname, lastname, admin) VALUES(?,?,?,?,?)";
    private static final String SELECT_ADMIN = "SELECT * FROM user WHERE admin=1";

    @Autowired
    public UserDAO(DataSource ds) {
        this.ds = ds;
    }

    public User getUser(String username, String password){
        User user = new User();
        try{
            this.connect = ds.getConnection();
            this.ps = connect.prepareStatement(SELECT_USER);
            ps.setString(1, username);
            ps.setString(2, password);
            rs = ps.executeQuery();
            while (rs.next()){
                user.setUsername(rs.getString("username"));
                user.setFirstname(rs.getString("firstname"));
                user.setLastname(rs.getString("lastname"));
            }
        } catch(SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (connect != null) connect.close();
            } catch (SQLException e){
                e.printStackTrace();
            }
        }
        return user;
    }

}
