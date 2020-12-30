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
import static java.lang.System.out;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author lamde
 */
@WebServlet(name = "EditServlet2", urlPatterns = {"/edit2"})
public class EditServlet2 extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        resp.setContentType("text/html");  
        PrintWriter out= resp.getWriter();  
        req.setCharacterEncoding("UTF-8");
        String ids = req.getParameter("id");
        int id = Integer.parseInt(ids);
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        
        User user = new User();
        user.setUserID(id);
        user.setEmail(email);
        user.setPassword(password);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        
        int status = UserDAO.updateUser(user);
        if (status > 0) {
            resp.sendRedirect("list");
        } else {
            out.println("Sorry! unable to update record");  
        }
        out.close();
    }
}
