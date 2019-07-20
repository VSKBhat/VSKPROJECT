/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ihub.services;

import com.ihub.model.Defaultup;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author Veena SK
 */
public class UpdatedTableDisplay {
    public ArrayList readData() {
       
        SessionFactory session = new Configuration().configure().buildSessionFactory();
        Session s=session.openSession();
         
      Transaction t=  s.beginTransaction();
        
        List list=s.createQuery("FROM Updatedup1").list();
        ArrayList<Defaultup> al= new ArrayList(list);
        
 for (int i = 1; i < al.size(); i++) {
                 
           
             System.out.println("********"+al.get(i));
         
        }
       t.commit();
        s.close();
        return al;
    
}
}
