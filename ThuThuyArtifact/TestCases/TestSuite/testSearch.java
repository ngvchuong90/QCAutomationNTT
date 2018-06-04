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

public class testSearch {
		
	@BeforeMethod
	public void beforeMethod() {
		System.setProperty("webdriver.chrome.driver", Utilities.getProjectPath() + "\\Executables\\chromedriver.exe");
		Constant.WEBDRIVER = new ChromeDriver();
		Constant.WEBDRIVER.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Constant.WEBDRIVER.manage().window().maximize();
	}
	
	@Test()
	public void TC06() {
		System.out.println("TC06 - Search value susscessfull");
	}
	
	@Test(dataProvider = "authenticationLogin", dataProviderClass=AllData.loginData.class)
	public void TC07(String keyWork, String errorM) {
		System.out.println("TC07 - Search invalid value");
		HomePage homePage = new HomePage();
		String errorMess = homePage.open().searchValue(keyWork).getErrorMessage();
		boolean check = errorMess.contains(errorM);
		assertEquals(check, true);
	}

	@AfterMethod
	public void afterMethod() {
		Constant.WEBDRIVER.quit();
	}
}
