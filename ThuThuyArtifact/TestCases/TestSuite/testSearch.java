package TestSuite;

import org.testng.annotations.Test;

import Automation.HomePage;
import static org.testng.Assert.assertEquals;

public class testSearch extends configNormal {
	@Test(dataProvider = "searchData", dataProviderClass = AllData.searchData.class)
	public void TC01(String noN, String testCase, String keyWork) {
		System.out.println("TC" + noN + " - " + testCase);
		HomePage homePage = new HomePage();
		boolean check = homePage.open().searchValue(keyWork).getProductNameDyn(keyWork).isDisplayed();
		assertEquals(check, true);
	}

	@Test(dataProvider = "searchData", dataProviderClass = AllData.searchData.class)
	public void TC02(String noN, String testCase, String keyWork, String errorM) {
		System.out.println("TC" + noN + " - " + testCase);
		HomePage homePage = new HomePage();
		String errorMess = homePage.open().searchValue(keyWork).getErrorMessage();
		boolean check = errorMess.contains(errorM);
		assertEquals(check, true);
	}

}
