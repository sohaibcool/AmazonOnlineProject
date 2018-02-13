package com.test.qa.Amazon.LoginPage;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.test.qa.Amazon.testBase.TestBase;
import com.test.qa.Amazon.uiActions.LoginPage;

public class TC001_VerifyLogin extends TestBase {
	
	public static final Logger log= Logger.getLogger(TC001_VerifyLogin.class.getName());
	
	LoginPage loginPage;
	String email ="sohaibcool@gmail.com";
	String pws = "Allah@123";
	@BeforeTest
	public void setUp() {
		log.info("initialzing all the variable and methods");
		init();
		
	}
	@Test
	public void verifyLogin() throws InterruptedException {
		log.info("________________Started execution verifyLogin__________");
		loginPage = new LoginPage(driver);
		loginPage.loginInApplication(email, pws);
		loginPage.logout();
		log.info("________________Completed execution verifyLogin__________");
	}
	@AfterClass
	public void endTest() {
		driver.quit();
	}
	
}
//span[contains(text(),'Cell Phones & Accessories')]