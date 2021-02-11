package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MyAccountPage {

	WebDriver driver;
	
	WebElement accountInfo;
	WebElement myAddressesButton;
	WebElement myInfoButton;
	WebElement myWishlistsButton;

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
	}
	
	public WebElement getMyInfoButton() {
		return driver.findElement(By.xpath("//a[@title='Information']"));
	}
	
	public WebElement getMyWishlistsButton() {
		return driver.findElement(By.xpath("//a[@title='My wishlists']"));
	}
	
	
	
	//Constructor
	public MyAccountPage(WebDriver driver) {
		this.driver = driver;
	}
	
	//Functions
	public void clickMyAddresses() {
		getMyAddressesButton().click();
	}
	public void clickMyInfo() {
		getMyInfoButton().click();
	}
	
	public void clickMyWishlists() {
		getMyWishlistsButton().click();
	}
	
	
}
