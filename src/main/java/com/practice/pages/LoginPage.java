package com.practice.pages;


import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.practice.base.BaseClass;

public class LoginPage extends BaseClass{
	
	//elements
	@FindBy(id="login2") //login button
	private WebElement btnlogin;
	
	@FindBy(id="loginusername")
	private WebElement  input_username;
	
	@FindBy(id="loginpassword")
	private WebElement  input_password;
	
	@FindBy(xpath="//button[normalize-space()='Log in']") //login button
	private WebElement btnsubmit;
	
	@FindBy(id="nameofuser")
	private WebElement usertext;
	
	 public LoginPage()  {
			
			PageFactory.initElements( getDriver(),this);
			// TODO Auto-generated constructor stub
		}
	
	/**
	 * navigating to login page
	 */
	public void navigateLogin() {
		
		btnlogin.click();
		
	}
	/**
	 * @param username & password
	 * method for adding username and password on input fields
	 */
	public void login(String username,String password) {
		input_username.sendKeys(username);
		input_password.sendKeys(password);
		btnsubmit.click();
	}
    
	
	
	public boolean isShown() {
		WebDriverWait wait=new WebDriverWait(getDriver(),Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(usertext));
		return usertext.isDisplayed();
	}
	
	

}
