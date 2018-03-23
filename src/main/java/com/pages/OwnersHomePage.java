package com.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.testbase.TestBase;
import com.utilities.TestUtil;


public class OwnersHomePage extends TestBase{
	
@FindBy(xpath="//*[@id=\"myhyundainewlogo\"]/a/img")
WebElement globalLogo;

@FindBy(linkText="MPG Reimbursement")
WebElement MPGReimbursementLink;

@FindBy(id="registrationLinkId")
WebElement registerLink;

@FindBy(linkText="Log In")
WebElement login;

@FindBy(linkText="Go to Hyundai.com")
WebElement GotoHyundaiLink;

@FindBy(linkText="Overview")
WebElement OverviewLink;

@FindBy(linkText="Blue Link Access")
WebElement Bluelink;

@FindBy(xpath="//*[@id='footerLogo']/a/img")
WebElement footerLogo;

@FindBy(id="hyundaiSearch")
WebElement searchField;

@FindBy(xpath="//iframe[@class='myhyundai-lbIframe']")
WebElement iFrame;


TestUtil testutil =new TestUtil();


public OwnersHomePage() {
	PageFactory.initElements(driver, this);;
}

public boolean verifyGlobalLogo() {
	testutil.implicitWait(20);
	return globalLogo.isDisplayed();
}

public String verifyTitle() {
	return driver.getTitle();
}

public boolean verifyFooterLogo() {
	return footerLogo.isDisplayed();
}

public boolean verifySearchField() {
	return searchField.isDisplayed();
}

public LoginFrame navigateToLoginFrame() {
	login.click();
	testutil.switchToLoginFrame();
	return new LoginFrame();
}
}
