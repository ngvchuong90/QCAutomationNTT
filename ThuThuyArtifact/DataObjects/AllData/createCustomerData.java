package AllData;

import java.io.IOException;
import java.lang.reflect.Method;

import org.testng.annotations.DataProvider;

import Automation.generalActions;
import Common.Utilities;

public class createCustomerData {
	String path = Utilities.getProjectPath() + "\\DataObjects\\DataExcel\\data.xlsx";

	@DataProvider(name = "createCustomerData")
	public Object[][] getData(Method name) throws IOException {
		if (name.getName().equalsIgnoreCase("TC01")) {
			Object[][] obj = new generalActions().getDataFromFile(path, "createAccountWithValidInfo");
			return obj;
		} else if (name.getName().equalsIgnoreCase("TC02")) {
			Object[][] obj = new generalActions().getDataFromFile(path, "createAccountWithInvalidEmail");
			return obj;
		} else if (name.getName().equalsIgnoreCase("TC03")) {
			Object[][] obj = new generalActions().getDataFromFile(path, "createAccountWithInvalidInfo");
			return obj;
		} else {
			return null;
		}
	}
}
