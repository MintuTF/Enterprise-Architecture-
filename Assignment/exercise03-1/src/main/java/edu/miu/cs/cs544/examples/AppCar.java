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
        sessionFactory = HibernateUtils.getSessionFactory(Arrays.asList(Car.class,Owner.class));
    }

    public static void main(String[] args) {
        Session session = null;
        Transaction tx = null;
        try {
            session = sessionFactory.openSession();
            tx = session.beginTransaction();

            Owner owner=new Owner("smith","fairfield,US");
            Owner owner1=new Owner("william","tom,US");

            // Create new instance of Employee and set values in it
            Car car1 = new Car("BMW",2021,15000.00);
            car1.setOwner(owner);

            Car car2 = new Car("Toyota",2021,15000.00);
            car2.setOwner(owner1);

            session.persist(car1);
            session.persist(car2);
            tx.commit();


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
