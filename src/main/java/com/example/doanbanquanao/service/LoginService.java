//package com.example.clothesshop.service;
//
//import java.sql.*;
//
//public class LoginService {
//
//    public boolean authenticate(String username, String password) {
//        String dbUrl = "jdbc:sqlserver://localhost:1433;databaseName=your_database_name";
//        String dbUsername = "your_username";
//        String dbPassword = "your_password";
//
//        try {
//            Connection connection = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
//
//            String query = "SELECT * FROM users WHERE username = ? AND password = ?";
//            PreparedStatement statement = connection.prepareStatement(query);
//            statement.setString(1, username);
//            statement.setString(2, password);
//
//            ResultSet resultSet = statement.executeQuery();
//
//            if (resultSet.next()) {
//                // User credentials are correct
//                return true;
//            }
//
//            // User credentials are incorrect
//            return false;
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//            // Handle any potential exceptions
//        }
//
//        // Database connection or query execution failed
//        return false;
//    }
//}
