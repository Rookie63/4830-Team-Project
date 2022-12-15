/**
 */
package util;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import datamodel.User;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * @since JavaSE-1.8
 */
public class UtilUser {
   static SessionFactory sessionFactory = null;

   public static SessionFactory getSessionFactory() {
      if (sessionFactory != null) {
         return sessionFactory;
      }
      Configuration configuration = new Configuration().configure();
      StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
      sessionFactory = configuration.buildSessionFactory(builder.build());
      return sessionFactory;
   }

   public static int login(String username, String password) {
	   Session session = getSessionFactory().openSession();
	   String sql = "FROM User U WHERE U.username='" + username +"' AND U.password='" +password +"'";
	   
	   
	   
	   
	   
	   List<User> users = session.createQuery(sql).list();
	   
	  if (users == null || users.isEmpty())
	  {
		  return 0;
	  }
	  else
	  {
	         Iterator<?> iterator = users.iterator();
	        	 User employee = (User) iterator.next();
	        	 if(employee.getAdmin() == 1)
	        		 return 1;
	        	 else
	        	 {
	        		 return 2;
	        	 }
	  }

   }
   

   
   public static List<User> listUsers() {
      List<User> resultList = new ArrayList<User>();

      Session session = getSessionFactory().openSession();
      Transaction tx = null;  // each process needs transaction and commit the changes in DB.

      try {
         tx = session.beginTransaction();
         List<?> employees = session.createQuery("FROM User").list();
         for (Iterator<?> iterator = employees.iterator(); iterator.hasNext();) {
        	 User employee = (User) iterator.next();
            resultList.add(employee);
         }
         tx.commit();
      } catch (HibernateException e) {
         if (tx != null)
            tx.rollback();
         e.printStackTrace();
      } finally {
         session.close();
      }
      return resultList;
   }


   public static void createUser(String username, String password) {
      Session session = getSessionFactory().openSession();
      Transaction tx = null;
      try {
         tx = session.beginTransaction();
         session.save(new User(username, password));
         tx.commit();
      } catch (HibernateException e) {
         if (tx != null)
            tx.rollback();
         e.printStackTrace();
      } finally {
         session.close();
      }
   }
   
}
