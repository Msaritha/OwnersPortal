package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.testbase.TestBase;

public class LoginPage extends TestBase{

	@FindBy(xpath="//*[@id=\"main\"]/div/div[2]/div[1]/div/div[2]/div[1]/h2/strong")
	WebElement welcomeText;
	
	@FindBy(xpath="//div[@id='myhyundainewlogo']/a/img")
	WebElement loginLogo;
	
	
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String verfiyUserLogin() {
		System.out.println(welcomeText.getText());
		return welcomeText.getText();
		
	}
	
	public boolean verifyLogo() {
		
		return loginLogo.isDisplayed();
	}
}
