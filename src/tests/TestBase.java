package tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import pages.LoginPage;
import pages.MainPage;
import pages.MyAccountPage;


public class TestBase {
	
	WebDriver driver;
	LoginPage loginPage;
	ExcelCitac excelCitac;
	MainPage mainPage;
	MyAccountPage myAccountPage;
	LogInTests logInTests;
	AddressTests addressTests;

	@BeforeClass
	public void preKlase() throws IOException, InterruptedException {
		System.setProperty("webdriver.chrome.driver",
							"driver-lib\\chromedriver.exe");
		
		this.driver = new ChromeDriver();
		this.loginPage = new LoginPage(driver);
		this.mainPage = new MainPage(driver);
		this.myAccountPage = new MyAccountPage(driver);
		this.excelCitac = new ExcelCitac("data/SeleniumProject.xlsx");
		this.logInTests = new LogInTests();
		this.addressTests = new AddressTests();
		
		driver.manage().window().maximize();
	}
	
	@BeforeMethod
	public void setup() throws InterruptedException {
		driver.navigate().to("http://automationpractice.com/index.php");
		Thread.sleep(2000);
	}
	
	@AfterMethod
	public void afterTest() throws InterruptedException {
		driver.manage().deleteAllCookies();
		driver.navigate().refresh();
		Thread.sleep(2000);
	}
	
	@AfterClass
	public void posleKlase() {
		System.out.println("Kraj programa");
		driver.close();
	}
	
}
