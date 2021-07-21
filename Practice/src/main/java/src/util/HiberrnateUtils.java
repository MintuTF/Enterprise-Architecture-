package src.util;

import org.hibernate.SessionFactory;

import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import java.util.List;
import java.util.Properties;

public class HiberrnateUtils {

private static SessionFactory sessionFactory;
private static Configuration configuration=new Configuration();

public static SessionFactory getSessionFactory(List<Class> entityClasses){
 if (sessionFactory==null){
   try {

       Properties settings = new Properties();
       settings.put(Environment.DRIVER, "com.microsoft.sqlserver.jdbc.SQLServerDriver");
       settings.put(Environment.URL, "jdbc:sqlserver://LAPTOP-V1QJDHRL:1433"); //cs544.cs.miu.edu10.10.10.15
       settings.put(Environment.USER, "sa");
       settings.put(Environment.PASS, "sa123");
       settings.put(Environment.DIALECT, "org.hibernate.dialect.SQLServer2008Dialect");

       settings.put(Environment.SHOW_SQL, "true");

       settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");

       settings.put(Environment.HBM2DDL_AUTO, "create");

       configuration.setProperties(settings);

       entityClasses.forEach(entityClass -> configuration.addAnnotatedClass(entityClass));

       ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
               .applySettings(configuration.getProperties()).build();

       sessionFactory = configuration.buildSessionFactory(serviceRegistry);
   }
   catch (Exception e){

     }

 }

 return sessionFactory;


}



}
