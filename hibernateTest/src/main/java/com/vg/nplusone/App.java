/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.vg.nplusone;

import java.util.List;
import org.hibernate.FetchMode;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author 1
 */
public class App {
    public static void main(String[] args) {
        
        save();
        
        readSimpleMethod();
        
//        readWithJoinCriteria();
        
        readWithJoinHQL();
    }

    private static void save() throws HibernateException {
        Session session = NPlusOneHibernateUtil.getSessionFactory().openSession();
        
        session.beginTransaction();
        User u = new User();
        u.setUserId(1);
        u.setName("Uasea");
        u.setAge(25);
        session.save(u);
        
        Permision p1 = new Permision();
        p1.setPermisionId(1);
        p1.setRole("admin");
        p1.setUser(u);
        Permision p2 = new Permision();
        p2.setPermisionId(2);
        p2.setRole("user");
        p2.setUser(u);
        
        u.getPermisions().add(p1);
        u.getPermisions().add(p2);
        
        session.save(p1);
        session.save(p2);
        
        session.getTransaction().commit();
    }
    
    private static void readSimpleMethod() {
         Session session = NPlusOneHibernateUtil.getSessionFactory().openSession();
        
	session.beginTransaction();
        User u = (User) session.get(User.class, 1);
        System.out.println(u.getName());
        for (Permision p : u.getPermisions()) {
            System.out.println(p.getRole());
        }
        
        session.getTransaction().commit();
    }
    
    /**
     * try to use FetchMode = JOIN with criteria
     * it doesn't work as expected
     */
    private static void readWithJoinCriteria() {
         Session session = NPlusOneHibernateUtil.getSessionFactory().openSession();
        
	session.beginTransaction();
        User u = (User) session.createCriteria(User.class)
                .setFetchMode("permissions", FetchMode.JOIN)
                .add( Restrictions.idEq(1) )
                .uniqueResult();
        System.out.println(u.getName());
        for (Permision p : u.getPermisions()) {
            System.out.println(p.getRole());
        }
        
        session.getTransaction().commit();
    }
    
    /**
     * in this method  i use HQL with join fetch to have just on select that makes join user with permission
     * works as expected!
     */
    private static void readWithJoinHQL() {
         Session session = NPlusOneHibernateUtil.getSessionFactory().openSession();
        
	session.beginTransaction();
        List list = session.createQuery("from User as u join fetch u.permisions as p where u.userId = 1").list();
        User u = (User) list.get(0);
        System.out.println(u.getName());
        for (Permision p : u.getPermisions()) {
            System.out.println(p.getRole());
        }
        
        session.getTransaction().commit();
    }
    
}
