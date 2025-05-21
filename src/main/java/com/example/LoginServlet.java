package com.example;

import java.io.IOException;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;

public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/mywebapp", "webappuser", "StrongPass123");

            PreparedStatement stmt = conn.prepareStatement(
                "SELECT * FROM users WHERE username = ? AND password = ?");
            stmt.setString(1, username);
            stmt.setString(2, password);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                request.setAttribute("user", username);
                request.getRequestDispatcher("dashboard.jsp").forward(request, response);
            } else {
                request.setAttribute("errorMessage", "Invalid username or password");
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }

            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("errorMessage", "Internal error. Try again.");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }
}

