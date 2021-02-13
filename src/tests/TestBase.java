package tests;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import pages.AddressPage;
import pages.LoginPage;
import pages.MainPage;
import pages.MyAccountPage;
import pages.MyAddressesPage;
import pages.MyInformationPage;
import pages.MyWishlistsPage;



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
	MyInformationPage myInformationPage;
	MyWishlistsPage myWishlistsPage;
	

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
		this.myInformationPage = new MyInformationPage(js, driver);
		this.myWishlistsPage = new MyWishlistsPage(driver);
		
		driver.manage().window().maximize();
	}
	

	
	@AfterClass
	public void posleKlase() {
		System.out.println("Kraj programa");
		driver.close();
	}
	
	public void logInSuccessfully() throws InterruptedException {
		//		logInTests.logInCorrect();
		String username = excelCitac.getData("Login form", 4, 6);
		String password = excelCitac.getData("Login form", 5, 6);
		
		mainPage.clickSignIn();
		Thread.sleep(2000);
		loginPage.logIn(username, password);

		Thread.sleep(2000);
	}
	
}
