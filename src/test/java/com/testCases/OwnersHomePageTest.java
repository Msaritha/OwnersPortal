package com.testCases;


	import org.testng.Assert;
import org.testng.annotations.*;

import com.pages.OwnersHomePage;
	import com.testbase.TestBase;
	import com.utilities.TestUtil;

	public class OwnersHomePageTest extends TestBase{
		
		OwnersHomePage ownersHomePage;
		TestUtil testUtil;
		
			public OwnersHomePageTest() {
				super();
		}
		
			@BeforeMethod
			@Parameters("browser")
			public void setUp(String browserName) {
				Intialization(browserName);
				testUtil=new TestUtil();
				ownersHomePage=new OwnersHomePage();
			}
			
			@Test(priority=1)
			public void globalLogoTest() {
				Assert.assertTrue(ownersHomePage.verifyGlobalLogo());
			}
			
			@Test(priority=2)
			public void globalFooterTest() {
				Assert.assertTrue(ownersHomePage.verifyFooterLogo());
			}
			
			@Test(priority=3) 
			public void titleTest() {
				Assert.assertEquals(ownersHomePage.verifyTitle(), "Owners Home");
			}
			
			@Test(priority=4)
			public void searchboxPresentTest() {
				Assert.assertTrue(ownersHomePage.verifySearchField());
			}
			
			
		
			@AfterMethod
			public void tearDown() {
				
				driver.quit();
			}

	}


