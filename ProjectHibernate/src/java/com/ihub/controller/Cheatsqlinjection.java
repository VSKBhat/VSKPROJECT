
package com.ihub.controller;

import com.ihub.model.UserDetails;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
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
 * @author VeenaSk
 */
public class Cheatsqlinjection extends HttpServlet {

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
        try  {
            
            
            String id,password;
            id= request.getParameter("user_id");
            password=request.getParameter("password");
            /* TODO output your page here. You may use following sample code. */
            
            Class.forName("com.mysql.jdbc.Driver");
            Connection c= DriverManager.getConnection("jdbc:mysql://localhost:3306/defaultusernamepasswrdtable","root","veena123");
           Statement s= c.createStatement();
    ResultSet rs=s.executeQuery("select * from user where id= '"+id+"' and password='"+password+"'");
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
                  user1.display();
                  System.out.println("==="+userDetailList.toString());
            }
            System.out.println("==="+userDetailList.toString());
            
            
   request.setAttribute("userDetailList",userDetailList);
  
        RequestDispatcher rd=request.getRequestDispatcher("sqlinjectionresult.jsp");
         rd.forward(request, response);         
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Cheatsqlinjection.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Cheatsqlinjection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

  
}
