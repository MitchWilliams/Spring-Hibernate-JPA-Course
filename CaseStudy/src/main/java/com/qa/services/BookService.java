package com.qa.services;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.models.Book;

@Service
public class BookService {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public void addBook(Book b)
	{
		//Create session object
		
		Session session = sessionFactory.openSession();
		
		//Begin a transaction 
		
		Transaction tx = session.beginTransaction();
		
		//Submit customer object to Hibernate session
		
		session.save(b);
		
		//Commit the transaction
		
		tx.commit();
		
		//Close session
		
		session.close();
		
		//return 0;
	}
	
	
}
