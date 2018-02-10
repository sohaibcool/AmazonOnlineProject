package com.test.qa.Amazon.LoginPage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TC001_VerifyLogin {
	WebDriver driver;
	@BeforeTest
	public void setUp() {
		driver = new FirefoxDriver();
		driver.get("https://www.amazon.com/");
		driver.manage().window().maximize();
	}
	@Test
	public void verifyLogin() throws InterruptedException {
		driver.findElement(By.xpath("//span[contains(text(),'Hello. Sign in')]")).click();
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys("sohaibcool@gmail.com");
		if(driver.findElements(By.xpath("//input[@id='continue']")).size()>0)
		{
			driver.findElement(By.xpath("//input[@id='continue']")).click();
			driver.findElement(By.xpath("//input[@id='ap_password']")).sendKeys("Allah@123");
			driver.findElement(By.xpath("//input[@id='signInSubmit']")).click();
		}else
		{
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("Allah@123");
		driver.findElement(By.xpath("//input[@id='signInSubmit']")).click();
		}
		Actions a = new Actions(driver);
		WebElement singInElement = driver.findElement(By.xpath("//a[@href='/gp/css/homepage.html/ref=nav_youraccount_btn']"));
		a.moveToElement(singInElement).build().perform();
		Thread.sleep(5000L);
		a.moveToElement(singInElement).click();
		Thread.sleep(5000L);
		driver.findElement(By.xpath("//span[contains(text(),'Sign Out')]")).click();
	}
	@AfterClass
	public void endTest() {
		driver.close();
	}
	
}
