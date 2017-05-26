package Tests;


import Sources.YellAccountArea;
import Sources.YellCreateAccount;
import Sources.YellHomepage;
import Sources.YellLogin;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.*;

/**
 * Created by Global InfoTech Dev on 25/05/2017.
 */
public class YellProjectTest {

    static WebDriver driver;

    YellHomepage homePage;
	YellLogin loginPage;
	YellCreateAccount newAccount;
	YellAccountArea accountArea;
    
    @Before
    public void setup() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ewomack\\workspace\\TestingProject\\Selenium\\Selenium\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://www.yell.com/");
    }

    @Test
    public void testHomepage() {

        homePage = new YellHomepage(driver);
        String homePageTitle = homePage.getTitle();
        assertEquals(homePageTitle, "Yell.com - the UK's leading online business directory");
        homePage.clickMyAccountLink();
        System.out.println("Processed to Login Page");

        loginPage = new YellLogin(driver);
        String loginPageTitle = loginPage.getTitle();
        assertNotSame(loginPageTitle, homePageTitle);
        loginPage.clickCreateAccountLink();
        System.out.println("Processed to Create Account");

        newAccount = new YellCreateAccount(driver);
        String createAccountTitle = newAccount.getTitle();
        assertNotSame(createAccountTitle, loginPageTitle);
        newAccount.setFirstName();
        newAccount.setLastName();
        newAccount.setEmail();
        newAccount.setPassword();
        newAccount.setConfirmPassword();
        newAccount.clickCreateAccountButton();

       
        accountArea = new YellAccountArea(driver);
        String accountAreaTitle = accountArea.getTitle();
        assertNotSame(accountAreaTitle, createAccountTitle);
        accountArea.clickLogOutButton();

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
