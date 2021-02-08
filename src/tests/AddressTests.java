package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AddressTests extends TestBase {


	@Test
	public void successfullyLogIn() throws InterruptedException {
		
		String username = excelCitac.getStringData("logInCorrect", 4, 6);
		String password = excelCitac.getStringData("logInCorrect", 5, 6);
		
		mainPage.clickSignIn();
		Thread.sleep(2000);
		loginPage.logIn(username, password);

		Thread.sleep(2000);

	}
	
	@Test
	public void updateAddress() throws InterruptedException {
		
		myAccountPage.clickMyAddresses();
		Thread.sleep(2000);
		
	}
	
}
