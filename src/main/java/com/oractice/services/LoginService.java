package com.oractice.services;

import com.practice.pages.LoginPage;

public class LoginService {
	
	private LoginPage logpage;
	
	public void submit(String username,String password) {
		logpage.login(username,password);
		//logpage.submitBtn();
	}
	
	public void openLogin() {
		logpage.navigateLogin();
		
	}
	
	public boolean AssertText() {
		return logpage.isShown();
	}

}
