/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iviettech.DAO;

import com.iviettech.connect.ConnectionUtils;
import com.iviettech.model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lamde
 */
public class UserDAO {
    
    public static User checkLogin(String email, String password) throws SQLException, ClassNotFoundException {
    
        String sql = "select * from user where Email = ? and Password = ?";
        Connection connection = ConnectionUtils.getConnection();
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, email);
        ps.setString(2, password);
        ResultSet result = ps.executeQuery();
        User user = null;
        if (result.next()) {
            user = new User();
            user.setUserID(result.getInt("UserID"));
            user.setEmail(email);
            user.setPassword(password);
            user.setFirstName(result.getString("FirstName"));
            user.setLastName(result.getString("LastName"));
        }
        connection.close();
        return user;
    }
    
    public static ArrayList<User> listUsers() throws SQLException {
        ArrayList<User> list = new ArrayList<>();
        String sql = "select * from user";
        Connection connection = ConnectionUtils.getConnection();
        Statement statement = connection.createStatement();
        ResultSet result = statement.executeQuery(sql);
        User user = null;
        while (result.next()) {
            user = new User();
            user.setUserID(result.getInt("UserID"));
            user.setEmail(result.getString("Email"));
            user.setPassword(result.getString("Password"));
            user.setFirstName(result.getString("FirstName"));
            user.setLastName(result.getString("LastName"));
            list.add(user);
        }
        connection.close();
        return list;
    }
    
    public static int insertUser(User user) {
        int status = 0;
        try{
            Connection connection = ConnectionUtils.getConnection();
            String sql = "INSERT INTO user (Email, Password, FirstName, LastName)"
                          + "VALUES (?,?,?,?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, user.getEmail());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getFirstName());
            ps.setString(4, user.getLastName());
            status = ps.executeUpdate();
            connection.close();
        } catch (Exception ex){
            ex.printStackTrace();
        }
        return status;
    }
    
    public static int updateUser(User user){
        
        int status = 0;
        try {
            Connection connection = ConnectionUtils.getConnection();
            String sql = "UPDATE User set Email = ?, Password = ?, FirstName = ?, LastName = ? WHERE UserID = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, user.getEmail());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getFirstName());
            ps.setString(4, user.getLastName());
            ps.setInt(5, user.getUserID());
            status = ps.executeUpdate();
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return status;
    }
    
    public static User getUserById(int id) {
        
        User user = new User();
        
        try {
            Connection connection = ConnectionUtils.getConnection();
            String sql = "SELECT * FROM User WHERE UserID = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet result = ps.executeQuery();
            if (result.next()) {
                user.setUserID(result.getInt(1));
                user.setEmail(result.getString(2));
                user.setPassword(result.getString(3));
                user.setFirstName(result.getString(4));
                user.setLastName(result.getString(5));
            }
            connection.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return user;
    }
    
    public static int deleteUser (int id) {
        
        int status = 0;
        try {
            Connection connection = ConnectionUtils.getConnection();
            String sql = "DELETE FROM User WHERE UserID = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            status = ps.executeUpdate();
            connection.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return status;
    }
    
    public static ArrayList<User> searchEmail (String email) {
        
        ArrayList<User> list = new ArrayList<>();
        User user = null;
        try {
            Connection connection = ConnectionUtils.getConnection();
            String sql = "SELECT * FROM User WHERE Email = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, email);
            ResultSet result = ps.executeQuery();
            while (result.next()) {
                user = new User();
                user.setUserID(result.getInt("UserID"));
                user.setEmail(result.getString("Email"));
                user.setPassword(result.getString("Password"));
                user.setFirstName(result.getString("FirstName"));
                user.setLastName(result.getString("LastName"));
                list.add(user);
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
