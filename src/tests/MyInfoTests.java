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
		
		String name = excelCitac.getData("My information", 4, 6);
		String surname = excelCitac.getData("My information", 5, 6);
		String email = excelCitac.getData("My information", 6, 6);
		String birthDay = excelCitac.getData("My information", 7, 6);
		String birthMonth = excelCitac.getData("My information", 8, 6);
		String birthYear = excelCitac.getData("My information", 9, 6);
		String password = excelCitac.getData("My information", 10, 6);
		String assertUpdate = excelCitac.getData("My information", 11, 6);
		
		
		myInformationPage.addPersonalData(name, surname, email, birthDay, birthMonth, birthYear, password);
		
		Assert.assertEquals(myInformationPage.getUpdateConfirmation().getText(), assertUpdate);
	}
}
