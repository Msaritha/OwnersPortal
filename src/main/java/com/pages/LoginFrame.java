package com.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.testbase.TestBase;
import com.utilities.TestUtil;

public class LoginFrame extends TestBase {
	
	WebDriverWait wait=new WebDriverWait(driver,30);
	
	@FindBy(id="Email")
	WebElement emailId;
	
	@FindBy(id="Password")
	WebElement password;
	
	@FindBy(css=".ui-button.mod-formSubmit")
	WebElement loginButton;
	
	@FindBy(linkText="Cancel")
	WebElement cancelButton;
	
	@FindBy(id="RememberMe")
	WebElement rememberMeCheckbox;
	
	TestUtil testutil=new TestUtil();
	
	public LoginFrame() {
		PageFactory.initElements(driver, this);
	}
	
	public LoginPage login(String emailId,String password) {
		this.emailId.sendKeys(emailId);
		this.password.sendKeys(password);
		loginButton.click();
		testutil.implicitWait(70);
		return new LoginPage();
	}

}
