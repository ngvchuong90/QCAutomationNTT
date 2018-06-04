package Automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Constants.Constant;

public class LoginPage extends GeneralPage{

	//// LOCATORS
	// Login Form
	private final By txtUsername = By.xpath("//input[@id='email']");
	private final By txtPassword = By.xpath("//input[@id='passwd']");
	private final By BtnLogin = By.xpath("//button[@id='SubmitLogin']");
	private final By errorMessageLabel = By.xpath("//div[@class='alert alert-danger']//li");

	// Create Account
	private final By textEmailCreate = By.xpath("//input[@id='email_create']");
	private final By btnSubmitCreate = By.xpath("//button[@id='SubmitCreate']");

	// Create Account Form
	private final By radioButtonMr = By.xpath("//div[@id='uniform-id_gender1']");
	private final By radioButtonMrs = By.xpath("//div[@id='uniform-id_gender2']");
	private final By textCustomerFirstName = By.xpath("//input[@id='customer_firstname']");
	private final By textCustomerLastName = By.xpath("//input[@id='customer_lastname']");
	private final By textEmail = By.xpath("//input[@id='email']");
	private final By textPassword = By.xpath("//input[@id='passwd']");
	private final By selectBirthDay = By.xpath("//select[@id='days']");
	private final By selectBirthMonth = By.xpath("//select[@id='months']");
	private final By selectBirthYear = By.xpath("//select[@id='years']");
	private final By txtCompany = By.xpath("//input[@id='company']");
	private final By txtAddress = By.xpath("//input[@id='address1']");
	private final By txtCity = By.xpath("//input[@id='city']");
	private final By selectState = By.xpath("//select[@id='id_state']");
	private final By txtPostCode = By.xpath("//input[@id='postcode']");
	private final By selectCountry = By.xpath("//select[@id='id_country']");
	private final By txtPhoneMobile = By.xpath("//input[@id='phone_mobile']");
	private final By txtAlias = By.xpath("//input[@id='alias']");
	private final By btnRegister = By.xpath("//button[@id='submitAccount']");

	//// ELEMENTS
	public WebElement getTxtUsername() {
		return Constant.WEBDRIVER.findElement(txtUsername);
	}

	public WebElement getTxtPassword() {
		return Constant.WEBDRIVER.findElement(txtPassword);
	}

	public WebElement getBtnlogin() {
		return Constant.WEBDRIVER.findElement(BtnLogin);
	}

	public WebElement getErrorMessageLabel() {
		return Constant.WEBDRIVER.findElement(errorMessageLabel);
	}

	public WebElement getRadioButtonMr() {
		return Constant.WEBDRIVER.findElement(radioButtonMr);
	}

	public WebElement getRadioButtonMrs() {
		return Constant.WEBDRIVER.findElement(radioButtonMrs);
	}

	public WebElement getTextCustomerFirstName() {
		return Constant.WEBDRIVER.findElement(textCustomerFirstName);
	}

	public WebElement getTextCustomerLastName() {
		return Constant.WEBDRIVER.findElement(textCustomerLastName);
	}

	public WebElement getTextEmail() {
		return Constant.WEBDRIVER.findElement(textEmail);
	}

	public WebElement getTextPassword() {
		return Constant.WEBDRIVER.findElement(textPassword);
	}

	public WebElement getSelectBirthDay() {
		return Constant.WEBDRIVER.findElement(selectBirthDay);
	}

	public WebElement getSelectBirthMonth() {
		return Constant.WEBDRIVER.findElement(selectBirthMonth);
	}

	public WebElement getSelectBirthYear() {
		return Constant.WEBDRIVER.findElement(selectBirthYear);
	}

	public WebElement getTxtCompany() {
		return Constant.WEBDRIVER.findElement(txtCompany);
	}

	public WebElement getTxtAddress() {
		return Constant.WEBDRIVER.findElement(txtAddress);
	}

	public WebElement getTxtCity() {
		return Constant.WEBDRIVER.findElement(txtCity);
	}

	public WebElement getSelectState() {
		return Constant.WEBDRIVER.findElement(selectState);
	}

	public WebElement getTxtPostCode() {
		return Constant.WEBDRIVER.findElement(txtPostCode);
	}

	public WebElement getSelectCountry() {
		return Constant.WEBDRIVER.findElement(selectCountry);
	}

	public WebElement getTxtPhoneMobile() {
		return Constant.WEBDRIVER.findElement(txtPhoneMobile);
	}

	public WebElement getTxtAlias() {
		return Constant.WEBDRIVER.findElement(txtAlias);
	}

	public WebElement getBtnRegister() {
		return Constant.WEBDRIVER.findElement(btnRegister);
	}

	public WebElement getTextEmailCreate() {
		return Constant.WEBDRIVER.findElement(textEmailCreate);
	}

	public WebElement getBtnSubmitCreate() {
		return Constant.WEBDRIVER.findElement(btnSubmitCreate);
	}

	//// METHODS
	public void login(String userName, String password) {
		this.getTxtUsername().sendKeys(userName);
		this.getTxtPassword().sendKeys(password);
		this.getBtnlogin().click();
	}

	public MyAccountPage loginSuccessfull(String userName, String password) {
		this.login(userName, password);
		return new MyAccountPage();
	}
	
	public OrderPage loginSuccessfullToPayment(String userName, String password) {
		this.login(userName, password);
		return new OrderPage();
	}

	public LoginPage loginUnsuccessfull(String userName, String password) {
		this.login(userName, password);
		return new LoginPage();
	}

	public String getErrorMessage() {
		String errorMess = this.getErrorMessageLabel().getText();
		return errorMess;
	}

	public void selectGender(String gender) {
		if (gender == "Mr") {
			this.getRadioButtonMr().click();
		} else if (gender == "Mrs") {
			this.getRadioButtonMrs().click();
		} else {
			System.out.println("No choose Gender.");
		}
	}

	public void createEmailAccountAuthentication(String email) throws InterruptedException {
		this.getTextEmailCreate().sendKeys(email);
		this.getBtnSubmitCreate().click();
	}

	public LoginPage createEmailAccountAuthenticationSuccessfull(String email) throws InterruptedException {
		this.createEmailAccountAuthentication(email);
		generalActions gAction = new generalActions();
		gAction.waitForControlStable(this.getBtnRegister());
		return this;
	}

	public LoginPage createEmailAccountAuthenticationUnsuccessfull(String email) throws InterruptedException {
		this.createEmailAccountAuthentication(email);
		return this;
	}

	public void submitCreateAccount(String firstName, String lastName, String passWord, String address, String city, String state, String postCode, String country, String mobiPhone, String allias) {
		this.getTextCustomerFirstName().sendKeys(firstName);
		this.getTextCustomerLastName().sendKeys(lastName);
		this.getTextPassword().sendKeys(passWord);
		this.getTxtAddress().sendKeys(address);
		this.getTxtCity().sendKeys(city);
		this.getSelectState().sendKeys(state);
		this.getTxtPostCode().sendKeys(postCode);
		this.getSelectCountry().sendKeys(country);
		this.getTxtPhoneMobile().sendKeys(mobiPhone);
		this.getTxtAlias().sendKeys(allias);
		this.getBtnRegister().click();
	}
	
	public MyAccountPage submitCreateAccountSuccessfull(String firstName, String lastName, String passWord, String address, String city, String state, String postCode, String country, String mobiPhone, String allias) {
		this.submitCreateAccount(firstName, lastName, passWord, address, city, state, postCode, country, mobiPhone, allias);
		return new MyAccountPage();
	}
	
	public LoginPage submitCreateAccountUnsuccessfull(String firstName, String lastName, String passWord, String address, String city, String state, String postCode, String country, String mobiPhone, String allias) {
		this.submitCreateAccount(firstName, lastName, passWord, address, city, state, postCode, country, mobiPhone, allias);
		return new LoginPage();
	}
	
	public LoginPage submitCreateAccountWithInvalidEmail(String invalidEmail) {
		this.getTextEmailCreate().sendKeys(invalidEmail);
		return new LoginPage();
	}

}
