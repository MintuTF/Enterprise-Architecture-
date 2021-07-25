package edu.miu.cs.cs544.ManyToOne.examples;

import edu.miu.cs.cs544.ManyToManyBI.Course;
import edu.miu.cs.cs544.ManyToManyBI.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.Arrays;

public class App {

    private static SessionFactory sessionFactory;

    static {
        sessionFactory=HibernateUtils.getSessionFactory(Arrays.asList(Student.class, Course.class));

    }


    public static void main (String arg[]){
        Session session=null;
        Transaction txn=null;


        try{
            session=sessionFactory.openSession();
            txn=session.beginTransaction();
      //String brand, int year, double price)

        Student student=new Student("minte","fikre");
        Student student1=new Student("john","smith");
        Course course=new Course("cs389","MPP");
        Course course1=new Course("cs344","MWA");
        Course course3=new Course("cs555","EA");
        student.addCourse(course);
        student.addCourse(course1);

        student1.addCourse(course3);

        session.persist(student);
        session.persist(student1);
        session.persist(course);
            session.persist(course1);
            session.persist(course3);
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

          //  Car car=session.load(Car.class,1L);
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
