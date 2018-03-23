package com.testCases;
import org.testng.Assert;
import org.testng.annotations.*;

import com.pages.*;
import com.testbase.*;
public class LoginPageTest extends TestBase{
	
	LoginPage loginPage;
	OwnersHomePage ownersHomePage;
	
	public LoginPageTest() {
		super();
	}
	
	@BeforeMethod
	@Parameters("browser")
	public void setUp(String browserName) {
		Intialization(browserName);
		loginPage=new LoginPage();
		ownersHomePage = new OwnersHomePage();
	
	}
	
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
