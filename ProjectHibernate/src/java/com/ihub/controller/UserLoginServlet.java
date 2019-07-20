/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ihub.controller;

import com.ihub.model.Defaultup;
import com.ihub.model.Encrypteddata;
import com.ihub.model.Login;
import com.ihub.services.Decrypt;
import com.ihub.services.UserLogin;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author Veena SK
 */
@WebServlet(name = "UserLogin", urlPatterns = {"/UserLogin"})
public class UserLoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String username=req.getParameter("username");
        String password=req.getParameter("password");
      //  UserLogin ul=new UserLogin();
      // ul.insert();
        
        SessionFactory session=new Configuration().configure().buildSessionFactory();
        Session s=session.openSession();
        Transaction t=  s.beginTransaction();
        List list2=s.createQuery("FROM Encrypteddata").list();
        ArrayList<Encrypteddata> alist2=new ArrayList<>(list2);
        ArrayList<String> msg=new ArrayList<>();
        String query = "from Login where id=? and password=?";
        Query queryObj = s.createQuery(query);
        queryObj.setString(0, username);
        queryObj.setString(1, password);
        List<Login> records = queryObj.list();
        if(records.size()>0){
      
        HttpSession session1 = req.getSession();
			session1.setAttribute("user", username);
			//setting session to expiry in 30 mins
			session1.setMaxInactiveInterval(30*60);
			Cookie userName = new Cookie("user", username);
			userName.setMaxAge(30*60);
			resp.addCookie(userName);

        for(int i=0;i<alist2.size();i++)
        {
            
            if(alist2.get(i).getReciever().equals(username))
            {
                try {
                    String keyVal=alist2.get(i).getKeyVal();
                    System.out.println("keyvalue*************************************"+keyVal);
                    // decode the base64 encoded string
                    byte[] decodedKey = Base64.getDecoder().decode(keyVal);
// rebuild key using SecretKeySpec
                    SecretKey originalKey = new SecretKeySpec(decodedKey, 0, decodedKey.length, "DES");
                    Decrypt decrypter = new Decrypt(originalKey);
                    String decrypted=decrypter.decrypt(alist2.get(i).getMessage());
                    System.out.println("decrypted message:"+decrypted);
                    
                    msg.add(decrypted);
                    for(int j=0;j<msg.size();j++)
                    {  
                        System.out.println("***************"+msg.get(j));
                        
                    }

                } catch (IllegalBlockSizeException ex) {
                    Logger.getLogger(UserLoginServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
                
        }
        
    } // end of for 
        req.setAttribute("message",msg);
        RequestDispatcher rd=req.getRequestDispatcher("clientRecievingData.jsp");
                rd.forward(req,resp);
        }// end of if 
       
       
     else
     {
          RequestDispatcher rd=req.getRequestDispatcher("error.jsp");
              rd.forward(req,resp);
        }
   //    }    
}
}
