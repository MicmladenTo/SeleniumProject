package pages;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;



public class MyAddressesPage {
	
	WebDriver driver;
	JavascriptExecutor js;
	
	WebElement updateAddressButton;
	WebElement addAddressButton;
	WebElement addressTitle;
	WebElement deleteButton;
	Alert alert;
	
	//Getters
	public WebElement getUpdateAddressButton() {
		return driver.findElement(By.xpath("//a[@title='Update']"));
	}
	
	public WebElement getAddAddressButton() {
		return driver.findElement(By.xpath("//a[@title='Add an address']"));
	}
	
//	public List<WebElement> getAddressTitles() {
//		return driver.findElements(By.className("page-subheading"));
//	}
	
	public List<WebElement> getDeleteAddressButtons() {
		return driver.findElements(By.xpath("//a[@title='Delete']"));
	}
	
	// Konstruktor
	public MyAddressesPage(JavascriptExecutor js, WebDriver driver) {
		super();
		this.js = (JavascriptExecutor)driver;
		this.driver = driver;
	}

	//Functions
	public void clickUpdateAddressButton() {
		js.executeScript("arguments[0].scrollIntoView();", getUpdateAddressButton());
		getUpdateAddressButton().click();
	}
	
	public void clickAddAddressButton() {
		js.executeScript("arguments[0].scrollIntoView();", getAddAddressButton());
		getAddAddressButton().click();
	}
	
	public void alertOK() throws InterruptedException {
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
	}

}
