package edu.miu.cs.cs544.examples;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.Column;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class AppBook {

    private static SessionFactory sessionFactory;

    static {
        sessionFactory = HibernateUtils.getSessionFactory(Arrays.asList(Book.class));
    }

    public static void main(String[] args) {
        Session session = null;
        Transaction tx = null;
        try {
            session = sessionFactory.openSession();
            tx = session.beginTransaction();

            // Create new instance of Employee and set values in it
            Book book1 = new Book("seven habits of highly effective people",125,"Steven convey",15.0, new Date(2020,9,21));
            Book book2 = new Book("Deacon king kong",2165,"Jemes Macbrad",155.0, new Date(2020,02,20));
            Book book3 = new Book("Hamnet",56898,"Maggie",125.0, new Date(2012,1,22));

            session.persist(book1);
            session.persist(book2);
            session.persist(book3);
            tx.commit();
            session.close();


           // tx.commit();
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
            //List<Person> personList = session.createQuery("select e from Book e", Person.class).list();

            List<Book> bookList=session.createQuery("select e from Book e",Book.class).list();
            for(Book book:bookList){
                System.out.println(book);

            }

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

           Book book=(Book) session.get(Book.class,1L);
            Book book1=(Book) session.load(Book.class,2L);
           book.setTitle("Eight habit of");
           book.setPrice(125.50);

           session.delete(book1);

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

            List<Book> bookList=session.createQuery("select e from Book e",Book.class).list();
            for(Book book:bookList){
                System.out.println(book);

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
