package com.qa.controllers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import com.qa.models.Book;
import com.qa.models.BookOrder;
import com.qa.models.RegisteredUser;
import com.qa.models.ShoppingCart;
import com.qa.services.OrderService;


@Controller
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	@Autowired
	private ShoppingCart shoppingCart;
	
	@Autowired
	private BookOrder bookOrder;
	
	//@Autowired
	//private RegisteredUser loggedInUser;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@RequestMapping("/orderCompleted")
	public ModelAndView orderCompleted()
	{
		

		for (int i = 0; i < shoppingCart.getBooks().size(); i++)
		{
			bookOrder.setBookTitle(shoppingCart.getBooks().get(i).getTitle());
			bookOrder.setOrderCost(shoppingCart.getBooks().get(i).getCost());
			bookOrder.setUserID(shoppingCart.getLoggedInUser().getId());
			
			orderService.addOrder(bookOrder);
		}
		
		List<Book> bookList = new ArrayList<Book>(shoppingCart.getBooks());
		
		ModelAndView mv = new ModelAndView ("order_completed", "bookList", bookList);
		
		shoppingCart.clearCart();
		
		return mv;
	}
	
	@RequestMapping("/orderHistory")
	public ModelAndView orderHistory()
	{
		return new ModelAndView ("order_history", "orderList", dbGetOrders(shoppingCart.getLoggedInUser().getId()));
		
	}
	
	private class BookOrderRowMapper implements RowMapper<BookOrder>
	{
		@Override
		public BookOrder mapRow(ResultSet rs, int rowNum) throws SQLException
		{
			
			
			BookOrder b = new BookOrder();
			b.setBookTitle(rs.getString("book_title"));
			b.setOrderCost(rs.getDouble("order_cost"));
			b.setUserID(rs.getInt("userid"));
			
			return b;
			
			
		}
	}
	
	private List<BookOrder> dbGetOrders(int userId)
	{
		String sql = "select * from book_order where userid = '" + userId + "'";
		return jdbcTemplate.query(sql, new BookOrderRowMapper());
	}

}
