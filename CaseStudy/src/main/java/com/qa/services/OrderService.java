package com.qa.services;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.models.Book;
import com.qa.models.BookOrder;

@Service
public class OrderService {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public void addOrder(BookOrder o)
	{
		//Create session object
		
		Session session = sessionFactory.openSession();
		
		//Begin a transaction 
		
		Transaction tx = session.beginTransaction();
		
		//Submit customer object to Hibernate session
		
		session.save(o);
		
		//Commit the transaction
		
		tx.commit();
		
		//Close session
		
		session.close();
		
		//return 0;
	}

}
