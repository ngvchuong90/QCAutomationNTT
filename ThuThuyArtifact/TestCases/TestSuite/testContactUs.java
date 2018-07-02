package TestSuite;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Automation.HomePage;
import Common.Utilities;
import Constants.Constant;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class testContactUs {
	@BeforeMethod
	@Parameters("browser")
	public void beforeMethod(String br) {
		if (br.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					Utilities.getProjectPath() + "\\Executables\\chromedriver.exe");
			Constant.WEBDRIVER = new ChromeDriver();
		} else if (br.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.firefox.driver",
					Utilities.getProjectPath() + "\\Executables\\geckodriver.exe");
			Constant.WEBDRIVER = new FirefoxDriver();
		}
		Constant.WEBDRIVER.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Constant.WEBDRIVER.manage().window().maximize();
	}

	@Test(dataProvider = "contactUs", dataProviderClass = AllData.contactUsData.class)
	public void TC01(String no, String subject, String email, String OderRef, String txtMess, String successM) {
		System.out.println(
				"TC01 - Verify Message successful is displayed after sending message with valid information on Customer service page.");
		HomePage homePage = new HomePage();
		String successMess = homePage.open().goToContactUsPage().sendAMessageNotLogin(subject, email, OderRef, txtMess)
				.getSuccessMessage();
		assertEquals(successMess, successM);
	}

	// @Test(dataProvider = "contactUs", dataProviderClass =
	// AllData.contactUsData.class)
	// public void TC02(String no, String subject, String email, String OderRef,
	// String txtMess, String errorM) {
	// System.out.println(
	// "TC02 - Verify Error message is displayed after sending message with invalid
	// information on Customer service page.");
	// HomePage homePage = new HomePage();
	// String errorMess =
	// homePage.open().goToContactUsPage().sendAMessageNotLogin(subject, email,
	// OderRef, txtMess)
	// .getErrorMessage();
	// assertEquals(errorMess, errorM);
	// }
	//
	// @Test(dataProvider = "contactUs", dataProviderClass =
	// AllData.contactUsData.class)
	// public void TC03(String no, String userName, String passWord) {
	// System.out.println("TC03 - Verify email field is autofilled with user email
	// which has logged in.");
	// HomePage homePage = new HomePage();
	// String emailInpputed =
	// homePage.open().goToLoginPage().loginSuccessfull(userName,
	// passWord).goToContactUsPage()
	// .getEmailInputed();
	// assertEquals(userName, emailInpputed);
	// }

	@AfterMethod
	public void afterMethod(ITestResult testResult) throws IOException {
		if (testResult.getStatus() == ITestResult.FAILURE) {
			File scrFile = ((TakesScreenshot) Constant.WEBDRIVER).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File("errorScreenshots\\" + testResult.getName() + "-"
					+ Arrays.toString(testResult.getParameters()) + ".jpg"));
		}
		Constant.WEBDRIVER.quit();
	}
}
