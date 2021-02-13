package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddressPage {
		
	WebDriver driver;
	JavascriptExecutor js;
	
	WebElement addressInput;
	WebElement address2Input;
	WebElement cityInput;
	WebElement stateInput;
	WebElement postalCodeInput;
	WebElement homePhoneInput;
	WebElement mobilePhoneInput;
	WebElement addressTitle;
	WebElement submitAddress;
	String enteredStreet;
	String enteredNumber;
	
	//Getters
	public WebElement getAddressInput() {
		return driver.findElement(By.id("address1"));
	}
	
	public WebElement getAddress2Input() {
		return driver.findElement(By.id("address2"));
	}
	
	public WebElement getSubmitAddress() {
		return driver.findElement(By.id("submitAddress"));
	}
	
	public WebElement getCityInput() {
		return driver.findElement(By.id("city"));
	}

	public WebElement getStateInput() {
		return driver.findElement(By.id("id_state"));
	}
	
	public WebElement getPostalCodeInput() {
		return driver.findElement(By.id("postcode"));
	}

	public WebElement getHomePhoneInput() {
		return driver.findElement(By.id("phone"));
	}

	public WebElement getMobilePhoneInput() {
		return driver.findElement(By.id("phone_mobile"));
	}

	public WebElement getAddressTitle() {
		return driver.findElement(By.id("alias"));
	}
	
	public String getEnteredStreet() {
		return driver.findElement(By.className("address_address1")).getText();
	}
	
	public String getEnteredNumber() {
		return driver.findElement(By.className("address_address2")).getText();
	}
	
	
	
	// Constructor
	public AddressPage(JavascriptExecutor js, WebDriver driver) {
		super();
		this.js = (JavascriptExecutor)driver;
		this.driver = driver;
	}
	
	// Functions

	
	public void changeAddress(String street, String number) {
		js.executeScript("arguments[0].scrollIntoView();", getAddressInput());
		getAddressInput().clear();
		getAddressInput().sendKeys(street);
		js.executeScript("arguments[0].scrollIntoView();", getAddress2Input());
		getAddress2Input().clear();
		getAddress2Input().sendKeys(number);
		submitAddress();
	}
	
	public void enterNewAddressData(String street, String number, String city, String state, String zip, String phone, String mobile, String alias) throws InterruptedException {
		js.executeScript("arguments[0].scrollIntoView();", getAddressInput());
		getAddressInput().sendKeys(street);
		Thread.sleep(1000);
		js.executeScript("arguments[0].scrollIntoView();", getAddress2Input());
		getAddress2Input().sendKeys(number);
		Thread.sleep(1000);
		js.executeScript("arguments[0].scrollIntoView();", getCityInput());
		getCityInput().sendKeys(city);
		Thread.sleep(1000);
		js.executeScript("arguments[0].scrollIntoView();", getStateInput());
		getStateInput().sendKeys(state);
		Thread.sleep(1000);
		js.executeScript("arguments[0].scrollIntoView();", getPostalCodeInput());
		getPostalCodeInput().sendKeys(zip);
		Thread.sleep(1000);
		js.executeScript("arguments[0].scrollIntoView();", getHomePhoneInput());
		getHomePhoneInput().sendKeys(phone);
		Thread.sleep(1000);
		js.executeScript("arguments[0].scrollIntoView();", getMobilePhoneInput());
		getMobilePhoneInput().sendKeys(mobile);
		Thread.sleep(1000);
		js.executeScript("arguments[0].scrollIntoView();", getAddressTitle());
		getAddressTitle().clear();
		getAddressTitle().sendKeys(alias);
		Thread.sleep(1000);
		submitAddress();
	}
	
	public void submitAddress() {
		js.executeScript("arguments[0].scrollIntoView();", getSubmitAddress());
		getSubmitAddress().click();
	} 
}
