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

public class testPageDisplay {
	@BeforeMethod
	public void beforeMethod() {
		System.setProperty("webdriver.chrome.driver", Utilities.getProjectPath() + "\\Executables\\chromedriver.exe");
		Constant.WEBDRIVER = new ChromeDriver();
		Constant.WEBDRIVER.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Constant.WEBDRIVER.manage().window().maximize();
	}

//	@Test()
//	public void TC01() throws InterruptedException {
//		System.out.println("TC01 - Verify Home page is displayed with correct URL");
//		new HomePage().open();
//		String url = Constant.WEBDRIVER.getCurrentUrl();
//		assertEquals(url, "http://automationpractice.com/index.php");
//	}
	
	@Test(dataProvider = "pageName", dataProviderClass=AllData.pageName.class)
	public void TC04(String goToPage, String namePage) throws InterruptedException {
		System.out.println("TC04 - Verify Categories page is correct after selecting category title");
		String catTitle = new HomePage().open().goToCategories(goToPage).getCategoriesTitleOpen();
		assertEquals(catTitle, namePage);
	}
	
	
	
	@AfterMethod
	public void afterMethod() {
		Constant.WEBDRIVER.quit();
	}
}
