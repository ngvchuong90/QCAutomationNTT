package AllData;

import java.lang.reflect.Method;

import org.testng.annotations.DataProvider;

import Automation.generalActions;

public class pageName extends generalActions{
	@DataProvider(name = "pageName")
	public Object[][] getData(Method name) {
		if (name.getName().equalsIgnoreCase("TC01")) {
			Object[][] obj = new Object[1][2];

			return obj;
		} else if (name.getName().equalsIgnoreCase("TC02")) {
			Object[][] obj = new Object[1][2];

			return obj;
		} else if (name.getName().equalsIgnoreCase("TC03")) {
			Object[][] obj = new Object[1][2];

			return obj;
		} else if (name.getName().equalsIgnoreCase("TC04")) {
			Object[][] obj = new Object[1][2];
			
			obj[0][0] = "women";
			obj[0][1] = "WOMEN";
			return obj;
		} else {
			return null;
		}
	}
}
