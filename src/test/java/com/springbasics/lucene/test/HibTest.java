package com.springbasics.lucene.test;


import org.hibernate.Session;
import org.hibernate.Transaction;

import com.springbasics.model.Customer;
import com.springbasics.model.Order;
import com.springbasics.utils.HibernateUtil;

public class HibTest {
	
	
	
	
	public static void main(String[] args) {
		Customer customer = new Customer();
		customer.setAddress("Hyderabad,Telangana");
		customer.setCity("Hyderabad");
		customer.setCompany("RightTech");
		customer.setCountry("India");
		customer.setCustomerName("Hafeez");
		customer.setEmail("zeefahs13@gmail.com");
		customer.setMobile("9014372102");
		Session session = HibernateUtil.getSession();
		Transaction transaction = session.beginTransaction();

		// Saving of a record
//		 session.save(customer);

		// save or update a record based on its existence
		session.saveOrUpdate(customer);
		transaction.commit();
		// Update procedure for updating hibernate record
		// knows in advance for sureshot the record exists
//		transaction =null;
//		transaction = session.beginTransaction();
//		Customer customerec = session.load(Customer.class, 1);
//		System.out.println("Before Updating:" + customerec.toString());
//		customerec.setCompany("ProgressUpdate2Tech");
//		session.update(customerec);
//		transaction.commit();
//		System.out.println("After Updating:" + customerec.toString());

		// Delete record
//		Customer delrec = session.load(Customer.class, 4);
//		session.delete(delrec);

		transaction = session.beginTransaction();
		Order order = new Order();
		
		order.setOrderAmount(100);
		order.setOrderNumber(1000000);
		
		session.save(order);
		transaction.commit();
		HibernateUtil.endSession();

	}

}
