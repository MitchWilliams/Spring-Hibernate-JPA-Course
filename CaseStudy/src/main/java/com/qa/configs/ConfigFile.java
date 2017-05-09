package com.qa.configs;

import org.hibernate.SessionFactory;
import org.hibernate.jpa.HibernateEntityManagerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.qa.models.BookOrder;
import com.qa.models.RegisteredUser;
import com.qa.models.ShoppingCart;

@Configuration
public class ConfigFile {
	
	@Bean
	public SessionFactory sessionFactory(HibernateEntityManagerFactory hemf)
	{
		
		return hemf.getSessionFactory();
		
	
	}
	
	@Bean
	public ShoppingCart shoppingCart()
	{
		ShoppingCart cart = new ShoppingCart();
		
		return cart;
	}
	
	@Bean
	public boolean isLoggedIn()
	{
		boolean isLoggedIn = false;
		return isLoggedIn;
	}
	
	@Bean
	public RegisteredUser loggedInUser()
	{
		RegisteredUser loggedInUser = new RegisteredUser();
		
		return loggedInUser;
	}
	
	@Bean
	public BookOrder bookOrder()
	{
		BookOrder bookOrder = new BookOrder();
		
		return bookOrder;
	}

}
