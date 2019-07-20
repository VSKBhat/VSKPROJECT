/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ihub.services;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author Veena SK
 */
public class UserLogin {
    public void insert() {
        SessionFactory session = new Configuration().configure().buildSessionFactory();
        Session s=session.openSession(); 
        Transaction tr=s.beginTransaction();
        int result = s.createSQLQuery( "INSERT INTO login(id) SELECT reciever FROM encrypteddata" ).executeUpdate();
        System.out.println("inserted"+result);
        tr.commit(); 
    }        
}
