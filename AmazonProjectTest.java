package Tests;

import Sources.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;



public class AmazonProjectTest {

	static WebDriver driver;

	AmazonHomepage homePage;
	AmazonSignIn loginPage;
	AmazonProductSearch productSearch;
	AmazonProductResult productResult;
	AmazonProductDescription productDescription;
	AmazonBasket productBasket;
	AmazonDeliveryAddress deliveryAddress;
	AmazonDispatchArea dispatchArea;
	
	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ewomack\\workspace\\TestingProject\\Selenium\\Selenium\\chromedriver.exe");
		driver = new ChromeDriver();
		
	}
	
	@Test
	public void testHomepage() {
		
		driver.get("http://www.amazon.co.uk/");
		
		homePage = new AmazonHomepage(driver);
		String homePageTitle = homePage.getTitle();
		assertEquals(homePageTitle, "Amazon.co.uk: Low Prices in Electronics, Books, Sports Equipment & more");
		homePage.clickSignInLink();
		System.out.println("Processed to Login Page");
		
		loginPage = new AmazonSignIn(driver);
		String loginPageTitle = loginPage.getTitle();
		String findLoginButton = loginPage.findSigninButton();
		
		assertNotSame(loginPageTitle,homePageTitle);
		assertEquals(findLoginButton, "Sign in");
		loginPage.setEmail("elitewarrior1908@gmail.com");
		loginPage.setPassword("rutpatel1010");
		loginPage.clickOnSignIn();
		System.out.println("Logged in successfully");
		
		
		productSearch = new AmazonProductSearch(driver);
		String productSearchTitle = productSearch.getTitle();
		assertNotSame(productSearchTitle,loginPageTitle);
		System.out.println("Product Search Executed");
		productSearch.setSearchCriteria("drones with hd cameras");
		productSearch.clickSearchButton();
		
		productResult = new AmazonProductResult(driver);
		String resultsPageTitle = productResult.getTitle();
		assertNotSame(resultsPageTitle,productSearchTitle);
		System.out.println("Product Results Displayed");
		productResult.clickOnSelectedProduct();
		System.out.println("Product Selected");
		
		productDescription = new AmazonProductDescription(driver);
		String productDescriptionTitle = productDescription.getTitle();
		assertNotSame(productDescriptionTitle,resultsPageTitle);
		System.out.println("Product Results Displayed");
		productDescription.clickOnAddBasket();
		System.out.println("Product Selected");
		
		productBasket = new AmazonBasket(driver);
		String productBasketTitle = productBasket.getTitle();
		assertNotSame(productBasketTitle, productDescriptionTitle);
		productBasket.clickProceedToCheckoutButton();
		System.out.println("Checkout");
		
		deliveryAddress = new AmazonDeliveryAddress(driver);
		String deliveryAddressTitle = deliveryAddress.getTitle();
		assertNotSame(deliveryAddressTitle, productBasketTitle);
		deliveryAddress.clickOnDeliveryAddressButton();
		System.out.println("Delivery Address Entered");
		
		dispatchArea = new AmazonDispatchArea(driver);
		String dispatchAreaTitle = dispatchArea.getTitle();
		assertNotSame(dispatchAreaTitle, deliveryAddressTitle);
		dispatchArea.clickOnDeliveryAddressButton();
		System.out.println("Product Checkout Successful. Cant continue");
		
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
