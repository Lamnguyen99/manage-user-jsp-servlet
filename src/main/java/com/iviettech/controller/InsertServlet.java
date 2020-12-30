/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iviettech.controller;

import com.iviettech.DAO.UserDAO;
import com.iviettech.model.User;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author lamde
 */
@WebServlet(name = "InsertServlet", urlPatterns = {"/insert"})
public class InsertServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       resp.setContentType("text/html");  
       PrintWriter out = resp.getWriter();
       req.setCharacterEncoding("UTF-8");
       String email = req.getParameter("email");
       String password = req.getParameter("password");
       String firstName = req.getParameter("firstName");
       String lastName = req.getParameter("lastName");
       User u = new User();
       u.setEmail(email);
       u.setPassword(password);
       u.setFirstName(firstName);
       u.setLastName(lastName);
       
       int status = UserDAO.insertUser(u);
       if (status > 0) {
           out.print("<p>Record saved successfully!</p>");  
           resp.sendRedirect("list");
       } else {
           out.println("Sorry! unable to save record");
       }
       
       out.close();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        req.getServletContext().getRequestDispatcher("/addUser.jsp").forward(req, resp);
    }
    
}
