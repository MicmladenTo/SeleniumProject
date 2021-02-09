package tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.MainPage;

public class LogInTests extends TestBase {


	@Test
	public void logInCorrect() throws InterruptedException, IOException {
		
		String username = excelCitac.getStringData("logInCorrect", 4, 6);
		String password = excelCitac.getStringData("logInCorrect", 5, 6);
		
		mainPage.clickSignIn();
		Thread.sleep(2000);
		
		loginPage.logIn(username, password);
		Thread.sleep(2000);
		Assert.assertEquals(myAccountPage.getAccountInfo(), myAccountPage.getAssertText());
	}
	
	@Test
	public void invalidEmailLogin() throws InterruptedException {
		
		String username = excelCitac.getStringData("invalidUsername", 4, 6);
		String password = excelCitac.getStringData("invalidUsername", 5, 6);
		
		mainPage.clickSignIn();
		Thread.sleep(2000);
		
		loginPage.logIn(username, password);
		Thread.sleep(2000);
		Assert.assertEquals(loginPage.getAlertNotification().getText(), loginPage.getAlertNotificationText());
	}
	
	@Test
	public void invalidPassLogin() throws InterruptedException {
		
		String username = excelCitac.getStringData("invalidPassword", 4, 6);
		String password = excelCitac.getStringData("invalidPassword", 5, 6);
		
		mainPage.clickSignIn();
		Thread.sleep(2000);
		
		loginPage.logIn(username, password);
		Thread.sleep(2000);
		Assert.assertEquals(loginPage.getAlertNotification().getText(), loginPage.getAlertNotificationText());
	}
	
	@Test
	public void noCredentialsLogin() throws InterruptedException {
		
		String username = "";
		String password = "";
		
		mainPage.clickSignIn();
		Thread.sleep(2000);
		
		loginPage.logIn(username, password);
		Thread.sleep(2000);
		Assert.assertEquals(loginPage.getAlertNotification().getText(), loginPage.noEmailNotification());
	}

	@AfterMethod
	public void afterTest() throws InterruptedException {
		driver.manage().deleteAllCookies();
		driver.navigate().refresh();
		Thread.sleep(2000);
	}
	
	
}
