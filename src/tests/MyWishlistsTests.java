package tests;

import static org.testng.Assert.assertNotNull;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MyWishlistsTests extends TestBase {

	@BeforeMethod
	public void setup() throws InterruptedException {
		driver.navigate().to("http://automationpractice.com/index.php");
		Thread.sleep(1000);
		logInSuccessfully();
		myAccountPage.clickMyWishlists();
		Thread.sleep(1000);
	}

	@Test (priority = 1)
	public void addAWishlist() throws InterruptedException {
		String listName = excelCitac.getData("My wishlist", 3, 6);
		
		Assert.assertEquals(myWishlistsPage.getNumberofLists(), 0);
		myWishlistsPage.createAWishlist(listName);
		Assert.assertEquals(myWishlistsPage.getNumberofLists(), 1);
	}
	
	@Test (priority = 2)
	public void addMultipleWishlists() throws InterruptedException {
		String secondListName = excelCitac.getData("My wishlist", 7, 6);
		String thirdListName = excelCitac.getData("My wishlist", 9, 6);
		
		myWishlistsPage.createAWishlist(secondListName);
		myWishlistsPage.createAWishlist(thirdListName);
		Assert.assertEquals(myWishlistsPage.getNumberofLists(), 3);
	}
	
	@Test (priority = 3)
	public void deleteAWishlist() throws InterruptedException {

		myWishlistsPage.deleteAWishlist();
		Thread.sleep(3000);
		Assert.assertEquals(myWishlistsPage.getNumberofLists(), 2);
	}
	
	@Test (priority = 4)
	public void deleteAllWishlists() throws InterruptedException {
		
		myWishlistsPage.deleteAllWishlists();
		Thread.sleep(2000);
		Assert.assertEquals(myWishlistsPage.getNumberofLists(), 0);
	}
	
	@AfterMethod
	public void afterTest() throws InterruptedException {
		Thread.sleep(2000);
		driver.manage().deleteAllCookies();
		driver.navigate().refresh();
//		Thread.sleep(2000);
	}
}
