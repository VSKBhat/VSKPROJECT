package com.ihub.services;
import com.ihub.model.Updatedup1;
import java.util.Date;
import java.util.Random;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import sun.misc.BASE64Encoder;
/**
 *
 * @author Veena SK
 */
public class PChangeService {
    private static Random rand = new Random((new Date()).getTime());
    public String change(String list) {
        String enc = encrypt(list);
        System.out.println("Encrypted string :" + enc);
        return enc;
    }
    public static String encrypt(String str) {
        BASE64Encoder encoder = new BASE64Encoder();
        byte[] salt = new byte[8];
        rand.nextBytes(salt);
        return encoder.encode(salt) + encoder.encode(str.getBytes());
    }
    public void insert() {
        SessionFactory session = new Configuration().configure().buildSessionFactory();
        Session s=session.openSession(); 
        Transaction tr=s.beginTransaction();
        int result = s.createSQLQuery( "INSERT INTO updatedup1 SELECT * FROM defaultup" ).executeUpdate();
        System.out.println("inserted"+result);
        tr.commit(); 
    }        
    public void updateAll(String pwd, Updatedup1 uo) {
        System.out.println("*******inside updateAll**********");
        SessionFactory session = new Configuration().configure().buildSessionFactory();
        Session s = session.openSession();
        s.beginTransaction();
        uo.setPassword(pwd);
        System.out.println("--" + uo.getSerialNo());
        s.saveOrUpdate(uo);
        s.getTransaction().commit();
        try {
            s.flush();
            s.close();
        } catch (HibernateException e) {
            s.getTransaction().rollback();
            e.printStackTrace();
        } finally {}
    }
    }

