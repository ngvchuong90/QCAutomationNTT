package TestSuite;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class configMulti {
	private static final String WEBDRIVER = "driver";
	
    @BeforeMethod
    public void instantiateBrowser(ITestResult testResult) {
        RemoteWebDriver driver = new ChromeDriver();
        testResult.setAttribute(WEBDRIVER, driver);
    }
	
    @AfterMethod
    public void cleanupBrowser(ITestResult testResult) {
        RemoteWebDriver driver = driver(testResult);
        driver.quit();
    }

    public RemoteWebDriver driver() {
        return driver(Reporter.getCurrentTestResult());
    }

    private RemoteWebDriver driver(ITestResult testResult) {
        if (testResult == null) {
            throw new IllegalStateException("testResult should have not been null.");
        }
        Object driverObject = testResult.getAttribute(WEBDRIVER);
        if (driverObject == null) {
            throw new IllegalStateException("Driver should have not been null.");
        }
        if (!(driverObject instanceof RemoteWebDriver)) {
            throw new IllegalStateException("Driver is not a valid webdriver object");
        }
        return (RemoteWebDriver) driverObject;
    }
}
