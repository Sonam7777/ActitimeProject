package com.ActitimeCRM.GenericLibrary;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.ActitimeCRM.ObjectRepository.HomePage;
import com.ActitimeCRM.ObjectRepository.LoginPage;

public class Baseclass {
	
public WebDriver driver;
public  FileLibrary f;
	
	@BeforeSuite 
	public void databaseConnection() {
		Reporter.log("Database connected",true);
	}
	@BeforeTest
	public void launchBrowser() throws IOException {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		f = new FileLibrary();
		String URL = f.readDataFromPropertyFile("url");
		driver.get(URL);
		 
		 Reporter.log("Browser is launched sucessfully",true );
     }
	@BeforeMethod
	public void login() throws IOException {
		
		LoginPage lp = new LoginPage(driver);
		
		String un = f.readDataFromPropertyFile("username");
	    lp.getUsernamefield().sendKeys(un);
	    
	    String pw= f.readDataFromPropertyFile("password");
	    lp.getPasswordfield().sendKeys(pw);
	    
	    lp.getSelectcheckbox().click();
	    lp.getLoginbutton().click();    
		Reporter.log("Logged in sucessfully",true);
	}
	
	@AfterMethod
	public void logout() {
		
		HomePage hp = new HomePage(driver);
		hp.getLogoutlink();
		Reporter.log("Logout sucessfully",true);
		
	}
	
	@AfterTest
	public void closeBrowser() {
		driver.close();
		Reporter.log("Browser closed sucessfully",true);
	}
	@AfterSuite
	public void databaseDisconnect() {
		Reporter.log("database disconnected",true);
		
	}
	
}
