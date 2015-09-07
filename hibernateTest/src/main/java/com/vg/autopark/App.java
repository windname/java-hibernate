/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vg.autopark;

import com.vg.autopark.dao.BusDAO;
import com.vg.autopark.dao.BusDAOImpl;
import com.vg.autopark.dao.DriverDAOImpl;
import com.vg.autopark.dao.HibernateUtil;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;
import org.hibernate.Session;

/**
 *
 * @author 1
 */
public class App {

    public static void main(String[] args) throws SQLException {

        // first save driver without bus 
        DriverDAOImpl driverDAO = new DriverDAOImpl();
        final Driver d1 = new Driver();
        d1.setName("Ion");
        driverDAO.addDriver(d1);
        // save bus with driver
        BusDAO busDAO = new BusDAOImpl();
        final Bus b1 = new Bus();
        b1.setNumber("cpt1");
        b1.setDrivers(new HashSet() {{add(d1);}});
        busDAO.addBus(b1);

        final Bus b2 = new Bus();
        b2.setNumber("cpt2");
        final Driver d2 = new Driver();
        d1.setName("Luca");
        d2.setBusses(new HashSet() {{add(b2);}});
        b2.setDrivers(new HashSet() {{add(d2);}});
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(b2);
            session.save(d2);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            if (session != null && session.isOpen()) {

                session.close();
            }
        }

        for (Bus bus : busDAO.getAllBusses()) {
            System.out.println(bus.getId() + " " + bus.getNumber());
            for (Driver d : bus.getDrivers()) {
                System.out.println(d.getId() + " " + d.getName());
            }
        }

    }
}
