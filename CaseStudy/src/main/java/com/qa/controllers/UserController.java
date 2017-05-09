package com.qa.controllers;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.qa.models.RegisteredUser;
import com.qa.models.ShoppingCart;
import com.qa.services.RegisteredUserService;

@Controller
public class UserController extends BaseController{
	
	@Autowired
	private RegisteredUserService userService;
	
	@Autowired
	private ShoppingCart shoppingCart;
	
	@Autowired
	protected boolean isLoggedIn;
	
	@RequestMapping("/checkoutRedirect")
	public ModelAndView checkoutRedirect()
	{
	
		ModelAndView mv = null;
		
		if(isLoggedIn == true)
		{
			mv = new ModelAndView ("checkout", "bookList", shoppingCart.getBooks());
		}
		else
		{
			mv = new ModelAndView("login_form");
		}
		
		return mv;
	}
	
	@RequestMapping("/myAccountRedirect")
	public ModelAndView myAccountRedirect()
	{
		ModelAndView mv = null;
		
		
		if(isLoggedIn == true)
		{
			List<RegisteredUser> custList = userService.loginProcess(shoppingCart.getLoggedInUser().getEmail(), shoppingCart.getLoggedInUser().getPassword());
			mv = new ModelAndView ("my_account", "custList", custList);
		}
		else
		{
			mv = new ModelAndView("login_form");
		}
		
		return mv;
	}
	
	@RequestMapping("/editAccount")
	public ModelAndView editAccount()
	{
		ModelAndView mv = null;
		List<RegisteredUser> custList = userService.loginProcess(shoppingCart.getLoggedInUser().getEmail(), shoppingCart.getLoggedInUser().getPassword());
		mv = new ModelAndView ("edit_account", "custList", custList);
		return mv;
	}
	
	@RequestMapping("/editProcess")
	public ModelAndView editProcess(@ModelAttribute RegisteredUser u)
	{
		userService.updateUser(u);
		shoppingCart.setLoggedInUser(u);
		List<RegisteredUser> custList = userService.loginProcess(shoppingCart.getLoggedInUser().getEmail(), shoppingCart.getLoggedInUser().getPassword());
		ModelAndView mv = new ModelAndView ("my_account", "custList", custList);
		return mv;
	}
	
	@RequestMapping("/register")
	public String register()
	{
		
		return "register_form";
	}
	
	@RequestMapping("/login")
	public String login()
	{
		
		return "login_form";
	}
	
	@RequestMapping("/registerProcess")
	public void registerProcess(@ModelAttribute RegisteredUser u)
	{
		userService.registerUser(u);
	}
	
	@RequestMapping("/loginProcess")
	public ModelAndView loginProcess(@RequestParam("email") String email, @RequestParam("password") String password)
	{
		List<RegisteredUser> custList = userService.loginProcess(email, password);
		ModelAndView mv = null;
		
		if(custList.size()>0)
		{
			mv = new ModelAndView("login_successful", "logged_in_user", custList);
			isLoggedIn = true;
			shoppingCart.setLoggedInUser(custList.get(0));
					
		}
		

		return mv;
	}
	
	@RequestMapping("/logout")
	public String logoutProcess()
	{
		isLoggedIn = false;
		shoppingCart.setLoggedInUser(null);
		
		return "logout_successful";
	}
	
	@RequestMapping("/login_successful")
	public ModelAndView loginSuccessful()
	{
		
		
		ModelAndView mv = null;
		
		return mv;
	}
}
