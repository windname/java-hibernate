package com.vg.hibernatetest;

import com.vg.autopark.dao.HibernateUtil;
import java.util.Iterator;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class App {
	public static void main(String[] args) {
		System.out.println("Maven + Hibernate + HSQL");
		App app = new App();
		app.saveContact("Vasea");
		app.saveContact("Petea");
		app.saveContact("Lena");
		app.listContact();

	}

	/*
	 * Save the data to database table
	 */
	public Integer saveContact(String contactName) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Integer contactId = null;
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			Contact contact = new Contact();
			contact.setName(contactName);
			contactId = (Integer) session.save(contact);
			transaction.commit();
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return contactId;
	}
	/*
	 *Lists the contacts from database table
	 */
	public void listContact() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			@SuppressWarnings("unchecked")
			List<Contact> contactList = session.createQuery("from Contact")
					.list();
			for (Iterator<Contact> iterator = contactList.iterator(); iterator
					.hasNext();) {
				Contact contact = (Contact) iterator.next();
				System.out.println(contact.getName());
			}
			transaction.commit();
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

}