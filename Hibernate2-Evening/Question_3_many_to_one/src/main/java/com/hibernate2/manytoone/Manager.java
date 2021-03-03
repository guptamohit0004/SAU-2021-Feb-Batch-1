package com.hibernate2.HibernateManyToOneDemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Manager
{
    public static void main( String[] args )
    {
    	UserDetails user = new UserDetails(); 
    	Vehicle vehicle1 = new Vehicle(); 
    	Vehicle vehicle2 = new Vehicle(); 
    	vehicle1.setVehicleName("Creta Car");
    	vehicle1.setUser(user); 
    	vehicle2.setVehicleName("Verna Car");
    	vehicle2.setUser(user);
    	user.setUserName("Mohit Gupta");
    	SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
    	Session session = sessionFactory.openSession();
    	session.beginTransaction();
    	session.save(vehicle1);
    	session.save(vehicle2);
    	session.save(user);
    	session.getTransaction().commit();
    	session.close();
    }
}
