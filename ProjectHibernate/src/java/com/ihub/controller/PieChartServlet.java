/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ihub.controller;

import com.ihub.services.PieChartData;
import javafx.animation.KeyValue;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Veena SK
 */
@WebServlet(name = "PieChartServlet", urlPatterns = {"/PieChartServlet"})
public class PieChartServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public PieChartServlet() {
        
        System.out.println("test");
    }
     protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException 
     {    
       
         HttpSession session = request.getSession();
			
                  String s1=(String) session.getAttribute("user");
                  if(!s1.equals("admin"))
                  {
                      response.sendRedirect("home.jsp");
                  }
         
          System.out.println("test");
          response.getWriter().print("test");
         List<PieChartData.KeyValue> pieDataList = PieChartData.getPieDataList();
         for(int i=0;i<pieDataList.size();i++){
         System.out.println("piedatalist contents"+pieDataList.get(i));
         }
             request.setAttribute("pieDataList", pieDataList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/view.jsp");
      requestDispatcher.forward(request, response);
    }
}
