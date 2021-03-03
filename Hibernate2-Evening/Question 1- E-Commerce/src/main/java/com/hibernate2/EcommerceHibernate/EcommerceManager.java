package com.hibernate2.EcommerceHibernate;

import java.util.HashSet;
import java.util.Set;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hibernate2.Util.Util;

public class EcommerceManager
{
    public static void main( String[] args )
    {
    	Session session = Util.getSession();

		Product p1 = new Product();
		Product p2 = new Product();

		Categories c1 = new Categories();
		Categories c2 = new Categories();
		Categories c3 = new Categories();

		Supplier s1 = new Supplier();
		Supplier s2 = new Supplier();
		Supplier s3 = new Supplier();

		p1.setPid(001);
		p1.setPname("Car");
		p2.setPid(002);
		p2.setPname("Mobile");

		c1.setCid(1);
		c1.setCname("Car");
		c2.setCid(2);
		c2.setCname("Mobile");
		c3.setCid(3);
		c3.setCname("Medicine");

		s1.setSid(100);
		s1.setSname("Huyandi");
		s2.setSid(101);
		s2.setSname("One Plus");
		s3.setSid(102);
		s3.setSname("Cipla");

		Set<Categories> set1 = new HashSet<>();
		set1.add(c1);
		set1.add(c3);

		p1.setCategories(set1);

		Set<Categories> set2 = new HashSet<>();
		set2.add(c2);

		p2.setCategories(set2);

		c1.setProduct(p1);
		c2.setProduct(p2);
		c3.setProduct(p1);

		Set<Supplier> set3 = new HashSet<>();
		set3.add(s1);
		set3.add(s3);

		Set<Supplier> set4 = new HashSet<>();
		set4.add(s2);

		s1.setCategories(set1);
		s2.setCategories(set2);
		s3.setCategories(set1);

		c1.setSupplier(set3);
		c2.setSupplier(set4);
		c3.setSupplier(set3);


		Transaction tx = session.beginTransaction();

		session.save(p1);
		session.save(p2);
		session.save(c1);
		session.save(c2);
		session.save(c3);
		session.save(s1);
		session.save(s2);
		session.save(s3);

		tx.commit();
		session.close();
		System.out.println("Product to Categories - One to Many\n");
		System.out.println("Categories to Products - Many to One\n");
		System.out.println("Categories to Suppliers - Many to Many\n");
    }
}
