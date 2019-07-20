/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ihub.controller;


import com.ihub.model.UserDetails;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Veena SK
 */
public class PreventSqlInjection extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String id=request.getParameter("id");
        String password=request.getParameter("password");
        try {
            Class.forName("com.mysql.jdbc.Driver");
         String sql= "select * from user where id= ? and password=?" ;
        Connection c= DriverManager.getConnection("jdbc:mysql://localhost:3306/defaultusernamepasswrdtable","root","veena123");
        PreparedStatement ps=c.prepareStatement(sql);
        ps.setString(1, id);
        ps.setString(2, password);
        ResultSet rs=ps.executeQuery();
        if(rs.getString(1).equals(id)&&rs.getString(2).equals(password)){
         List<UserDetails> userDetailList= new ArrayList<UserDetails>() ;
         while(rs.next())
            {
                UserDetails user1 = new UserDetails();
                user1.setUserId(rs.getString(1));
                user1.setPassword(rs.getString(2));
                user1.setDeviceInfo(rs.getString(3));
                System.out.println("----"+rs.getString(1)+" user "+user1.getUserId());
                 System.out.println("---"+rs.getString(2)+" user "+user1.getPassword());
                userDetailList.add(user1);
            }
         request.setAttribute("userDetailList",userDetailList);
        RequestDispatcher rd=request.getRequestDispatcher("preventSqlInjectionResult.jsp");
         rd.forward(request, response); 
        }
        }
       
catch (ClassNotFoundException ex) {
            Logger.getLogger(PreventSqlInjection.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            RequestDispatcher rd=request.getRequestDispatcher("error.jsp");
            rd.forward(request, response);
        }
}
}