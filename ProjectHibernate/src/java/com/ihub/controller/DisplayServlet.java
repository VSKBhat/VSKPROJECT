/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ihub.controller;


import com.ihub.model.Defaultup;
import com.ihub.services.DisplayService;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author Veena SK
 */
@WebServlet(name = "DisplayServlet", urlPatterns = {"/Display"})
public class DisplayServlet extends HttpServlet 
{

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html");
         
        DisplayService d1= new DisplayService();
                  HttpSession session = req.getSession();
			//session.setAttribute("user", "admin"); 
                  String s1=(String) session.getAttribute("user");
                  if(!s1.equals("admin"))
                  {
                      resp.sendRedirect("home.jsp");
                  }
                 PrintWriter out=resp.getWriter();
                 out.print("<h1><font color=red>Welcome</font></h1>" + s1);
                  System.out.println("  user name is ++++++++++++++++"+s1);
         
              //  Hi <%=userName %>, Login successful. Your Session ID=<%=sessionID %>
           ArrayList<Defaultup> dlist=d1.readData();
           //for loop is to display in the console
           for (int i = 1; i < dlist.size(); i++) {
                 
           
             System.out.println("  from servlet********"+dlist.get(i));
         
        }
     req.setAttribute("data", dlist); 
       // Creating a RequestDispatcher object to dispatch 
       // the request to another resource 
         RequestDispatcher rd =req.getRequestDispatcher("show.jsp"); 
  
       // The request will be forwarded to the resource  
       // specified, here the resource is a JSP named, 
       // "show.jsp" 
          rd.forward(req, resp);  
    } 
}
    
    



