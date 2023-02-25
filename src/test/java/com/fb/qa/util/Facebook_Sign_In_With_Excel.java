package com.fb.qa.util;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.fb.qa.base.Excel_Data_Config;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Facebook_Sign_In_With_Excel {
	
	WebDriver driver;
	Logger Log = Logger.getLogger(Facebook_Sign_In_With_Excel.class);

	@Test(dataProvider="SignInData")
	public void sign_In_Using_Excel(String username, String password) throws InterruptedException {
		Log.info("Starting the Execution");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.facebook.com/login/");	
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.id("email")).sendKeys(username);
		driver.findElement(By.name("pass")).sendKeys(password);
		driver.findElement(By.name("login")).click();
		Thread.sleep(2000);
		String expectedTitle = "Facebook";
		String actualTitle = driver.getTitle();
		System.out.println("The Actual Title is :" + actualTitle);
		if(actualTitle.equals(expectedTitle))
		{
			System.out.println("Page title is verified - User is able to sign in successfully");
		}
		else
		{
			System.out.println("User is not able to Sign In - Invalid Credential");
		}
		Thread.sleep(50);
		driver.quit();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	@DataProvider(name="SignInData")
	public Object [][] passData(){
		
		Excel_Data_Config config =new Excel_Data_Config("C:\\Users\\Admin\\eclipse-workspace\\Data_Driven_Framework_Test\\TestData\\UserData.xlsx");
		int rows = config.getRowCount(0);
		
		Object[][] data = new Object[rows][2];
		
		for (int i=0; i<rows; i++)
		{
			data[i][0] = config.getData(0, i, 0);
			data[i][1] = config.getData(0, i, 1);
		}
		return data;
	}
}
