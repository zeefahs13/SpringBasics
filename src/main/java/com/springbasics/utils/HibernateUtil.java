package com.springbasics.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static SessionFactory sessionFactory;
	private static Session session;
	
	private HibernateUtil() {
		
	}

	public static Session getSession() {
		if (session == null) {
			sessionFactory = new Configuration().configure().buildSessionFactory();
			session = sessionFactory.openSession();
		}
		return session;
	}

	
	public static void endSession() {
		if(session!=null) {
			session.close();
			sessionFactory.close();
		}
		
	}
	
	
	
}
