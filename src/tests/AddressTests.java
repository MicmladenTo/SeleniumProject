package tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddressTests extends TestBase {
	
	@BeforeMethod
	public void setup() throws InterruptedException {
		driver.navigate().to("http://automationpractice.com/index.php");
		Thread.sleep(2000);
		logInSuccessfully();
		myAccountPage.clickMyAddresses();
		Thread.sleep(2000);
	}

	
	@Test (priority = 3)
	public void updateAddress() throws InterruptedException, IOException {
		myAddressesPage.clickUpdateAddressButton();
		Thread.sleep(2000);
		
		addressPage.changeAddress("Kornelija Stankoviæa", "11");
		
		Thread.sleep(2000);
		Assert.assertEquals(addressPage.getEnteredAddress(), addressPage.getTestAddress());
		Assert.assertEquals(addressPage.getEnteredNumber(), addressPage.getTestStreetNumber());
		
		Thread.sleep(2000);
		myAddressesPage.clickUpdateAddressButton();
		addressPage.changeAddress("Acacia Avenue", "22");
	}
	
	@Test (priority = 5)
	public void addAddress() throws InterruptedException, IOException {
		Assert.assertEquals(myAddressesPage.getDeleteAddressButtons().size(), 1);
		
		myAddressesPage.clickAddAddressButton();
		Thread.sleep(2000);
		
		addressPage.enterNewAddressData("Kornelija Stankovica", "11", "Hackney", "Arizona", 
				"15000", "+3846892569", "+3689541666", "Test adresa");
		Thread.sleep(2000);
		
		Assert.assertEquals(myAddressesPage.getDeleteAddressButtons().size(), 2);
	}
	
	@Test (priority = 7)
	public void deleteAddress() throws InterruptedException, IOException {
		Assert.assertEquals(myAddressesPage.getDeleteAddressButtons().size(), 2);
		myAddressesPage.getDeleteAddressButtons().get(1).click();
		myAddressesPage.alertOK();
		Thread.sleep(2000);
		Assert.assertEquals(myAddressesPage.getDeleteAddressButtons().size(), 1);
		Thread.sleep(2000);	
	}
	
	@AfterMethod
	public void afterTest() throws InterruptedException {
		Thread.sleep(2000);
		driver.manage().deleteAllCookies();
		driver.navigate().refresh();
		Thread.sleep(2000);
	}
	
}
