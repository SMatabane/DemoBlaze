package com.practice.base;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.practice.utilities.Logs4j;
import com.practice.utilities.PropertyFiles;

import io.github.bonigarcia.wdm.WebDriverManager;




public class BaseClass {
	
	public static ThreadLocal<RemoteWebDriver> d = new ThreadLocal<>();
	private static PropertyFiles pt;
	
	public static WebDriver getDriver() {
		
		return d.get();
	}
	
	public void initializedriver() throws IOException {
		pt=new PropertyFiles();
		
		String browser=pt.readfromProperties("browser");
		
		switch(browser.toLowerCase()) {
		  
		case "chrome":
			WebDriverManager.chromedriver().setup();
			ChromeOptions cotp=new ChromeOptions();
			cotp.addArguments("--headless");
			d.set(new ChromeDriver());
			break;
			
		case "fireFox":
			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions fop=new FirefoxOptions();
			fop.addArguments("--headless");
			d.set(new FirefoxDriver(fop));
			break;
			
			
		case "edge":
			WebDriverManager.edgedriver().setup();
			EdgeOptions eop=new EdgeOptions();
			eop.addArguments("--headless");
			d.set(new EdgeDriver(eop));
			break;
			
		default:
			Logs4j.error("Invalid browser type" + browser);
		
		
		}
		
		getDriver().get(pt.readfromProperties("url"));
		getDriver().manage().window().maximize();
		getDriver().manage().deleteAllCookies();
		getDriver().manage().timeouts().implicitlyWait(Integer.parseInt(pt.readfromProperties("implicitWait")),TimeUnit.SECONDS);
	}
	

}
