package com.testCases;



import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import com.pages.*;
import com.testbase.TestBase;
import com.utilities.TestUtil;

public class LoginFrameTest extends TestBase{
	

	OwnersHomePage ownersHomePage;
	LoginFrame loginFrame;
	TestUtil testutil=new TestUtil();;
	LoginPage loginpage;
	
	public LoginFrameTest() {
		super();
	}
	
	@BeforeMethod
	@Parameters("browser")
	public void setUp(String browserName) throws InterruptedException {
		Intialization(browserName);
		ownersHomePage=new OwnersHomePage();
		loginFrame= ownersHomePage.navigateToLoginFrame();
		System.out.println("Still in OwnersPage");
		Thread.sleep(5000);
		System.out.println("In LoginFrame");
	}
	
	@DataProvider(name="userIdPasswordProvider")
	public Iterator<Object[]> getTestData() throws IOException {
		
		ArrayList<Object[]> userIdPassword = testutil.readConfigFile("C:\\Users\\sarit\\eclipse-workspace\\BrowserAutomation\\"
				+ "src\\main\\java\\com\\testdata\\testDataForLogin.properties");
		return userIdPassword.iterator();
	}
	
	@Test(priority=1,dataProvider="userIdPasswordProvider")
	public void loginTest(String userName,String passWord) {
		
		LoginPage loginPage=loginFrame.login(userName,passWord);
		testutil.switchToDefaultContent();
		Assert.assertEquals(loginPage.verfiyUserLogin(), "Welcome,");		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
