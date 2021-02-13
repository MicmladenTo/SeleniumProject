package tests;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class LogInTests extends TestBase {

	@BeforeMethod
	public void setup() throws InterruptedException {
		driver.navigate().to("http://automationpractice.com/index.php");
		Thread.sleep(2000);
	}

	@Test
	public void logInCorrect() throws InterruptedException, IOException {
		
		String username = excelCitac.getData("Login form", 4, 6);
		String password = excelCitac.getData("Login form", 5, 6);
		String assertText = excelCitac.getData("Login form", 6, 6);
		
		mainPage.clickSignIn();
		Thread.sleep(2000);
		
		loginPage.logIn(username, password);
		Thread.sleep(2000);
		Assert.assertEquals(myAccountPage.getAccountInfo(), assertText);
	}
	
	@Test
	public void invalidEmailLogin() throws InterruptedException {
		
		String username = excelCitac.getData("Login form", 10, 6);
		String password = excelCitac.getData("Login form", 11, 6);
		String assertErrorText = excelCitac.getData("Login form", 12, 6);
		
		mainPage.clickSignIn();
		Thread.sleep(2000);
		
		loginPage.logIn(username, password);
		Thread.sleep(2000);
		Assert.assertEquals(loginPage.getAlertNotification().getText(), assertErrorText);
	}
	
	@Test
	public void invalidPassLogin() throws InterruptedException {
		
		String username = excelCitac.getData("Login form", 16, 6);
		String password = excelCitac.getData("Login form", 17, 6);
		String assertErrorText = excelCitac.getData("Login form", 18, 6);
		
		mainPage.clickSignIn();
		Thread.sleep(2000);
		
		loginPage.logIn(username, password);
		Thread.sleep(2000);
		Assert.assertEquals(loginPage.getAlertNotification().getText(), assertErrorText);
	}
	
	@Test
	public void noCredentialsLogin() throws InterruptedException {
		
		String username = "";
		String password = "";
		String assertErrorMessage = excelCitac.getData("Login form", 22, 6);
		
		mainPage.clickSignIn();
		Thread.sleep(2000);
		
		loginPage.logIn(username, password);
		Thread.sleep(2000);
		Assert.assertEquals(loginPage.getAlertNotification().getText(), assertErrorMessage);
	}

	@AfterMethod
	public void afterTest() throws InterruptedException {
		driver.manage().deleteAllCookies();
		driver.navigate().refresh();
		Thread.sleep(2000);
	}
	
	
}
