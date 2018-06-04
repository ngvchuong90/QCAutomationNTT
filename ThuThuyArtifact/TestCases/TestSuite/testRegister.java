package TestSuite;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Automation.HomePage;
import Automation.LoginPage;
import Automation.generalActions;
import Common.Utilities;
import Constants.Constant;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;

public class testRegister {
		
	@BeforeMethod
	public void beforeMethod() {
		System.setProperty("webdriver.chrome.driver", Utilities.getProjectPath() + "\\Executables\\chromedriver.exe");
		Constant.WEBDRIVER = new ChromeDriver();
		Constant.WEBDRIVER.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Constant.WEBDRIVER.manage().window().maximize();
	}

	@Test(dataProvider = "authenticationLogin", dataProviderClass=LoginData.loginData.class)
	public void TC03(String firstName, String lastName, String passWord, String address, String city, String state, String postCode, String country, String mobiPhone, String allias) throws InterruptedException {
		System.out.println("TC03 - Customer can register successfull");
		String emailRandom = new generalActions().generateRandomEmail();
		HomePage homePage = new HomePage();
		LoginPage loginPage = homePage.open().goToLoginPage();
		loginPage.createEmailAccountAuthenticationSuccessfull(emailRandom);
		String welcome = loginPage.submitCreateAccountSuccessfull(firstName, lastName, passWord, address, city, state, postCode, country, mobiPhone, allias).getkWelcomeMessage();
		assertEquals(welcome, "Welcome to your account. Here you can manage all of your personal information and orders.");
	}
	
	@Test(dataProvider = "authenticationLogin", dataProviderClass=LoginData.loginData.class)
	public void TC04() {
		System.out.println("TC04 - Register Unsuccessfull with email invalid");
		
	}
	
	@Test()
	public void TC05() {
		System.out.println("TC05 - Register Unsuccessfull with email invalid");
	}

	@AfterMethod
	public void afterMethod() {
		Constant.WEBDRIVER.quit();
	}
}
