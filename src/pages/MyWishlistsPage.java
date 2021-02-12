package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MyWishlistsPage {
	
	WebDriver driver;
	
	WebElement newWishlistInput;
	WebElement saveButton;
	WebElement wishlists;
	WebElement deleteWishlistButton;
	
	public int numberOfLists;
	
	
	public WebElement getNewWishlistInput() {
		return driver.findElement(By.id("name"));
	}

	public WebElement getSaveButton() {
		return driver.findElement(By.id("submitWishlist"));
	}
	
	public List<WebElement> getWishlists() {
		return driver.findElements(By.cssSelector("[id*=wishlist_]"));
	}
	
	public List<WebElement> getDeleteWishlistButton() {
		return driver.findElements(By.className("icon"));
	}
	
	public int getNumberofLists() {
		return getWishlists().size();
	}


	//Constructor
	public MyWishlistsPage(WebDriver driver) {
		this.driver = driver;
	}
	
	// Functions
	public void createAWishlist(String name) {
		getNewWishlistInput().sendKeys(name);
		getSaveButton().click();
	}
	
	public void deleteAllWishlists() throws InterruptedException {
		for(int i = 0; i < getNumberofLists(); i++) {
			getDeleteWishlistButton().get(i).click();
			driver.switchTo().alert().accept();
		}
		Thread.sleep(1000);
	}
	
	public void deleteAWishlist() throws InterruptedException {
			getDeleteWishlistButton().get(0).click();
			driver.switchTo().alert().accept();
	}
	
}
