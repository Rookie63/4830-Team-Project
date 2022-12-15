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

import datamodel.Item;
import datamodel.User;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * @since JavaSE-1.8
 */
public class Util_Item {
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

   public static List<Item> listItems() {
      List<Item> resultList = new ArrayList<Item>();

      Session session = getSessionFactory().openSession();
      Transaction tx = null;  // each process needs transaction and commit the changes in DB.

      try {
         tx = session.beginTransaction();
         List<?> items = session.createQuery("FROM Item").list();
         for (Iterator<?> iterator = items.iterator(); iterator.hasNext();) {
            Item item = (Item) iterator.next();
            resultList.add(item);
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

   public static List<Item> listItemByType(String keyword) {
      List<Item> resultList = new ArrayList<Item>();

      Session session = getSessionFactory().openSession();
      Transaction tx = null;

      try {
         tx = session.beginTransaction();
         System.out.println((Item)session.get(Item.class, 1)); // use "get" to fetch data
        // Query q = session.createQuery("FROM Employee");
         List<?> items = session.createQuery("FROM Item").list();
         for (Iterator<?> iterator = items.iterator(); iterator.hasNext();) {
            Item item = (Item) iterator.next();
            if (item.getName().toLowerCase().equals(keyword.toLowerCase())) {
               resultList.add(item);
            }
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
   
   public static List<Item> listItemByRoom(String keyword) {
	      List<Item> resultList = new ArrayList<Item>();

	      Session session = getSessionFactory().openSession();
	      Transaction tx = null;

	      try {
	         tx = session.beginTransaction();
	         System.out.println((Item)session.get(Item.class, 1)); // use "get" to fetch data
	        // Query q = session.createQuery("FROM Employee");
	         List<?> items = session.createQuery("FROM Item").list();
	         for (Iterator<?> iterator = items.iterator(); iterator.hasNext();) {
	            Item item = (Item) iterator.next();
	            if (item.getRooms().toLowerCase().contains(keyword.toLowerCase())) {
	               resultList.add(item);
	            }
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
   
   public static void createItem(String name, String description, String price, boolean pickup, boolean delivery, String locations, String rooms) {
      Session session = getSessionFactory().openSession();
      Transaction tx = null;
      try {
         tx = session.beginTransaction();
         session.save(new Item(name, description, price, pickup, delivery, locations, rooms));
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
