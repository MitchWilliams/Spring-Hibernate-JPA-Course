package com.qa.models;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
	
	private List<Book> books;
	private double cost;
	private RegisteredUser loggedInUser;
	
	public ShoppingCart()
	{
		books = new ArrayList<Book>();
	}
	
	
	
	public List<Book> getBooks() {
		return books;
	}


	public double getCost()
	{
		cost = 0;
		
		for (int i = 0; i < books.size(); i++)
		{
			cost += books.get(i).getCost();
		}
		
		return cost;
	}
	
	//add book
	public void addBook(Book b)
	{
		books.add(b);
	}
	
	//remove book
	
	public void removeBook(String title)
	{
		for (int i = 0; i < books.size(); i++)
		{
			if (books.get(i).getTitle().equals(title))
			{
				books.remove(i);
			}
		}
	}
	
	//clear cart
	
	public void clearCart()
	{
		books.clear();
	}



	public RegisteredUser getLoggedInUser() {
		return loggedInUser;
	}



	public void setLoggedInUser(RegisteredUser loggedInUser) {
		this.loggedInUser = loggedInUser;
	}
	
	

}
