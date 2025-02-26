package com.jbk;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class Login extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/batch204", "root", "neha");

            PreparedStatement ps = c.prepareStatement("SELECT * FROM users WHERE email = ? AND password = ?");
            ps.setString(1, email);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();

            response.setContentType("text/html");
            PrintWriter out = response.getWriter();

            if (rs.next()) { 
                
                request.setAttribute("name", rs.getString("name")); 
                request.setAttribute("email", rs.getString("email"));
                request.setAttribute("city", rs.getString("city"));

                RequestDispatcher d = request.getRequestDispatcher("profile.jsp");
                d.forward(request, response); 
            } else {
                out.print("<h1>Invalid Email or Password</h1>");
            }

            rs.close(); 
            ps.close();
            c.close();

        } catch (Exception e) {
            e.printStackTrace(); 
            
        }
    }
}