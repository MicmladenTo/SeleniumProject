package tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AddressTests extends TestBase {

	
	//@Test (priority = 3)
	public void updateAddress() throws InterruptedException, IOException {
		logInSuccessfully();
		
		myAccountPage.clickMyAddresses();
		Thread.sleep(2000);
		
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
		logInSuccessfully();
		
		myAccountPage.clickMyAddresses();
		Thread.sleep(2000);
		Assert.assertEquals(myAddressesPage.getAddressTitles().size(), 1);
		
		myAddressesPage.clickAddAddressButton();
		Thread.sleep(2000);
		
		addressPage.enterNewAddressData("Kornelija Stankovica", "11", "Hackney", "Arizona", 
				"15000", "+3846892569", "+3689541666", "Test adresa");
		Thread.sleep(2000);
		
		Assert.assertEquals(myAddressesPage.getAddressTitles().size(), 2);
	}
	
	public void logInSuccessfully() throws InterruptedException {
		//		logInTests.logInCorrect();
		String username = excelCitac.getStringData("logInCorrect", 4, 6);
		String password = excelCitac.getStringData("logInCorrect", 5, 6);
		
		mainPage.clickSignIn();
		Thread.sleep(2000);
		loginPage.logIn(username, password);

		Thread.sleep(2000);
	}
	
}
