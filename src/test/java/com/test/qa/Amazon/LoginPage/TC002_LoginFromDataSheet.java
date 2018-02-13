package com.test.qa.Amazon.LoginPage;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.test.qa.Amazon.testBase.TestBase;
import com.test.qa.Amazon.uiActions.LoginPage;

public class TC002_LoginFromDataSheet extends TestBase {
	
	public static final Logger log= Logger.getLogger(TC002_LoginFromDataSheet.class.getName());
	
	LoginPage loginPage;
	
	@DataProvider(name="loginData")
	public String[][] getTestData() {
		String[][] testRecords = getData("TestData.xlsx","Login");
		return testRecords;
	}
	@BeforeTest
	public void setUp() {
		log.info("initialzing all the variable and methods");
		init();
		
	}
	@Test(dataProvider="loginData")
	public void verifyLogin(String UserName, String Password12, String runMode) throws InterruptedException, IOException  {
		if(runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		log.info("________________Started execution verifyLogin__________");
		loginPage = new LoginPage(driver);
		loginPage.loginInApplication(UserName, Password12);
		getScreenShot("verifyLogin"+UserName);
		loginPage.logout();
		log.info("________________Completed execution verifyLogin__________");
	}

	@AfterClass
	public void endTest() {
		driver.quit();
	}
	
}
