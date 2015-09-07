/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.vg.autopark.dao;

import com.vg.autopark.Driver;
import org.hibernate.Session;

/**
 *
 * @author 1
 */
public class DriverDAOImpl {
  public void addDriver(Driver driver) {
  Session session = null;
    try {
      session = HibernateUtil.getSessionFactory().openSession();
      session.beginTransaction();
      session.save(driver);
      session.getTransaction().commit();
    } catch (Exception e) {
        System.err.println(e);
    } finally {
      if (session != null && session.isOpen()) {

        session.close();
      }
    }
  }  
}
