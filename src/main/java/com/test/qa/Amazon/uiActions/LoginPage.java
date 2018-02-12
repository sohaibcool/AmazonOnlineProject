package com.test.qa.Amazon.uiActions;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.test.qa.Amazon.LoginPage.TC001_VerifyLogin;

public class LoginPage {
	public static final Logger log= Logger.getLogger(LoginPage.class.getName());
	WebDriver driver;
	
	
	@FindBy(xpath="//span[contains(text(),'Hello. Sign in')]")
	WebElement signIn;
	
	@FindBy(xpath="//input[@type='email']")
	WebElement loginEmailAddress;
	
	@FindBy(xpath="//input[@name='password']")
	WebElement logInPassword;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement continueBtn;
	
	@FindBy(xpath="//input[@id='signInSubmit']")
	WebElement welcomePage;
	
	@FindBy(xpath="//a[@href='/gp/css/homepage.html/ref=nav_youraccount_btn']")
	WebElement welcomeLoginPage;
	
	@FindBy(xpath="//span[contains(text(),'Sign Out')]")
	WebElement signOutLink;
	
	public LoginPage(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	public void loginInApplication(String userName, String password12) throws InterruptedException {
		signIn.click();
		log.info("----------Clicked on SignIn-------------");
		loginEmailAddress.sendKeys(userName);
		log.info("----------Entered surename-------->"+userName);
		//continueBtn.click();
	//	driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		if(driver.findElements(By.xpath("//input[@id='continue']")).size()>0)
		{
			log.info("----------Password was not dispalyed-------->"+userName);
			continueBtn.click();
			log.info("----------clicked on Continue Button-------->"+continueBtn);
			logInPassword.sendKeys(password12);
			log.info("----------Entered the Password-------->"+password12);
			continueBtn.click();
		}else
		{
		logInPassword.sendKeys(password12);
		log.info("----------Entered the Password-------->"+password12);
		continueBtn.click();
		log.info("----------clicked on Continue Button-------->"+continueBtn);
		}
		Actions a = new Actions(driver);
		WebElement singInElement = welcomeLoginPage;
		log.info("----------SignIn element is present-------->"+singInElement);
		a.moveToElement(singInElement).build().perform();
		//driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		a.moveToElement(singInElement).click();
		Thread.sleep(5000L);
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		signOutLink.click();
		log.info("----------clicked on SignOut button-------->"+signOutLink);
		
	}
}
