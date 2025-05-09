package com.online.Util;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.online.entity.Customer;
import com.online.entity.Admin;
import com.online.entity.Order;
import com.online.entity.Payment;
import com.online.entity.Product;
public class HibernateUtil {
	private final static SessionFactory sessionFactory=buildSessionFactory();
	private static SessionFactory buildSessionFactory()

	{

		try {
			return new Configuration().configure("hibernate.cfg.xml")
					.addAnnotatedClass(Admin.class)// Map Admin entity
					.addAnnotatedClass(Customer.class)// Map Customer entity
					.addAnnotatedClass(Order.class)// Map order entity
				    .addAnnotatedClass(Payment.class)// Map Payment entity
					.addAnnotatedClass(Product.class)// Map Product entity
					.buildSessionFactory();
			
		}catch (Throwable e) {
			throw new ExceptionInInitializerError(e);// Handle initialization errors
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory; // Get the SessionFactory instance
	}

	public static Session getSession()
	{
	  return getSessionFactory().openSession(); //session opened
	}
}
	

