package com.utilities;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.interactions.*;
import org.openqa.selenium.support.ui.*;

import com.testbase.TestBase;

public class PageMethods extends TestBase {
	
	
	public class PageActions {
		
		public Actions action;
	
		public void doubleClick(WebElement e) {
			action.doubleClick(e).perform();
		}
	
		public void rightClick(WebElement e) {
			action.contextClick(e).perform();;
		}
	
		public void rightClick( ) {
			action.click().perform();
		}
		public void mouseOverAndClick(WebElement e1,WebElement e2) {
			action.moveToElement(e1).click(e2).build().perform();
		}
		
		public void mouseOverAndClick(WebElement e1,WebElement e2,WebElement e3) {
			action.moveToElement(e1).moveToElement(e2).click().build().perform();
		}
		
		public void dragAndDrop(WebElement source,WebElement target) {
			action.dragAndDrop(source, target);
		}
	
	}
	
	public class PageAlertMethods {
		
		public Alert alert = driver.switchTo().alert();
	
		public void accpetAlert() {
			alert.accept();
		}
		public void dismissAlert() {
			alert.dismiss();
		}
		public String getAlertText() {
			return alert.getText();
		}
	
		public void enterTextInAlert(String text) {
			alert.sendKeys(text);
		}
	
	}
	
	public class PageSelectDropDown {
		Select select;
		
		public void selectByIndex(WebElement e, int index) {
			select = new Select(e);
			select.selectByIndex(index);
		}
		
		public void selectByValue(WebElement e, String value) {
			select=new Select(e);
			select.selectByValue(value);
		}
		
		public void selectByVisibletext(WebElement e,String text) {
			select =new Select(e);
			select.selectByVisibleText(text);
		}
	}
	
	public class PageCalender {
		
		public void selectDate(List<WebElement> list,String date) {
		
			for(WebElement web:list) {
				if((web.getText()).equalsIgnoreCase(date)) {
					web.click();
					break;
				}
			}
		}
	}
	
	
}
