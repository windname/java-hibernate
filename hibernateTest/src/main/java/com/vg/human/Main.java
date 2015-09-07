/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vg.human;

import java.sql.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author 1
 */
public class Main {

    public static void main(String[] args) {
        new Main();
    }

    public Main() {
        Employee empl = new Employee("Jack", "Bauer", new Date(System.currentTimeMillis()), "911");
        empl = save(empl);
        Employee emp2 = read(empl.getId());
        System.out.println(emp2.getFirstname());
    }

    private static Employee read(Long id) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();

        Employee employee = (Employee) session.get(Employee.class, id);
        session.close();
        return employee;
    }

    private static Employee save(Employee employee) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();

        session.beginTransaction();

        Long id = (Long) session.save(employee);
        employee.setId(id);

        session.getTransaction().commit();

        session.close();

        return employee;
    }
}
