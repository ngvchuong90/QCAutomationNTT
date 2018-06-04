package TestSuite;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Automation.HomePage;
import Common.Utilities;
import Constants.Constant;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;

public class testLogin {
		
	@BeforeMethod
	public void beforeMethod() {
		System.setProperty("webdriver.chrome.driver", Utilities.getProjectPath() + "\\Executables\\chromedriver.exe");
		Constant.WEBDRIVER = new ChromeDriver();
		Constant.WEBDRIVER.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Constant.WEBDRIVER.manage().window().maximize();
	}

	@Test(dataProvider = "authenticationLogin", dataProviderClass=AllData.loginData.class)
	public void TC01(String userName, String passWord) throws InterruptedException {
		System.out.println("TC01 - User can log into with valid username and password");
		HomePage homePage = new HomePage();
		String welcome = homePage.open().goToLoginPage().loginSuccessfull(userName, passWord).getkWelcomeMessage();
		assertEquals(welcome, "Welcome to your account. Here you can manage all of your personal information and orders.");
	}
	
	@Test(dataProvider = "authenticationLogin", dataProviderClass=AllData.loginData.class)
	public void TC02(String userName, String passWord, String errorMess) throws InterruptedException {
		System.out.println("TC02 - User can't log into with invalid username and password");
		HomePage homePage = new HomePage();
		String errorM = homePage.open().goToLoginPage().loginUnsuccessfull(userName, passWord).getErrorMessage();
		assertEquals(errorM, errorMess);
	}
	
	@AfterMethod
	public void afterMethod() {
		Constant.WEBDRIVER.quit();
	}
}
