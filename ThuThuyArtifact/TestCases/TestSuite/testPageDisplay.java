package TestSuite;

import static org.testng.Assert.assertEquals;
import org.testng.annotations.Test;

import Automation.HomePage;
import Constants.Constant;

public class testPageDisplay extends configGrid {
	
	@Test()
	public void TC01() throws InterruptedException {
		System.out.println("TC01 - Verify Home page is displayed with correct URL");
		new HomePage().open();
		String url = Constant.WEBDRIVER.getCurrentUrl();
		assertEquals(url, "http://automationpractice.com/index.php");
	}

	@Test(dataProvider = "catPageName", dataProviderClass = AllData.pageName.class)
	public void TC02(String noN, String testCase, String namePage) throws InterruptedException {
		System.out.println("TC" + noN +  " - " + testCase);
		String catTitle = new HomePage().open().goToCategories(namePage).getCategoriesTitleOpen();
		assertEquals(catTitle, namePage);
	}
}
