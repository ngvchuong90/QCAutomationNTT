package AllData;

import java.io.IOException;
import java.lang.reflect.Method;

import org.testng.annotations.DataProvider;

import Automation.generalActions;
import Common.Utilities;

public class searchData extends generalActions {
	String path = Utilities.getProjectPath() + "\\DataObjects\\DataExcel\\data.xlsx";
	
	@DataProvider(name = "searchData")
	public Object[][] getData(Method name) throws IOException {
		if (name.getName().equalsIgnoreCase("TC01")) {
			Object[][] obj = new generalActions().getDataFromFile(path, "searchvalid");
			return obj;
		} else if (name.getName().equalsIgnoreCase("TC02")) {
			Object[][] obj = new generalActions().getDataFromFile(path, "searchInvalid");
			return obj;
		} else {
			return null;
		}
	}
}
