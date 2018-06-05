package Constants;

import org.openqa.selenium.WebDriver;

import Common.Utilities;

public class Constant {

	public static WebDriver WEBDRIVER;
	public static final String homePage_URL = "http://automationpractice.com";
	public static final String linkDataPath = Utilities.getProjectPath() + "\\DataObjects\\DataExcel\\data.xlsx";
}
