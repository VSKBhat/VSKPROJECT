/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ihub.controller;

import com.ihub.model.Defaultup;
import com.ihub.services.PChangeService;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
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
@WebServlet(name = "PasswordChangeServlet", urlPatterns = {"/PChange"})
public class PasswordChangeServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

             resp.setContentType("text/html");
        HttpSession session = req.getSession();
			//session.setAttribute("user", "admin"); 
                  String s1=(String) session.getAttribute("user");
                  if(!s1.equals("admin"))
                  {
                      resp.sendRedirect("home.jsp");
                  }
        PChangeService ps = new PChangeService();
        //ps.insert();
        String id=req.getParameter("id");
        System.out.println("--"+id);
        String pwd=req.getParameter("password");
        System.out.println("=="+pwd);
        String saltedp=ps.change(pwd);
        System.out.println("salted password is:"+saltedp);
  
        SessionFactory session1 = new Configuration().configure().buildSessionFactory();
        Session s=session1.openSession();
         
      Transaction t=  s.beginTransaction();
        
        List list=s.createQuery("FROM Updatedup1").list();
        ArrayList<Defaultup> al= new ArrayList(list);
        
 for (int i = 1; i < al.size(); i++) {
                 
           
             System.out.println("********"+al.get(i));
         
        }
       t.commit();
        s.close();
        req.setAttribute("data", saltedp);
        req.setAttribute("id",id);
        req.setAttribute("List", al);
        
         
          RequestDispatcher rd =req.getRequestDispatcher("edit-process.jsp"); 
          rd.forward(req, resp);
               
    }
       
    }

    

