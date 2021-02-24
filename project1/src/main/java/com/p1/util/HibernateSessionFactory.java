package com.p1.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateSessionFactory {
	private static SessionFactory sessionFactory;

	public static Session getSession() {
		if (sessionFactory == null) {
			sessionFactory = new Configuration().configure()
					.setProperty("hibernate.connection.url", System.getenv("url_aws"))
					.setProperty("hibernate.connection.username", System.getenv("postgres_username_aws"))
					.setProperty("hibernate.connection.password", System.getenv("postgres_password_aws")).buildSessionFactory();
		}

		return sessionFactory.getCurrentSession();
	}

}
