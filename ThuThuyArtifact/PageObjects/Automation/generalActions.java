package Automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Constants.Constant;

public class generalActions {
	public String generateRandomEmail() {
		String randomEmail = String.valueOf(System.currentTimeMillis()) + "@gmail.com";
		return randomEmail;
	}

	public void waitForControlStable(WebElement element) {
		try {
			Thread.sleep(1000);
			int count = 0;
			while (element.isDisplayed() == false && count <= 15) {
				Thread.sleep(1000);
				count++;
			}
			while (element.isEnabled() == false && count <= 15) {
				Thread.sleep(1000);
				count++;
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public boolean checkControlDisplay(WebElement element) {
		boolean check1 = element.isDisplayed();
		return check1;
	}
	
	public void waitForControlNotDisplay(WebElement element) {
		try {
			Thread.sleep(1000);
			int count = 0;
			while (element.isDisplayed() == true && count <= 10) {
				System.out.println(element.isDisplayed());
				Thread.sleep(1000);
				count++;
			}
		} catch(InterruptedException e) {
			
		}
	}
	
	public WebElement dynamicXpath(String str1, String xpath1) {
		String newXpath = xpath1.replace("{0}", str1);	
		return Constant.WEBDRIVER.findElement(By.xpath(newXpath));
	}
}
