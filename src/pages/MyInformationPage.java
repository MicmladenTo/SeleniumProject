package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MyInformationPage {
	
	WebDriver driver;
	JavascriptExecutor js;
	
	WebElement socialTitle;
	WebElement firstNameInput;
	WebElement lastNameInput;
	WebElement emailInput;
	WebElement dayInput;
	WebElement monthInput;
	WebElement yearInput;
	WebElement currentPasswordInput;
	WebElement saveButton;
	WebElement updateConfirmation;
	String verificationText;
	
	
	public WebElement getSocialTitle() {
		return driver.findElement(By.id("id_gender1"));
	}

	public WebElement getFirstNameInput() {
		return driver.findElement(By.id("firstname"));
	}

	public WebElement getLastNameInput() {
		return driver.findElement(By.id("lastname"));
	}

	public WebElement getEmailInput() {
		return driver.findElement(By.id("email"));
	}

	public WebElement getDayInput() {
		return driver.findElement(By.id("days"));
	}

	public WebElement getMonthInput() {
		return driver.findElement(By.id("months"));
	}

	public WebElement getYearInput() {
		return driver.findElement(By.id("years"));
	}

	public WebElement getCurrentPasswordInput() {
		return driver.findElement(By.id("old_passwd"));
	}

	public WebElement getSaveButton() {
		return driver.findElement(By.name("submitIdentity"));
	}

	public WebElement getUpdateConfirmation() {
		return driver.findElement(By.className("alert-success"));
	}
	
	public String getVerificationText() {
		return "Your personal information has been successfully updated.";
	}
	
	// Functions
	public void addPersonalData(String name, String surname, String email, String birthDay, String birthMonth, String birthYear, String password) {
		getSocialTitle().click();
		getFirstNameInput().clear();
		getFirstNameInput().sendKeys(name);
		js.executeScript("arguments[0].scrollIntoView();", getLastNameInput());
		getLastNameInput().clear();
		getLastNameInput().sendKeys(surname);
		getEmailInput().clear();
		getEmailInput().sendKeys(email);
		getDayInput().sendKeys(birthDay);
		getMonthInput().sendKeys(birthMonth);
		getYearInput().sendKeys(birthYear);
		getCurrentPasswordInput().sendKeys(password);
		getSaveButton().click();
	}



	// Constructor
	public MyInformationPage(JavascriptExecutor js, WebDriver driver) {
		super();
		this.driver = driver;
		this.js = (JavascriptExecutor)driver;
	}
	
	
}
