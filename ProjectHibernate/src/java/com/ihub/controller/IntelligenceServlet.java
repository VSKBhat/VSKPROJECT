/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ihub.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Veena SK
 */
public class IntelligenceServlet extends HttpServlet {

     private final String userID = "intelligent";
	private final String password = "int123";
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String user=req.getParameter("username");
        String pwd=req.getParameter("password");
        if(userID.equals(user) && password.equals(pwd)){
			HttpSession session = req.getSession();
			session.setAttribute("user", "intelligent");
			//setting session to expiry in 30 mins
			session.setMaxInactiveInterval(30*60);
			Cookie userName = new Cookie("user", user);
			userName.setMaxAge(30*60);
			resp.addCookie(userName);
			resp.sendRedirect("sensorSendingData.jsp");
		}else{
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/home.jsp");
			PrintWriter out= resp.getWriter();
			out.println("<h1><font color=red>Either user name or password is wrong.</font></h1>");
			rd.include(req, resp);
		}
    }

    
}
