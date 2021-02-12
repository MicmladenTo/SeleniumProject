package tests;

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
		myWishlistsPage.createAWishlist("testList");
		Assert.assertEquals(myWishlistsPage.getNumberofLists(), 1);
	}
	
	@Test (priority = 2)
	public void addMultipleWishlists() throws InterruptedException {
		myWishlistsPage.createAWishlist("testList2");
		myWishlistsPage.createAWishlist("testList3");
		Assert.assertEquals(myWishlistsPage.getNumberofLists(), 3);
	}
	
	@Test (priority = 3)
	public void deleteWishlists() throws InterruptedException {
		
		// Delete a single wishlist:
//		myWishlistsPage.deleteAWishlist();
		
		// Delete all wishlists
		myWishlistsPage.deleteAllWishlists();
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
