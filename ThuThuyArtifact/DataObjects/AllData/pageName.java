package AllData;

import java.io.IOException;
import java.lang.reflect.Method;

import org.testng.annotations.DataProvider;

import Automation.generalActions;
import Common.Utilities;

public class pageName extends generalActions{
	String path = Utilities.getProjectPath() + "\\DataObjects\\DataExcel\\data.xlsx";
	
	@DataProvider(name = "catPageName")
	public Object[][] getData(Method name) throws IOException {
		if (name.getName().equalsIgnoreCase("TC01")) {
			Object[][] obj = new Object[1][2];

			return obj;
		} else if (name.getName().equalsIgnoreCase("TC02")) {
			Object[][] obj = new generalActions().getDataFromFile(path, "pageDisplay");
			return obj;
		} else {
			return null;
		}
	}
}
