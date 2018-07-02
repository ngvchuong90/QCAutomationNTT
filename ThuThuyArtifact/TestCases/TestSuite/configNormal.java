package TestSuite;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import Common.Utilities;
import Constants.Constant;

public class configNormal {
	@BeforeMethod
	public void beforeMethod() {
		System.setProperty("webdriver.chrome.driver", Utilities.getProjectPath() + "\\Executables\\chromedriver.exe");
		Constant.WEBDRIVER = new ChromeDriver();
		Constant.WEBDRIVER.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Constant.WEBDRIVER.manage().window().maximize();
	}

	@AfterMethod
	public void afterMethod(ITestResult testResult) throws IOException {
		String time = String.valueOf(System.currentTimeMillis());
		try {
			if (testResult.getStatus() == ITestResult.FAILURE) {
				File scrFile = new File("");
				scrFile = ((TakesScreenshot) Constant.WEBDRIVER).getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(scrFile, new File("errorScreenshots\\" + testResult.getName() + "-" + time
						+ Arrays.toString(testResult.getParameters()) + ".jpg"));
			}
		} catch (Exception e) {
			System.out.println("Error: " + e.getStackTrace());
		}
		Constant.WEBDRIVER.quit();
	}
}
