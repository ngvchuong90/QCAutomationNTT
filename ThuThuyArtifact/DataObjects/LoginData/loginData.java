package LoginData;

import java.lang.reflect.Method;

import org.testng.annotations.DataProvider;

import Automation.generalActions;

public class loginData extends generalActions {

	@DataProvider(name = "authenticationLogin")
	public Object[][] getData(Method name) {
		if (name.getName().equalsIgnoreCase("TC01")) {
			Object[][] obj = new Object[1][2];
			obj[0][0] = "nghiemthuthuy1912@gmail.com";
			obj[0][1] = "123456a@";

			return obj;
		} else if (name.getName().equalsIgnoreCase("TC02")) {
			Object[][] obj = new Object[2][3];

			obj[0][0] = "";
			obj[0][1] = "";
			obj[0][2] = "An email address required.";

			obj[1][0] = "test@gmail.com";
			obj[1][1] = "";
			obj[1][2] = "Password is required.";

			return obj;
		} else if (name.getName().equalsIgnoreCase("TC03")) {
			Object[][] obj = new Object[1][10];

			obj[0][0] = "QC";
			obj[0][1] = "Automation";
			obj[0][2] = "123456789";
			obj[0][3] = "No1 Florida Building";
			obj[0][4] = "Texas";
			obj[0][5] = "Texas";
			obj[0][6] = "97000";
			obj[0][7] = "United States";
			obj[0][8] = "090909090";
			obj[0][9] = "123";

			return obj;
		} else if (name.getName().equalsIgnoreCase("TC04")) {
			Object[][] obj = new Object[2][2];

			obj[0][0] = "nghiemthuthuy1912@gmail.com";
			obj[0][1] = "An account using this email address has already been registered. Please enter a valid password or request a new one.";

			obj[0][0] = "nghiemthuthuy1912";
			obj[0][1] = "Invalid email address.";

			return obj;
		} else if (name.getName().equalsIgnoreCase("TC07")) {
			Object[][] obj = new Object[2][2];

			obj[0][0] = "";
			obj[0][1] = "Please enter a search keyword";

			obj[1][0] = "test@gmail.com";
			obj[1][1] = "No results were found for your search";

			return obj;
		} else {
			return null;
		}
	}
}
