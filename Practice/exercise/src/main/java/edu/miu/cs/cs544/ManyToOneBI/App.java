package edu.miu.cs.cs544.ManyToOneBI;

import edu.miu.cs.cs544.ManyToOne.examples.Car;
import edu.miu.cs.cs544.ManyToOne.examples.HibernateUtils;
import edu.miu.cs.cs544.ManyToOne.examples.Owner;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.Arrays;

public class App {

    private static SessionFactory sessionFactory;

    static {
        sessionFactory= HibernateUtils.getSessionFactory(Arrays.asList(Department.class, Office.class,Employee.class));

    }


    public static void main (String arg[]){
        Session session=null;
        Transaction txn=null;


        try{
            session=sessionFactory.openSession();
            txn=session.beginTransaction();
      //String brand, int year, double price)

            Department department=new Department("compro");
            Employee employee=new Employee("smith");
            Office office=new Office("building argiro");

            department.addEmployye(employee);
            office.addEmployee(employee);

            session.persist(employee);
            session.persist(department);
            session.persist(office);
            txn.commit();


        }
        catch (Exception e){
          txn.rollback();
            e.printStackTrace();

        } finally {
            if (session != null)
                session.close();
        }


        try{

            session=sessionFactory.openSession();
            txn=session.beginTransaction();

         //   Car car=session.load(Car.class,1L);
          //  session.delete(car);
            txn.commit();

        } catch(Exception e){
           txn.rollback();
           e.printStackTrace();
        }

        //close the connection pool
        sessionFactory.close();
    }





}
