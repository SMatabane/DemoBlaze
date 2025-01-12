package com.practice.pages;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.practice.base.BaseClass;

public class OrderPage extends BaseClass{
	
	//elements
		@FindBy(id="name") 
		private WebElement name;
		
		@FindBy(id="country")
		private WebElement country;
		
		@FindBy(id="city")
		private WebElement  city;
		
		@FindBy(id="card") 
		private WebElement card;
		
		@FindBy(id="month")
		private WebElement month;
		
		@FindBy(id="year")
		private WebElement  year;
		
		@FindBy(xpath="//button[normalize-space()=\"Purchase\"]") 
		private WebElement purchase;
		
		@FindBy(xpath="//p[@class='lead text-muted ']")
		private WebElement id;
		
		@FindBy(xpath="//button[normalize-space()=\"Place Order\"]")
		private WebElement btnOrder;
		
		 public OrderPage()  {
				
				PageFactory.initElements( getDriver(),this);
				// TODO Auto-generated constructor stub
			}
		 
		 
		 public void clickOrder() {
			 btnOrder.click();
			 purchase();
		 }
		
		 /**
		* enter details for placing an order
		*/
		 public void enterDetails(String nam,String countr,String cit,String car,String mon,String y) {
			 btnOrder.click();
			 name.sendKeys(nam);
			 country.sendKeys(countr);
			 city.sendKeys(cit);
			 card.sendKeys(car);
			 month.sendKeys(mon);
			 year.sendKeys(y);
			 
		 }
		 
		 public void purchase() {
			 Actions actions = new Actions(getDriver());
			 actions.scrollByAmount(0, 500).perform(); // Scroll down by 500 pixels

			 purchase.click();
		 }
		 
		 /**
		  	 *Get alert for empty fields
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
			  *Get id
			  */  
		     public void printID() {
		    	 String i=id.getText().substring(4, 11);
		    	 
		    	 System.out.println("purchase id is: " +i);
		     }
		     /**
			  *Validate id is shown
			  */ 
		     public boolean isShown() {
		    	 return id.isDisplayed();
		     }
		     
		     
//		     public String handleAlert() {
//		         WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
//		         wait.until(ExpectedConditions.alertIsPresent());
//
//		         Alert alert = getDriver().switchTo().alert();
//		         String alertText = alert.getText();
//		         alert.accept(); // Accept the alert
//		         return alertText;
//		     }
		 

}
