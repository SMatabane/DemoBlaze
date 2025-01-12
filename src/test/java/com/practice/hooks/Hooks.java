package com.practice.hooks;


import java.io.IOException;

import org.picocontainer.annotations.Inject;

import com.practice.base.BaseClass;
import com.practice.pages.AddCart;
import com.practice.pages.LoginPage;
import com.practice.pages.OrderPage;
import com.practice.services.OrderService;
import com.practice.utilities.PropertyFiles;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks extends BaseClass{
	
	public  PropertyFiles pt;
	public  LoginPage logpage;
	public  AddCart cart;
	public  OrderPage order;
	
	 
	    public Hooks(LoginPage loginPage, AddCart cartPage, PropertyFiles configReader,OrderPage page) {
	        logpage = loginPage;
	        cart = cartPage;
	        pt = configReader;
			order = page;
	    }
	
	@Before
	public void setDriver() throws IOException, InterruptedException {
		
		   initializedriver();
		   logpage=new LoginPage();
		   pt=new PropertyFiles();
		   cart=new AddCart();
		   order=new OrderPage();
		
	}
	
	
	
	//get Loginpage
	public LoginPage getLoginPage() {
		return logpage;
	}
	
	//get AddCart
		public AddCart getAddCartPage() {
			return cart;
		}
		
		//get orderpage
				public OrderPage getorderPage() {
					return order;
				}
				
				
		//get properties
		public PropertyFiles getPropertyFiles() {
			return pt;
		}
	
	@After
	public void closeDriver() {
		getDriver().quit();
	}
	
	

}
