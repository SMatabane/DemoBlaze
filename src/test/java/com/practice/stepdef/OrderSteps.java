package com.practice.stepdef;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;

import com.practice.base.BaseClass;
import com.practice.pages.AddCart;
import com.practice.pages.LoginPage;
import com.practice.pages.OrderPage;
import com.practice.utilities.Logs4j;
import com.practice.utilities.PropertyFiles;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;



public class OrderSteps extends BaseClass{
	
	private PropertyFiles pt;
	private LoginPage logpage;
	private AddCart cart;
	private OrderPage order;
	
	@Before
	public void setDriver() throws IOException, InterruptedException {
		
		   initializedriver();
		   logpage=new LoginPage();
		   pt=new PropertyFiles("src\\main\\resources\\config.properties");
		   cart=new AddCart();
		   order=new OrderPage();
		
	}
	
	@Given("open the url and click on login link")
	public void open_the_url_and_click_on_login_link() {
		logpage.navigateLogin();
		Logs4j.info("Navigated to login page");
	}
	@When("login to the application with valid")
	public void ValidLogin() throws InterruptedException {
		logpage.login(pt.readfromProperties("validusername"), pt.readfromProperties("validpassword"));
		Logs4j.info("Logging in .......");

		assertTrue(logpage.isShown(), "Username is displayed");
		
	}
	@And("select Samsung galaxy S6 and adding to cart")
	public void select_samsung_galaxy_s6() {
		cart.Addtocart();
		Logs4j.info("Item Added to cat .......");
		String expectedMessage=pt.readfromProperties("expectedmessage"); 
		String actualmessage=cart.getAlert();
		assertEquals(actualmessage,  expectedMessage,"Alert messages dont match");
	}
	@Then("go to cart  and check if product is present")
	public void IsItemPresent() {
		assertTrue(cart.validateItem(), "The Item is added to cart and price is displayed");
		Logs4j.info("Assert Item available .......");
	}
	@And("go order then enter details")
	public void purchaseItem() {
		order.enterDetails(pt.readfromProperties("name"), pt.readfromProperties("country"), pt.readfromProperties("city"), pt.readfromProperties("card"), pt.readfromProperties("month"), pt.readfromProperties("year"));
		order.purchase();
		Logs4j.info("Enter details .......");
		assertTrue(order.isShown());
	}
	@And("print the purchase id")
	public void print_the_purchase_id() {
		order.printID();
		
		
	}
	
	@After
	public void closeDriver() {
		getDriver().quit();
	}

}
