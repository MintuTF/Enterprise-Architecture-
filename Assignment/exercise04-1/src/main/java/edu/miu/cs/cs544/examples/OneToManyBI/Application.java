package edu.miu.cs.cs544.examples.OneToManyBI;

import java.util.Arrays;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class Application {
	private static SessionFactory sessionFactory;

	static {
		sessionFactory = HibernateUtils.getSessionFactory(Arrays.asList(Employee.class, Laptop.class));
	}

	public static void main(String[] args) {
		// Hibernate placeholders
		Session session = null;
		Transaction tx = null;
		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			
			// Create new instance of Employee and set values in it


			Laptop laptop=new Laptop("HP","HP core i7");
			Laptop laptop1=new Laptop("Lenove","core i7 with touch screan");

			Employee employee=new Employee("smith","john",laptop);
			Employee employee1=new Employee("wende","aman",laptop1);


           session.persist(employee);
			session.persist(employee1);
			session.persist(laptop);
			session.persist(laptop1);

			tx.commit();
		} catch (HibernateException e) {
			tx.rollback();
			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}
		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			// retrieve all persons
			//List<Person> personList = session.createQuery("from Person", Person.class).list();
//			for (Person p : personList) {
//				System.out.println(p);
//			}
			tx.commit();
		} catch (HibernateException e) {
			tx.rollback();
			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}
		
		// Close the SessionFactory (not mandatory)
		sessionFactory.close();
	}
}