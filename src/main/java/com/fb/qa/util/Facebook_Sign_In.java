package com.fb.qa.util;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Facebook_Sign_In {
	
	WebDriver driver;

	@Test(dataProvider="SignInData")
	public void sign_In(String username, String password) {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.facebook.com/login/");	
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.id("email")).sendKeys(username);
		driver.findElement(By.name("pass")).sendKeys(password);
		driver.findElement(By.name("login")).click();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		Assert.assertTrue(driver.getTitle().contains(""));
		driver.quit();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	@DataProvider(name="SignInData")
	public Object [][] passData(){
		Object[][] data = new Object[3][2];
		data[0][0]="Pramod";
		data[0][1]="Shendage";
		data[1][0]="Pramod1";
		data[1][1]="advf";	
		data[2][0]="Pramod2";
		data[2][1]="errt";
		return data;
	}
}
