package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage {
	
	WebDriver driver;
	
	WebElement signInButton;
	
	
	//Getters
	public WebElement getSignInButton() {
		return driver.findElement(By.className("login"));
	}
	
	//Constructor
	public MainPage(WebDriver driver) {
		this.driver = driver;
	}
	
	//Functions
	public void clickSignIn() {
		getSignInButton().click();
	}
}
