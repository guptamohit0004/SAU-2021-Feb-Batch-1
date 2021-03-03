package com.accolite.manytomany.Question2_FixManyToMany;

import java.util.HashSet;
import java.util.Set;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.accolite.util.Util;

public class Manager1 {
	public static void main(String args[]) {
		Session ses = Util.getSession();
		Categories c1 = new Categories();
		c1.setCategoryId(100);
		c1.setCategoryName("Category 1");
		Categories c2 = new Categories();
		c2.setCategoryId(200);
		c2.setCategoryName("Category 2");
		Item i1 = new Item();
		Item i2 = new Item();
		i1.setItemId(1001);
		i1.setItemName("Item 1");
		i2.setItemId(1003);
		i2.setItemName("Item 2");
		Set itemSet = new HashSet();
		itemSet.add(i1);
		itemSet.add(i2);
		c1.setItems(itemSet);
		c2.setItems(itemSet);
		Set categorySet = new HashSet();
		categorySet.add(c1);
		categorySet.add(c2);
		i1.setCategories(categorySet);
		i2.setCategories(categorySet);
		Transaction tx = ses.beginTransaction();
		ses.save(c1);
		ses.save(c2);
		ses.save(i1);
		ses.save(i2);
		tx.commit();
		System.out.println("Man to Many Done");
		ses.close();
	}
}
