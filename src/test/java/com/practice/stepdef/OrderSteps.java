package com.practice.stepdef;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import com.practice.hooks.Hooks;
import com.practice.utilities.Logs4j;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;



public class OrderSteps {

	
	private final Hooks h;
	
	public OrderSteps(Hooks h) {
		this.h = h;
	}
	
	
	@Given("open the url and click on login link")
	public void open_the_url_and_click_on_login_link() {
		h.logpage.navigateLogin();
		Logs4j.info("Navigated to login page");
	}
	@When("login to the application with valid")
	public void ValidLogin() throws InterruptedException {
		h.logpage.login(h.pt.readfromProperties("validusername"), h.pt.readfromProperties("validpassword"));
		Logs4j.info("Logging in .......");

		assertTrue(h.logpage.isShown(), "Username is displayed");
		
	}
	@And("select Samsung galaxy S6 and adding to cart")
	public void select_samsung_galaxy_s6() {
		h.cart.Addtocart();
		Logs4j.info("Item Added to cat .......");
		String expectedMessage=h.pt.readfromProperties("expectedmessage"); 
		String actualmessage=h.cart.getAlert();
		assertEquals(actualmessage,  expectedMessage,"Alert messages dont match");
	}
	@Then("go to cart  and check if product is present")
	public void IsItemPresent() {
		assertTrue(h.cart.validateItem(), "The Item is added to cart and price is displayed");
		Logs4j.info("Assert Item available .......");
	}
	@And("go order then enter details")
	public void purchaseItem() {
		h.order.enterDetails(h.pt.readfromProperties("name"),h.pt.readfromProperties("country"),h.pt.readfromProperties("city"),h.pt.readfromProperties("card"),h.pt.readfromProperties("month"),h.pt.readfromProperties("year"));
		h.order.purchase();
		//h.order.e(h.pt.readfromProperties("name"),h.pt.readfromProperties("country"),h.pt.readfromProperties("city"),h.pt.readfromProperties("card"),h.pt.readfromProperties("month"),h.pt.readfromProperties("year"));
		Logs4j.info("Enter details .......");
		assertTrue(h.order.isShown());
	}
	@And("print the purchase id")
	public void print_the_purchase_id() {
		h.order.printID();
		
		
	}
	
  @Then("place order assert alert is shown")
  public void PlaceOrderEmptyfields() {
	  h.order.clickOrder();
	  String expectedMessage=h.pt.readfromProperties("expectedmessage1"); 
		String actualmessage=h.order.getAlert();
		assertEquals(actualmessage,  expectedMessage,"Alert messages dont match");
  }
	
	

}
