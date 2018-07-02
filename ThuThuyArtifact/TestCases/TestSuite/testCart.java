package TestSuite;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import Automation.HomePage;

public class testCart extends configNormal{
	@Test(dataProvider = "cartData", dataProviderClass = AllData.cartData.class)
	public void TC01(String noN, String testCase, String productN) throws InterruptedException {
		System.out.println("TC" + noN +  " - " + testCase);
		HomePage homePage = new HomePage();
		String message = homePage.open().selectProduct(productN).addProducToCart().getAddToCartSuccessMessLabel().getText();
		assertEquals(message, "Product successfully added to your shopping cart");
	}
	
	@Test(dataProvider = "cartData", dataProviderClass = AllData.cartData.class)
	public void TC02(String noN, String testCase, String productN) throws InterruptedException {
		System.out.println("TC" + noN +  " - " + testCase);
		HomePage homePage = new HomePage();
		String message = homePage.open().quickViewProduct(productN).addProducToCart().getAddToCartSuccessMessLabel().getText();
		assertEquals(message, "Product successfully added to your shopping cart");
	}
	
	@Test(dataProvider = "cartData", dataProviderClass = AllData.cartData.class)
	public void TC03(String noN, String testCase, String productN) throws InterruptedException {
		System.out.println("TC" + noN +  " - " + testCase);
		HomePage homePage = new HomePage();
		String message = homePage.open().selectMoreDetailProduct(productN).addProducToCart().getAddToCartSuccessMessLabel().getText();
		assertEquals(message, "Product successfully added to your shopping cart");
	}
	
	@Test(dataProvider = "cartData", dataProviderClass = AllData.cartData.class)
	public void TC04(String noN, String testCase, String productN, String quantity, String size, String color) throws InterruptedException {
		System.out.println("TC" + noN +  " - " + testCase);
		String informationP = productN + " " + color + ", " + size + " " + quantity;
		HomePage homePage = new HomePage();
		String info = homePage.open().selectMoreDetailProduct(productN).choseCartInformation(quantity, size, color).getProductInfo();
		assertEquals(info, informationP);
	}
}
