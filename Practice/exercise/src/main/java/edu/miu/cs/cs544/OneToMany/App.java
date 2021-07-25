package edu.miu.cs.cs544.OneToMany;

import edu.miu.cs.cs544.ManyToOne.examples.Car;
import edu.miu.cs.cs544.ManyToOne.examples.Owner;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.Arrays;
import java.util.List;

public class App {

    private static SessionFactory sessionFactory;

    static {
        sessionFactory= HibernateUtils.getSessionFactory(Arrays.asList(Employee.class, Department.class));

    }


    public static void main (String arg[]){
        Session session=null;
        Transaction txn=null;


        try{
            session=sessionFactory.openSession();
            txn=session.beginTransaction();
      //String brand, int year, double price)

Department department =new Department("Compro");
Employee employee=new Employee("minte");
Employee employee2=new Employee("john");

department.addEmployee(employee);
department.addEmployee(employee2);
session.persist(department);

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
