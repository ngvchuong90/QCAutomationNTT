package AllData;

import java.io.IOException;
import java.lang.reflect.Method;

import org.testng.annotations.DataProvider;

import Automation.generalActions;
import Common.Utilities;

public class paymentData extends generalActions {
	String path = Utilities.getProjectPath() + "\\DataObjects\\DataExcel\\data.xlsx";
	
	@DataProvider(name = "paymentData")
	public Object[][] getData(Method name) throws IOException {
		if (name.getName().equalsIgnoreCase("TC01")) {
			Object[][] obj = new generalActions().getDataFromFile(path, "paymentDataSuccessful");
			return obj;
		} else if (name.getName().equalsIgnoreCase("TC02")) {
			Object[][] obj = new generalActions().getDataFromFile(path, "paymentDataSuccessful");
			return obj;
		} else if (name.getName().equalsIgnoreCase("TC03")) {
			Object[][] obj = new generalActions().getDataFromFile(path, "paymentDataSuccessful");
			return obj;
		} else if (name.getName().equalsIgnoreCase("TC04")) {
			Object[][] obj = new generalActions().getDataFromFile(path, "paymentDataSuccessful");
			return obj;
		} else {
			return null;
		}
	}
}
