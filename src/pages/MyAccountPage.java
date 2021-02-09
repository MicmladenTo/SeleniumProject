package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MyAccountPage {

	WebDriver driver;
	
	WebElement accountInfo;
	WebElement myAddressesButton;

	String assertText;
	
	
	//Getters
	public String getAccountInfo() {
		return driver.findElement(By.className("info-account")).getText();
	}
	public String getAssertText() {
		return "Welcome to your account. Here you can manage all of your personal information and orders.";
	}
	
	public WebElement getMyAddressesButton() {
		return driver.findElement(By.xpath("//a[@title='Addresses']"));
//		return driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/div/div[1]/ul/li[3]/a"));
		
	}
	
	//Constructor
	public MyAccountPage(WebDriver driver) {
		this.driver = driver;
	}
	
	//Functions
	public void clickMyAddresses() {
		getMyAddressesButton().click();
	}
	
	
}
