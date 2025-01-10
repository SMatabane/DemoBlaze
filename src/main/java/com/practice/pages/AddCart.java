package com.practice.pages;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.practice.base.BaseClass;
import com.practice.utilities.Logs4j;

public class AddCart extends BaseClass {
	
	//get element for phone
	@FindBy(xpath="//a[normalize-space()='Samsung galaxy s6']")
	private WebElement text;
	@FindBy(xpath="//a[normalize-space()='Add to cart']")
	private WebElement btncart;
	
	@FindBy(xpath="//a[normalize-space()='Cart']")
	private WebElement cart;
	
	@FindBy(id="totalp")
	private WebElement price;
	
	
	
	public AddCart()  {
		
		PageFactory.initElements( getDriver(),this);
		// TODO Auto-generated constructor stub
	}
	/**
	 * Addto cart method for clicking phone and add to cart
	 */
     public void Addtocart() {
    	 Logs4j.info("Click item .....");
    	 text.click();
    	 btncart.click();
    	 Logs4j.info("Add item to cart .......");
     }
     /**
  	 *Get alert after adding to cart
  	 */
     
     public String getAlert() {
    	 
    	 WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(5));
         wait.until(ExpectedConditions.alertIsPresent());
    	 
    	 Alert alert = getDriver().switchTo().alert(); // Switch to the alert
         String alertText = alert.getText();      // Get the alert text
         alert.accept();                          // Accept (click OK) the alert
         return alertText; 
    	 
     }
     /**
   	 * navigating to cart and validate if the item is available and total price is displayed
   	 */
     public boolean validateItem() {
    	 cart.click();
    	 WebDriverWait w=new WebDriverWait(getDriver(), Duration.ofSeconds(5));
    	 w.until(ExpectedConditions.visibilityOf(price));
    	 
    	 return price.isDisplayed();
     }
     
     
     
     
     
     
}
