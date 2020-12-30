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
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author lamde
 */
@WebServlet(name = "SearchServlet", urlPatterns = {"/search"})
public class SearchServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        resp.setContentType("text/html");  
        PrintWriter out = resp.getWriter();
        
        String pid = req.getParameter("pid");
        ArrayList<User> list = UserDAO.searchEmail(pid);
        if (list != null) {
            req.setAttribute("listt", list);
            RequestDispatcher rd = req.getRequestDispatcher("viewSearch.jsp");
            rd.forward(req, resp);
        } else {
            resp.sendRedirect("list");
        }
    }
    
    

    

}
