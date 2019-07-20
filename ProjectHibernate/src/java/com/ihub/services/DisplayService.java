package com.ihub.services;




import com.ihub.model.Defaultup;
import static java.lang.System.out;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import static org.apache.taglibs.standard.tag.common.core.OutSupport.out;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Veena SK
 */
public class DisplayService {
   
     public ArrayList readData() {
       
        SessionFactory session = new Configuration().configure().buildSessionFactory();
        Session s=session.openSession();
         
      Transaction t=  s.beginTransaction();
        
        List list=s.createQuery("FROM Defaultup").list();
        ArrayList<Defaultup> al= new ArrayList(list);
        
 for (int i = 1; i < al.size(); i++) {
                 
           
             System.out.println("********"+al.get(i));
         
        }
       t.commit();
        s.close();
        return al;
        
         
     }
    public static void main(String[] args) {
        DisplayService ds = new DisplayService();
        Defaultup du=new Defaultup();
        ds.readData();
    }
}

 