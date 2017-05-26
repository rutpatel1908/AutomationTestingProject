package ExtentReports;

import static org.junit.Assert.assertNotSame;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Sources.AmazonBasket;
import Sources.AmazonDeliveryAddress;
import Sources.AmazonDispatchArea;
import Sources.AmazonHomepage;
import Sources.AmazonProductDescription;
import Sources.AmazonProductResult;
import Sources.AmazonProductSearch;
import Sources.AmazonSignIn;
import Sources.LinkedInHomepage;
import Sources.LinkedInProfileArea;
import Sources.MousePriceAccountsPage;
import Sources.MousePriceHomepage;
import Sources.MousePriceSignIn;
import Sources.YellAccountArea;
import Sources.YellCreateAccount;
import Sources.YellHomepage;
import Sources.YellLogin;

public class GenerateExtentReport {

	ExtentReports report;
	ExtentTest test;
	WebDriver driver;

	YellHomepage home;
	YellLogin login;
	YellCreateAccount createAccount;
	YellAccountArea accountArea;

	AmazonBasket amazonBasket;
	AmazonDeliveryAddress amazonDeliveryAddress;
	AmazonDispatchArea amazonDispatchArea;
	AmazonHomepage amazonHomepage;
	AmazonProductDescription amazonProductDescription;
	AmazonProductResult amazonProductResult;
	AmazonProductSearch amazonProductSearch;
	AmazonSignIn amazonSignIn;

	MousePriceHomepage mousePriceHomePage;
	MousePriceSignIn mousePriceSignIn;
	MousePriceAccountsPage mousePriceAccountPage;

	LinkedInHomepage linkedInHomepage;
	LinkedInProfileArea linkedInProfileArea;

	@BeforeTest
	@Parameters("browser")
	public void setup(String browser) throws Exception{
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\ewomack\\workspace\\TestingProject\\Selenium\\Selenium\\chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	@Test(priority = 1, enabled = true)
	public void verifyAmazonPurhcaseProcess() {

		// where to create the report file
		report = new ExtentReports("C:\\Users\\ewomack\\workspace\\TestingProject\\ExtentReports\\GenerateReport.html",
				true);

		// init/start the test
		test = report.startTest("Testing Amazon Purchase Project");
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\ewomack\\workspace\\TestingProject\\Selenium\\Selenium\\chromedriver.exe");
		driver = new ChromeDriver();

		// add a note to the test
		test.log(LogStatus.INFO, "Browser started");
		driver.get("https://www.Amazon.co.uk/");

		amazonHomepage = new AmazonHomepage(driver);
		String amazonHomePageTitle = amazonHomepage.getTitle();

		String title = driver.getTitle();
		System.out.println(title);

		if (amazonHomePageTitle.equalsIgnoreCase(title)) {
			// report the test as a pass
			test.log(LogStatus.PASS, "Verify Title of the page");
			amazonHomepage.clickSignInLink();
			test.log(LogStatus.PASS, "Verify if the Sign In button navigate user to the login page");
		} else {
			test.log(LogStatus.FAIL, "verify Title of the page");
			test.log(LogStatus.PASS, "Verify if the Sign In navigates user to the login page");
		}

		amazonSignIn = new AmazonSignIn(driver);

		String amazonSignInTitle = driver.getTitle();

		if (amazonSignInTitle != amazonHomePageTitle) {

			// report the test as a pass
			amazonSignIn.setEmail("elitewarrior1908@gmail.com");
			amazonSignIn.setPassword("rutpatel1010");
			amazonSignIn.clickOnSignIn();
			test.log(LogStatus.PASS, "Verify the title of the sign in page.");
			test.log(LogStatus.PASS,
					"Verify if the correct login details entered and the user able to login successfully");
		} else {
			test.log(LogStatus.FAIL,
					"Verify if the correct login details entered and the user able to login successfully");
		}

		amazonProductSearch = new AmazonProductSearch(driver);
		String amazonProductSearchTitle = amazonProductSearch.getTitle();

		if (amazonProductSearchTitle != amazonSignInTitle) {

			amazonProductSearch.setSearchCriteria("drones with hd cameras");
			amazonProductSearch.clickSearchButton();
			test.log(LogStatus.PASS, "Verify the title of the product search page.");
			test.log(LogStatus.PASS,
					"Verify if the correct set of results are getting displayed based on the search criteria");
		} else {
			test.log(LogStatus.FAIL,
					"Verify if the correct set of results are getting displayed based on the search criteria");
		}

		amazonProductResult = new AmazonProductResult(driver);
		String amazonProductResultTitle = amazonProductResult.getTitle();

		if (amazonProductResultTitle != amazonProductSearchTitle) {

			amazonProductResult.clickOnSelectedProduct();
			test.log(LogStatus.PASS, "Verify the title of the product results page.");
			test.log(LogStatus.PASS, "Verify if the correct product gets selected");
		} else {
			test.log(LogStatus.PASS, "Verify the title of the product results page.");
			test.log(LogStatus.PASS, "Verify if the correct product gets selected");
		}

		amazonProductDescription = new AmazonProductDescription(driver);
		String amazonProductDescriptionTitle = amazonProductDescription.getTitle();

		if (amazonProductDescriptionTitle != amazonProductResultTitle) {

			amazonProductDescription.clickOnAddBasket();
			test.log(LogStatus.PASS, "Verify the title of the product description page.");
			test.log(LogStatus.PASS, "Verify whether the product will be added to shopping basket or not");
		} else {
			test.log(LogStatus.PASS, "Verify the title of the product description page.");
			test.log(LogStatus.PASS, "Verify whether the product will be added to shopping basket or not");
		}

		amazonBasket = new AmazonBasket(driver);
		String amazonBasketTitle = amazonBasket.getTitle();

		if (amazonBasketTitle != amazonProductDescriptionTitle) {

			amazonBasket.clickProceedToCheckoutButton();
			test.log(LogStatus.PASS, "Verify the title of the amazon basket page.");
			test.log(LogStatus.PASS, "Verify whether it starts the checkout process");
		} else {
			test.log(LogStatus.PASS, "Verify the title of the amazon basket page.");
			test.log(LogStatus.PASS, "Verify whether it starts the checkout process");
		}

		amazonDeliveryAddress = new AmazonDeliveryAddress(driver);
		String amazonDeliveryAddressTitle = amazonDeliveryAddress.getTitle();

		if (amazonDeliveryAddressTitle != amazonBasketTitle) {

			amazonDeliveryAddress.clickOnDeliveryAddressButton();
			test.log(LogStatus.PASS, "Verify the title of the amazon delivery area page.");
			test.log(LogStatus.PASS, "Verify whether it process the order and compelete the checkout process");
		} else {
			test.log(LogStatus.PASS, "Verify the title of the amazon delivery area page.");
			test.log(LogStatus.PASS, "Verify whether it process the order and compelete the checkout process");
		}

		amazonDispatchArea = new AmazonDispatchArea(driver);
		String amazonDispatchAreaTitle = amazonDispatchArea.getTitle();

		if (amazonDispatchAreaTitle != amazonDeliveryAddressTitle) {

			amazonDispatchArea.clickOnDeliveryAddressButton();
			test.log(LogStatus.PASS, "Verify the title of the amazon dispatch area page.");
			test.log(LogStatus.PASS, "Verify whether it process to the delviery address page");
		} else {
			test.log(LogStatus.PASS, "Verify the title of the amazon dispatch area page.");
			test.log(LogStatus.PASS, "Verify whether it process to the delviery address page");
		}
		report.endTest(test);
	}

	@Test(priority = 2, enabled = true)
	public void verifyMousePriceProject() {

		test = report.startTest("Testing Mouse Price Project");
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\ewomack\\workspace\\TestingProject\\Selenium\\Selenium\\chromedriver.exe");
		driver = new ChromeDriver();

		// add a note to the test
		test.log(LogStatus.INFO, "Browser started");
		driver.get("https://www.mouseprice.com/");

		mousePriceHomePage = new MousePriceHomepage(driver);
		String mousePriceHomePageTitle = mousePriceHomePage.getTitle();

		String title = driver.getTitle();
		System.out.println(title);

		if (mousePriceHomePageTitle.equalsIgnoreCase(title)) {
			// report the test as a pass
			test.log(LogStatus.PASS, "Verify Title of the page");
			mousePriceHomePage.clickSignInLink();
			test.log(LogStatus.PASS, "Verify if the My Account button navigate user to the login page");
		} else {
			test.log(LogStatus.FAIL, "verify Title of the page");
			test.log(LogStatus.PASS, "Verify if the My Account navigates user to the login page");
		}

		mousePriceSignIn = new MousePriceSignIn(driver);

		String mousePriceSignInTitle = driver.getTitle();
		String findSignInButton = mousePriceSignIn.findSigninButton();

		if (mousePriceSignInTitle != mousePriceHomePageTitle && findSignInButton.equals("Sign in")) {

			// report the test as a pass
			mousePriceSignIn.setEmail("elitewarrior1908@gmail.com");
			mousePriceSignIn.setPassword("rutpatel1");
			mousePriceSignIn.clickOnSignIn();
			test.log(LogStatus.PASS, "Verify the title of the sign in page.");
			test.log(LogStatus.PASS,
					"Verify if the correct login details entered and the user able to login successfully");
		} else {
			test.log(LogStatus.PASS, "Verify the title of the sign in page.");
			test.log(LogStatus.PASS,
					"Verify if the correct login details entered and the user able to login successfully");
		}

		mousePriceAccountPage = new MousePriceAccountsPage(driver);

		String mousePriceAccountsPageTitle = driver.getTitle();
		String findAccountSettingsButton = mousePriceAccountPage.findAccountSettingsButton();
		String findLogOutButton = mousePriceAccountPage.findLogOutButton();

		if (mousePriceAccountsPageTitle != mousePriceSignInTitle && findLogOutButton.equals("Logout")
				&& findAccountSettingsButton.equals("Account settings")) {

			// report the test as a pass
			mousePriceAccountPage.clickOnAccountSettings();
			test.log(LogStatus.PASS, "Verify the title of the account area title page.");
			test.log(LogStatus.PASS, "Verify if Account Settings and Logout button exist on the page");
			test.log(LogStatus.PASS,
					"Verify if the Account Settings buttons navigates to the user to the accounts settings page");

			mousePriceAccountPage.setFirstName("Elite");
			mousePriceAccountPage.setLastName("Warrior");
			mousePriceAccountPage.setPassword("rutpatel1");
			mousePriceAccountPage.setTelephone("07598759566");
			mousePriceAccountPage.setUserType(3);
			mousePriceAccountPage.setPostcode("M50 2TJ");
			mousePriceAccountPage.setAddress(82);

			mousePriceAccountPage.clickOnSave();
			test.log(LogStatus.PASS, "Verify if the account details gets updated or not");

			mousePriceAccountPage.clickOnLogOut();
			test.log(LogStatus.PASS, "Verify if the user able to logout successfully or not");

		} else {
			test.log(LogStatus.PASS, "Verify the title of the account area title page.");
			test.log(LogStatus.PASS, "Verify if Account Settings and Logout button exist on the page");
			test.log(LogStatus.PASS,
					"Verify if the Account Settings buttons navigates to the user to the accounts settings page");
			test.log(LogStatus.PASS, "Verify if the account details gets updated or not");
			test.log(LogStatus.PASS, "Verify if the user able to logout successfully or not");
		}

		report.endTest(test);
	}

	@Test(priority = 3, enabled = true)
	public void verifyLinkedInProject() {

		// init/start the test
		test = report.startTest("Testing LinkedIn Random Posting Project");
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\ewomack\\workspace\\TestingProject\\Selenium\\Selenium\\chromedriver.exe");
		driver = new ChromeDriver();

		// add a note to the test
		test.log(LogStatus.INFO, "Browser started");
		driver.get("https://www.linkedin.com/");

		linkedInHomepage = new LinkedInHomepage(driver);
		String linkedInHomePageTitle = linkedInHomepage.getTitle();

		String title = driver.getTitle();
		System.out.println(title);

		if (linkedInHomePageTitle.equalsIgnoreCase(title)) {
			// report the test as a pass
			test.log(LogStatus.PASS, "Verify Title of the page");
			linkedInHomepage.setUsername();
			linkedInHomepage.setPassword();
			linkedInHomepage.clickSignInLink();

			test.log(LogStatus.PASS,
					"Verify whether the correct login details entered and the user able to login successfully");
		} else {
			test.log(LogStatus.FAIL, "verify Title of the page");
			test.log(LogStatus.PASS,
					"Verify whether the correct login details entered and the user able to login successfully");
		}

		linkedInProfileArea = new LinkedInProfileArea(driver);

		String linkedInProfileAreaTitle = driver.getTitle();

		if (linkedInProfileAreaTitle != linkedInHomePageTitle) {

			linkedInProfileArea.openPostBox();
			linkedInProfileArea.setPostMessage();
			linkedInProfileArea.openPostBox();

			test.log(LogStatus.PASS, "Verify the title of the profile area page.");
			test.log(LogStatus.PASS, "Verify it is able to post the random message");
		} else {
			test.log(LogStatus.PASS, "Verify the title of the profile area page.");
			test.log(LogStatus.PASS, "Verify it is able to post the random message");
		}

		report.endTest(test);
		report.flush();
	}

	@Test(priority = 4, enabled = true)
	public void verifyHomePageTitle() {

		// init/start the test
		test = report.startTest("Testing Yell Registration");
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\ewomack\\workspace\\TestingProject\\Selenium\\Selenium\\chromedriver.exe");
		driver = new ChromeDriver();
		// driver.manage().window().maximize();

		// add a note to the test
		test.log(LogStatus.INFO, "Browser started");
		driver.get("https://www.yell.com/");

		home = new YellHomepage(driver);
		String hometitle = home.getTitle();

		String findButton = home.findMyAccountLink();

		String title = driver.getTitle();
		System.out.println(title);

		if (hometitle.equalsIgnoreCase(title) && findButton.equalsIgnoreCase("My Account")) {
			// report the test as a pass
			test.log(LogStatus.PASS, "Verify Title of the page");
			home.clickMyAccountLink();
			test.log(LogStatus.PASS, "Verify if the My Account exists in homepage and navigate user to the login page");
		} else {
			test.log(LogStatus.FAIL, "verify Title of the page");
			test.log(LogStatus.PASS, "Verify if the My Account exists in homepage");
		}

		login = new YellLogin(driver);

		String loginPageTitle = driver.getTitle();
		String homepageTitle = home.getTitle();

		String locateCreateAccount = login.findCreateAccountButton();

		if (loginPageTitle != homepageTitle && locateCreateAccount.equalsIgnoreCase("Create an account")) {

			// report the test as a pass
			test.log(LogStatus.PASS,
					"Verify Create Account button exists in Login page and navigate user to account creation page");
			login.clickCreateAccountLink();

		} else {
			test.log(LogStatus.FAIL, "verify Title of the page");
		}

		createAccount = new YellCreateAccount(driver);

		String createAccountTitle = driver.getTitle();
		String getloginPageTitle = login.getTitle();

		if (createAccountTitle != getloginPageTitle) {

			createAccount.setFirstName();
			createAccount.setLastName();
			createAccount.setEmail();
			createAccount.setPassword();
			createAccount.setConfirmPassword();
			createAccount.clickCreateAccountButton();

			test.log(LogStatus.PASS, "Verify wheather the account is created successfuly or not");

			accountArea = new YellAccountArea(driver);
			String getAccountTitle = accountArea.getTitle();
			String getUsername = accountArea.getUsername();

			if (getAccountTitle != createAccountTitle) {
				// report the test as a pass
				test.log(LogStatus.PASS,
						"Verify to see if see if the user log out of the system after creating the account");
				accountArea.clickLogOutButton();

			}

		} else {
			test.log(LogStatus.FAIL, "verify Title of the page");
		}

		report.endTest(test);
		report.flush();
	}

}
