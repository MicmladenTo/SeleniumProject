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
		String street = excelCitac.getData("Address", 8, 6);
		String number = excelCitac.getData("Address", 9, 6);
		String newStreet = excelCitac.getData("Address", 4, 6);
		String newNumber = excelCitac.getData("Address", 5, 6);
		
		myAddressesPage.clickUpdateAddressButton();
		Thread.sleep(2000);
		
		addressPage.changeAddress(newStreet, newNumber);
		
		Thread.sleep(2000);
		Assert.assertEquals(addressPage.getEnteredStreet(), newStreet);
		Assert.assertEquals(addressPage.getEnteredNumber(), newNumber);
		
		Thread.sleep(2000);
		myAddressesPage.clickUpdateAddressButton();
		addressPage.changeAddress(street, number);
	}
	
	@Test (priority = 5)
	public void addAddress() throws InterruptedException, IOException {
		
		String street = excelCitac.getData("Address", 14, 6);
		String number = excelCitac.getData("Address", 15, 6);
		String city = excelCitac.getData("Address", 16, 6);
		String state = excelCitac.getData("Address", 17, 6);
		String zip = excelCitac.getData("Address", 18, 6);
		String phone = excelCitac.getData("Address", 19, 6);
		String mobile = excelCitac.getData("Address", 20, 6);
		String alias = excelCitac.getData("Address", 21, 6);
				
		Assert.assertEquals(myAddressesPage.getDeleteAddressButtons().size(), 1);
		
		myAddressesPage.clickAddAddressButton();
		Thread.sleep(2000);
		
		addressPage.enterNewAddressData(street, number, city, state, zip, phone, mobile, alias);
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
