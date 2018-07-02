package AllData;

import java.io.IOException;
import java.lang.reflect.Method;

import org.testng.annotations.DataProvider;

import Automation.generalActions;
import Common.Utilities;

public class contactUsData {
	String path = Utilities.getProjectPath() + "\\DataObjects\\DataExcel\\data.xlsx";

	@DataProvider(name = "contactUs")
	public Object[][] getData(Method name) throws IOException {
		if (name.getName().equalsIgnoreCase("TC01")) {
			Object[][] obj = new generalActions().getDataFromFile(path, "contactUsSuccessful");
			return obj;
		} if (name.getName().equalsIgnoreCase("TC02")) {
			Object[][] obj = new generalActions().getDataFromFile(path, "contactUsUnsuccessful");
			return obj;
		} if (name.getName().equalsIgnoreCase("TC03")) {
			Object[][] obj = new generalActions().getDataFromFile(path, "loginSuccessfull");
			return obj;
		} else {
			return null;
		}
	}
}
