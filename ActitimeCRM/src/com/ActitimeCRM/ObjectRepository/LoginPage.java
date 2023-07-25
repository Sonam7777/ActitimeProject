package com.ActitimeCRM.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	       //declaration
			@FindBy(id = "username")
			private  WebElement usernamefield;
			
			@FindBy(name = "pwd")
			private WebElement passwordfield;
			
			@FindBy(id="keepLoggedInCheckBox")
			private WebElement selectcheckbox;
			
			@FindBy(xpath = "//div[.='Login ']")
			private WebElement loginbutton;
			
			
			//initialization
			public LoginPage(WebDriver driver) {
				PageFactory.initElements(driver,this);
			}

			//utilization
			public WebElement getUsernamefield() {
				return usernamefield;
			}


			public WebElement getPasswordfield() {
				return passwordfield;
			}


			public WebElement getSelectcheckbox() {
				return selectcheckbox;
			}


			public WebElement getLoginbutton() {
				return loginbutton;
			}
	
	
	
	
	
	

}
