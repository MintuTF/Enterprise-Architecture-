package edu.miu.cs.cs544.examples;


import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class Application {
	private static SessionFactory sessionFactory;

	static {
		sessionFactory = HibernateUtils.getSessionFactory(Arrays.asList(Doctor.class,Appointment.class,Patient.class,Payment.class));
	}

	public static void main(String[] args) {
		Session session = null;
		Transaction tx = null;

		// Create 3 doctors and save them to database
		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();

			System.out.println("\n------------------------Creating data------------------------------");
			// Create new instance of Doctor and set values in it
			Doctor doctor1 = new Doctor("Eye", "Dag", "Wor");
			Doctor doctor2 = new Doctor("Brain", "Tag", "Sie");
			Doctor doctor3 = new Doctor("Heart", "Alpha", "Bravo");

			Patient patient1 = new Patient("John", "Ab street", "1000", "Fairfield");
			Patient patient2 = new Patient("Dalton", "Ba street", "2000", "NY");
			Patient patient3 = new Patient("Henry", "Cc street", "3000", "Harlem");

			Payment payment1 = new Payment(LocalDate.now(), 80);
			Payment payment2 = new Payment(LocalDate.now(), 450);
			Payment payment3 = new Payment(LocalDate.now(), 37);


			// Create new instance of Doctor and set values in it
			Appointment appointment1 = new Appointment(LocalDate.now(), patient1, payment1,doctor1);
			Appointment appointment2 = new Appointment(LocalDate.now(), patient2, payment2,doctor1);
			Appointment appointment3 = new Appointment(LocalDate.now(), patient3, payment3,doctor1);



			System.out.println("\n------------------------Saving data------------------------------");

			//save doctor
			session.persist(appointment1);
			session.persist(appointment2);
			session.persist(appointment2);

			tx.commit();

		} catch (HibernateException e) {
			tx.rollback();
			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}

		System.out.println("\n------------------------Retrieving all the Doctors with their owners------------------------------");
		// Retrieve all doctors with the corresponding owners and Output to the console
		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			// retrieve all Doctors
//			List<Doctor> doctorList = session.createQuery("from Doctor", Doctor.class).list();
//			for (Doctor d : doctorList) {
//				System.out.println(d);
//			}
			tx.commit();
		} catch (HibernateException e) {
			tx.rollback();
			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}
		sessionFactory.close();
	}

}
