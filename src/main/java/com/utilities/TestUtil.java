package com.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.testbase.TestBase;



public class TestUtil extends TestBase{
	
	static Properties prop;

	public static void takeScreenshotAtEndOfTest() throws IOException {
		File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String currentDir=System.getProperty("user.dir");
		
		long currenttimeMS=System.currentTimeMillis();
		SimpleDateFormat sdf=new SimpleDateFormat("MMddyyyyHHmmss");
		Date resultDate=new Date(currenttimeMS);
		
		FileUtils.copyFile(srcFile,new File( currentDir+"/Screenshoots/"+sdf.format(resultDate)+".png"));
			
	}

	public  ArrayList<Object[]> readConfigFile(String location) throws IOException {
		prop=new Properties();
		ArrayList<Object[]> loginData=new ArrayList<Object[]>();
		FileInputStream fip=new FileInputStream(location);
		prop.load(fip);
		String uName=prop.getProperty("user1");
		String password=prop.getProperty("password1");
		loginData.add(new Object[] {uName,password});
		System.out.println("****************************************************************************");
		System.out.println(loginData);
		System.out.println("****************************************************************************");
		return loginData;
		
		}

	public void switchToLoginFrame() {
		// TODO Auto-generated method stub
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='myhyundai-lbIframe']")));
		
	}
	
	public void implicitWait() {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	public void switchToDefaultContent() {
		driver.switchTo().defaultContent();
		
	}
	
	public void implicitWait(int timeUnit) {
		driver.manage().timeouts().implicitlyWait(timeUnit, TimeUnit.SECONDS);
	}
}
