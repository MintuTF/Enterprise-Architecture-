package edu.miu.cs.cs544.examples.OneToManyUi;


import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.time.LocalDate;
import java.util.Arrays;

public class Application {
	private static SessionFactory sessionFactory;

	static {
		sessionFactory = HibernateUtils.getSessionFactory(Arrays.asList(Flight.class, Passenger.class));
	}

	public static void main(String[] args) {
		// Hibernate placeholders
		Session session = null;
		Transaction tx = null;
		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			
			// Create new instance of Employee and set values in it
            Flight flight=new Flight(474,"addis ababa","DC", LocalDate.of(2021,12,12));

			Passenger passenger=new Passenger("smith",flight);


			session.persist(passenger);

			session.persist(flight);


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