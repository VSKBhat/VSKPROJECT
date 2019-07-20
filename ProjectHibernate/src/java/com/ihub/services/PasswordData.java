/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ihub.services;

import com.ihub.model.Defaultup;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Veena SK
 */
public class PasswordData {
    private static final List<KeyValue> pieDataList;
    
    static{
        System.out.println("inside static");
        pieDataList= new ArrayList<PasswordData.KeyValue>();
        int s = 0;
        ArrayList<String> key = funkey();
        for(int i=0;i<key.size();i++){
         s  = funvalue(key.get(i));
         pieDataList.add(new KeyValue(key.get(i), s));
        }
       
    }
     public static List<KeyValue> getPieDataList() {
        return pieDataList;
}

    private static ArrayList<String> funkey() {
        System.out.println("inside funkey");
       SessionFactory session = new Configuration().configure().buildSessionFactory();
        Session s=session.openSession();
        
            s.beginTransaction();
             
            Criteria criteria = s.createCriteria(Defaultup.class);
            criteria.setProjection(Projections.groupProperty("password"));
     ArrayList<String> list=(ArrayList<String>) criteria.list();
    for(int i=0;i<list.size();i++){
        System.out.println("***"+list.get(i));
    }
    return list;
    
    }

    private static int funvalue(String key) {
        System.out.println("inside funvalue");
        SessionFactory session = new Configuration().configure().buildSessionFactory();
        Session s=session.openSession();
        Criteria criteria = s.createCriteria(Defaultup.class);
         int c;
            s.beginTransaction();
     criteria.add(Restrictions.ilike("password",key));
            List<Defaultup> count1 = (List<Defaultup>) criteria.list();

            c=count1.size();
            System.out.println("****"+c);
             s.getTransaction().commit();  
    return c;
    
    }
public static class KeyValue {
        String key;
        int value;

        public KeyValue(String key, int value) {
            super();
            this.key = key;
            this.value = value;
        }
   public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }
      


}

}
    

