package com.qa.controllers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.qa.models.Book;
import com.qa.models.ShoppingCart;
import com.qa.services.BookService;

@Controller
public class BookController extends BaseController {
	
	@Autowired
	private BookService bookService;
	
	@Autowired
	private ShoppingCart shoppingCart;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView index() throws SQLException
	{
	
		return new ModelAndView ("index", "bookList", dbGetBooks());
	}
	

	private class BookRowMapper implements RowMapper<Book>
	{
		@Override
		public Book mapRow(ResultSet rs, int rowNum) throws SQLException
		{
			
			
			Book b = new Book();
			b.setAuthor(rs.getString("author"));
			b.setTitle(rs.getString("title"));
			b.setBookType(rs.getString("book_type"));
			b.setCost(rs.getDouble("cost"));
			b.setIsbnNumber(rs.getString("isbn_number"));
			b.setStock(rs.getInt("stock"));
			return b;
			
			
		}
	}
	
	public List<Book> getMatchingBooks (String title)
	{
		List<Book> bookList = dbGetBooks();
		List<Book> matchList = new ArrayList<Book>();
		
		for (int i = 0; i < bookList.size(); i++)
		{
			if (bookList.get(i).getTitle().contains(title))
			{
				matchList.add(bookList.get(i));
			}
		}
		
		return matchList;
	}
	
	@RequestMapping("/addToCart")
	public ModelAndView addToCartProcess(@RequestParam("title") String title)
	{
		
		List<Book> matchList = getMatchingBooks(title);
		
		shoppingCart.addBook(matchList.get(0));
		
		ModelAndView mv = new ModelAndView ("add_to_cart_successful", "bookList", matchList);
		
		return mv;
		
	}
	
	@RequestMapping("/viewCart")
	public ModelAndView viewCart()
	{
		
		ModelAndView mv = new ModelAndView ("cart_overview", "bookList", shoppingCart.getBooks());
		
		
		return mv;
	}
	
	@RequestMapping("/removeFromCart")
	public ModelAndView removeFromCart(@RequestParam("title") String title)
	{
		shoppingCart.removeBook(title);
		
		ModelAndView mv = new ModelAndView ("cart_overview", "bookList", shoppingCart.getBooks());
		
		return mv;
	}
	
	@RequestMapping("/bookSearch")
	public ModelAndView bookSearch(@RequestParam("title") String title)
	{
	
		List<Book> matchList = getMatchingBooks(title);

		ModelAndView mv = new ModelAndView ("index", "bookList", matchList);
		
		return mv;
	}
	
	@RequestMapping("/book_details")
	public ModelAndView bookDetails(@RequestParam("title") String title)
	{
		List<Book> matchList = getMatchingBooks(title);
		
		ModelAndView mv = new ModelAndView ("book_details", "bookList",matchList );
		
		return mv;
	}
	
	private List<Book> dbGetBooks()
	{
		String sql = "select * from book";
		return jdbcTemplate.query(sql, new BookRowMapper());
	}
	

}
