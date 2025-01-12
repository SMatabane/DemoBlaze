package com.practice.services;

import com.practice.pages.OrderPage;

public class OrderService {
	
	private OrderPage page;
	
	//order with details
	public void Details(String nam,String countr,String cit,String car,String mon,String y) {
		//page.clickOrder();
		page.enterDetails(nam, countr, cit, car, mon, y);
		page.purchase();
		
	}
	
	//order without details
	public void NoDetails() {
		page.clickOrder();
		page.purchase();
	}
	
	//alert
	public String AlertIsShown() {
		return page.getAlert();
	}
	
	//id is desplayed
	public boolean IDShown() {
		return page.isShown();
	}
	
	public void getID() {
		page.printID();
	}

}
