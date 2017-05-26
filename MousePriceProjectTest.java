package Tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import Sources.MousePriceAccountsPage;
import Sources.MousePriceHomepage;
import Sources.MousePriceSignIn;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MousePriceProjectTest {

	static WebDriver driver;

	MousePriceHomepage homePage;
	MousePriceSignIn loginPage;
	MousePriceAccountsPage accounts;
	
	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ewomack\\workspace\\TestingProject\\Selenium\\Selenium\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://www.mouseprice.com/");
	}
	
	@Test
	public void testHomepage() {

		homePage = new MousePriceHomepage(driver);
		String homePageTitle = homePage.getTitle();
		assertEquals(homePageTitle, "Land Registry Sold House Prices and Property Valuations – Mouseprice.com");
		homePage.clickSignInLink();
		System.out.println("Processed to Login Page");
		
		loginPage = new MousePriceSignIn(driver);
		String loginPageTitle = loginPage.getTitle();
		String findLoginButton = loginPage.findSigninButton();
		
		assertEquals(loginPageTitle, "Login - Mouseprice");
		assertEquals(findLoginButton, "Sign in");
		loginPage.setEmail("elitewarrior1908@gmail.com");
		loginPage.setPassword("rutpatel1");
		loginPage.clickOnSignIn();
		System.out.println("Logged in successfully");
		
		
		accounts = new MousePriceAccountsPage(driver);
		
		String accountsTitle = accounts.getTitle();
		assertEquals(accountsTitle, "Land Registry Sold House Prices and Property Valuations – Mouseprice.com");
		
		String findAccountsButton = accounts.findAccountSettingsButton();
		assertEquals(findAccountsButton, "Account settings");
		accounts.clickOnAccountSettings();
		
		
		String accountsPageTitle = accounts.getTitle();
		assertEquals(accountsPageTitle, "Account Details - Mouseprice");
		
		accounts.setFirstName("Elite");
		accounts.setLastName("Warrior");
		accounts.setPassword("rutpatel1");
		accounts.setTelephone("07598759566");
		accounts.setUserType(3);
		accounts.setPostcode("M50 2TJ");
		accounts.setAddress(82);
		
		accounts.clickOnSave();
		System.out.println("Account data updated successfully");
		
		//String findValuationButton = accounts.findValuationButton();
		//assertEquals(findValuationButton, "Sold prices & valuations");
		//accounts.clickOnValutionButton();
		
		
		String logout = accounts.findLogOutButton();
		assertEquals(logout, "Logout");
		accounts.clickOnLogOut();
		System.out.println("Logged out successfully");
	}

	@After
	public void tearDown() {
		try {
			driver.close();
		} catch (Exception ex) {
			System.out.println(ex.toString());
		}
	}
}
