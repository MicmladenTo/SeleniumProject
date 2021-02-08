package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	
	WebDriver driver;
	
	WebElement emailInput;
	WebElement passwordInput;
	WebElement signInButton;
	WebElement alertNotification;
	
	String alertNotificationText;
	String noEmailNotification;
	
	//Getters
	public WebElement getEmailInput() {
		return driver.findElement(By.id("email"));
	}
	
	public WebElement getPasswordInput() {
		return driver.findElement(By.id("passwd"));
	}
	
	public WebElement getSignInButton() {
		return driver.findElement(By.id("SubmitLogin"));
	}
	
	public WebElement getAlertNotification() {
		return driver.findElement(By.xpath("//*[@id=\"center_column\"]/div[1]/ol/li"));
	}
	
	public String getAlertNotificationText() {
		return 	"Authentication failed.";
	}
	
	public String noEmailNotification() {
		return 	"An email address required.";
	}
	

	
	
	//Constructor
	public LoginPage(WebDriver driver) {
		super();
		this.driver = driver;
	}
	
	//Functions
	public void insertUsername(String username) {
		getEmailInput().sendKeys(username);
	}
	
	public void insertPassword(String password) {
		getPasswordInput().sendKeys(password);
	}
	
	public void clickSignInButton() {
		getSignInButton().click();
	}
	
	public void logIn(String username, String password) throws InterruptedException {
		insertUsername(username);
		insertPassword(password);
		clickSignInButton();
		Thread.sleep(2000);
	}
	
}
