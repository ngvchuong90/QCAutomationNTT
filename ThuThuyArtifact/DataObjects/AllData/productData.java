package AllData;

import java.io.IOException;
import java.lang.reflect.Method;

import org.testng.annotations.DataProvider;

import Automation.generalActions;
import Common.Utilities;

public class productData extends generalActions{
	String path = Utilities.getProjectPath() + "\\DataObjects\\DataExcel\\data.xlsx";
	
	@DataProvider(name = "productData")
	public Object[][] getData(Method name) throws IOException {
		if (name.getName().equalsIgnoreCase("TC01")) {
			Object[][] obj = new generalActions().getDataFromFile(path, "productData");
			return obj;
		} else if (name.getName().equalsIgnoreCase("TC02")) {
			Object[][] obj = new generalActions().getDataFromFile(path, "sendToFriendSuccessful");
			return obj;
		} else if (name.getName().equalsIgnoreCase("TC03")) {
			Object[][] obj = new generalActions().getDataFromFile(path, "sendToFriendUnsuccessful");
			return obj;
		} else if (name.getName().equalsIgnoreCase("TC04")) {
			Object[][] obj = new generalActions().getDataFromFile(path, "reviewSuccessful");
			return obj;
		} else if (name.getName().equalsIgnoreCase("TC05")) {
			Object[][] obj = new generalActions().getDataFromFile(path, "reviewUnsuccessful");
			return obj;
		} else {
			return null;
		}
	}
}
