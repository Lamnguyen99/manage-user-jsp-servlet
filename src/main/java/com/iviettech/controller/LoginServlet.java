/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iviettech.controller;

import com.iviettech.DAO.UserDAO;
import com.iviettech.model.User;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author lamde
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher("/login.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        
            try{
                User user = UserDAO.checkLogin(email, password);
                if (user != null) {
                    HttpSession session = req.getSession();
                    session.setAttribute("userr", user);
                    getServletContext().getRequestDispatcher("/list").forward(req, resp);

                } else {
                    resp.sendRedirect("login?err=1");
                }
            } catch (SQLException | ClassNotFoundException ex) {
                    throw new ServletException(ex);
            }
    }
        
}

