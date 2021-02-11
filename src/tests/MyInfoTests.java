package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MyInfoTests extends TestBase {
	
	@BeforeMethod
	public void setup() throws InterruptedException {
		driver.navigate().to("http://automationpractice.com/index.php");
		Thread.sleep(2000);
		logInSuccessfully();
		myAccountPage.clickMyInfo();
		Thread.sleep(2000);
	}
	
	@Test
	public void updatePersonalInfo() throws InterruptedException {
		myInformationPage.addPersonalData("Mladen", "Tomic", "micmladento@gmail.com", "20", "November", "1984", "NekaSifra");
		Assert.assertEquals(myInformationPage.getUpdateConfirmation().getText(), myInformationPage.getVerificationText());
	}
}
