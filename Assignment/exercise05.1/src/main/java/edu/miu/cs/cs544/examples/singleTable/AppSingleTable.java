package edu.miu.cs.cs544.examples.singleTable;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class AppSingleTable {
	private static SessionFactory sessionFactory;

	static {
		sessionFactory = HibernateUtils.getSessionFactory(Arrays.asList(Customer.class, Order.class,
				OrderLine.class, edu.miu.cs.cs544.examples.singleTable.Product.class, edu.miu.cs.cs544.examples.singleTable.CD.class, DVD.class, Book.class));
	}

	public static void main(String[] args) {
		// Hibernate placeholders
		Session session = null;
		Transaction tx = null;
		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			
		Customer customer=new Customer("smith","john");
		Customer customer1=new Customer("mane","muni");

		Order order =new Order(new Date(2020,12,01));
		Order order1 =new Order(new Date(2019,12,01));
		Order order2 =new Order(new Date(2021,12,01));

		OrderLine orderLine=new OrderLine(2);


		//Product  product =new Product("Mobile","mobile phone samsung s12");

			Product cd=new CD("Game","movie","Game");
			Product dvd=new DVD("DVD","File and Dvd","DvD");
			Product book=new Book("Dvd","File movie and book","book");

			orderLine.setProduct(cd);
			orderLine.setProduct(dvd);
			orderLine.setProduct(book);
		order.addOrderList(orderLine);
		order1.addOrderList(orderLine);
		order2.addOrderList(orderLine);

			customer.addOrder(order);
			customer.addOrder(order1);
			customer1.addOrder(order2);


			// product item inhertance




		    session.persist(customer);
			session.persist(customer1);
			session.persist(order);
			session.persist(order1);
			session.persist(order2);
			session.persist(orderLine);
			session.persist(cd);
			session.persist(dvd);
			session.persist(book);



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
         List<Customer> customers=
		session.createQuery("select e from Customer e ").list();

	   for (Customer customer:customers){

	   	System.out.println(customer);
	   }

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