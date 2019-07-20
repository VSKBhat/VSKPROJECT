/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ihub.controller;

import com.ihub.model.UserDetails;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Veena SK
 */
public class Test {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
         String sql= "select * from user where id= ? and password=?" ;
        Connection c= DriverManager.getConnection("jdbc:mysql://localhost:3306/defaultusernamepasswrdtable","root","veena123");
        PreparedStatement ps=c.prepareStatement(sql);
        String id="veena!--";
        ps.setString(1, id);
        String password ="mu@123";
        ps.setString(2, password);
        ResultSet rs=ps.executeQuery();
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
    }
}
