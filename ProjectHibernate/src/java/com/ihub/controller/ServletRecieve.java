/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ihub.controller;

import com.ihub.model.Encrypteddata;
import com.ihub.services.Decrypt;
import com.ihub.services.Encrypt;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Veena SK
 */
public class ServletRecieve extends HttpServlet {

   
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        // Get the pass from the form
String Message = request.getParameter("data");
 String reciever=request.getParameter("reciever");
 HttpSession session = request.getSession();
			//session.setAttribute("user", "admin"); 
                  String s1=(String) session.getAttribute("user");
                  if(!s1.equals("intelligent"))
                  {
                      response.sendRedirect("home.jsp");
                  }
                 PrintWriter out=response.getWriter();
        try{
// Generate a temporary key. In practice, you would save this key.
// See also e464 Encrypting with DES Using a Pass Phrase.
SecretKey key = KeyGenerator.getInstance("DES").generateKey();
 
// Create encrypter/decrypter class
Encrypt encrypter = new Encrypt(key);
 
String encodedKey = Base64.getEncoder().encodeToString(key.getEncoded());

// Encrypt
String encrypted = encrypter.encrypt(Message);
// Output
 
System.out.println("Encrypted: "+encrypted);

//Store to database

SessionFactory session1 = new Configuration().configure().buildSessionFactory();
        Session s=session1.openSession();
        Encrypteddata ed1=new Encrypteddata(); 
      Transaction tx=  s.beginTransaction();
      ed1.setMessage(encrypted);
      ed1.setReciever(reciever);
      ed1.setKeyVal(encodedKey);
      s.save(ed1);
      tx.commit();
      request.setAttribute("messageStatus", "Message sent successfully!");
      RequestDispatcher rd=request.getRequestDispatcher("sensorSendingData.jsp");
      rd.forward(request, response);
      s.close();

    }   catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(ServletRecieve.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalBlockSizeException ex) {
            Logger.getLogger(ServletRecieve.class.getName()).log(Level.SEVERE, null, ex);
        }

   
    
    }
}



