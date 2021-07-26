package edu.miu.cs.cs544.examples.OneToManyUni;


import edu.miu.cs.cs544.examples.OneToManyUi.Flight;
import edu.miu.cs.cs544.examples.OneToManyUi.Passenger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.time.LocalDate;
import java.util.Arrays;

public class Application {
	private static SessionFactory sessionFactory;

	static {
		sessionFactory = HibernateUtils.getSessionFactory(Arrays.asList(Student.class, School.class));
	}

	public static void main(String[] args) {
		// Hibernate placeholders
		Session session = null;
		Transaction tx = null;
		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			
			// Create new instance of Employee and set values in it

			Student student=new Student(125,"john","smith");
			Student student1=new Student(142,"wende","man");

			Student student4=new Student(125,"john","smith");
			Student student3=new Student(142,"wende","man");

			School school=new School("MIU",student);
			school.addStudent(student4);

			School school1=new School("MIU",student1);
			school1.addStudent(student3);
            session.persist(school);
			session.persist(school1);


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