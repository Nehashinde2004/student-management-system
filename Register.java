package com.jbk;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/submitForm")
public class Register extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password"); // Hash this in a real app!
        String city = request.getParameter("city");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/batch204", "root", "neha");

            PreparedStatement ps = c.prepareStatement("INSERT INTO users (name, email, password, city) VALUES (?, ?, ?, ?)");
            ps.setString(1, name);
            ps.setString(2, email);
            ps.setString(3, password); // Hash password in a real app!
            ps.setString(4, city);
            int rowsAffected = ps.executeUpdate();

            if (rowsAffected > 0) {
                // Registration successful
                request.setAttribute("successMessage", "Registration successful!"); // Set success message
                RequestDispatcher rd = request.getRequestDispatcher("login.html"); // Redirect using RequestDispatcher
                rd.forward(request, response); // Forward to login.html
            } else {
                // Insertion failed
                request.setAttribute("errorMessage", "Registration failed. Please try again."); // Set error message
                RequestDispatcher rd = request.getRequestDispatcher("register.html"); // Redirect using RequestDispatcher
                rd.forward(request, response); // Forward back to register.html
            }

            c.close();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            
        }
    }
}