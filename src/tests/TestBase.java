package tests;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import pages.AddressPage;
import pages.LoginPage;
import pages.MainPage;
import pages.MyAccountPage;
import pages.MyAddressesPage;


public class TestBase {
	
	WebDriver driver;
	JavascriptExecutor js;
	LoginPage loginPage;
	ExcelCitac excelCitac;
	MainPage mainPage;
	MyAccountPage myAccountPage;
	LogInTests logInTests;
	AddressTests addressTests;
	MyAddressesPage myAddressesPage;
	AddressPage addressPage;

	@BeforeClass
	public void preKlase() throws IOException, InterruptedException {
		System.setProperty("webdriver.chrome.driver",
							"driver-lib\\chromedriver.exe");
		
		this.driver = new ChromeDriver();
		this.loginPage = new LoginPage(driver);
		this.mainPage = new MainPage(driver);
		this.myAccountPage = new MyAccountPage(driver);
		this.myAddressesPage = new MyAddressesPage(js, driver);
		this.excelCitac = new ExcelCitac("data/SeleniumProject.xlsx");
		this.logInTests = new LogInTests();
		this.addressTests = new AddressTests();
		this.addressPage = new AddressPage(js, driver);
		
		driver.manage().window().maximize();
	}
	

	
	@AfterClass
	public void posleKlase() {
		System.out.println("Kraj programa");
		driver.close();
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
