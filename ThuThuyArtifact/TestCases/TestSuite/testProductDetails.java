package TestSuite;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Automation.HomePage;
import Common.Utilities;
import Constants.Constant;

public class testProductDetails {
	@BeforeMethod
	public void beforeMethod() {
		System.setProperty("webdriver.chrome.driver", Utilities.getProjectPath() + "\\Executables\\chromedriver.exe");
		Constant.WEBDRIVER = new ChromeDriver();
		Constant.WEBDRIVER.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Constant.WEBDRIVER.manage().window().maximize();
	}
	
	@Test()
	public void TC08() {
		System.out.println("TC08 - Select Product Details");
		HomePage homePage = new HomePage();
		String productLabel = homePage.open().selectProduct("Faded Short Sleeve T-shirts").getProductHeader();
		assertEquals(productLabel, "Faded Short Sleeve T-shirts");
	}

	@AfterMethod
	public void afterMethod() {
		Constant.WEBDRIVER.quit();
	}
}
