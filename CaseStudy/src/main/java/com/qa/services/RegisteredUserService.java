package com.qa.services;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.models.Book;
import com.qa.models.RegisteredUser;

@Service
public class RegisteredUserService {

	@Autowired
	private SessionFactory sessionFactory;
	
	public void registerUser(RegisteredUser u)
	{
		//Create session object
		
		Session session = sessionFactory.openSession();
		
		//Begin a transaction 
		
		Transaction tx = session.beginTransaction();
		
		//Submit customer object to Hibernate session
		
		session.save(u);
		
		
		//Commit the transaction
		
		tx.commit();
		
		//Close session
		
		session.close();
		
		//return 0;
	}
	
	public void updateUser(RegisteredUser u)
	{
		//Create session object
		
		Session session = sessionFactory.openSession();
		
		//Begin a transaction 
		
		Transaction tx = session.beginTransaction();
		
		//Submit customer object to Hibernate session
		
		session.update(u);
		
		
		//Commit the transaction
		
		tx.commit();
		
		//Close session
		
		session.close();
		
		//return 0;
	}
	
	public List<RegisteredUser> loginProcess(String email, String password)
	{
		//Create session object
		
		Session session = sessionFactory.openSession();
				
		//Begin a transaction 
				
		//Transaction tx = session.beginTransaction();
		
		//Query using HQL (Hibernate Query Language)
		Query query = session.createQuery("from RegisteredUser u where u.email = :email and u.password = :password");
		
		query.setParameter("email", email);
		query.setParameter("password", password);
		
		List<RegisteredUser> userList = query.list();
		
		return userList;
		

	}
	
}
