package edu.miu.cs.cs544.examples;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.Column;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class AppCar {

    private static SessionFactory sessionFactory;

    static {
        sessionFactory = HibernateUtils.getSessionFactory(Arrays.asList(Car.class));
    }

    public static void main(String[] args) {
        Session session = null;
        Transaction tx = null;
        try {
            session = sessionFactory.openSession();
            tx = session.beginTransaction();



            // Create new instance of Employee and set values in it
            Car car1 = new Car("BMW",2021,15000.00);
            Car car2 = new Car("Mercedes-Benz",2020,10000);
            Car car3 = new Car("Audi",2020,1000);

            session.persist(car1);
            session.persist(car2);
            session.persist(car3);
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

            List<Car> carsList=session.createQuery("select e from Car e",Car.class).list();
            for(Car car:carsList){
                System.out.println(car);

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

            Car car1=(Car) session.get(Car.class,1L);
            Car car2=(Car) session.get(Car.class,2L);
            car1.setPrice(5000);


            session.delete(car2);

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

            List<Car> carList=session.createQuery("select e from Car e",Car.class).list();
            for(Car car:carList){
                System.out.println(car);

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
