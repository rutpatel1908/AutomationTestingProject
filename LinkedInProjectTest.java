package Tests;

import Sources.LinkedInHomepage;
import Sources.LinkedInProfileArea;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;

/**
 * Created by Global InfoTech Dev on 25/05/2017.
 */
public class LinkedInProjectTest {

    static WebDriver driver;

    LinkedInHomepage homePage;
    LinkedInProfileArea profileArea;

    @Before
    public void setup() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ewomack\\workspace\\TestingProject\\Selenium\\Selenium\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.linkedin.com/");
    }

    @Test
    public void testHomepage() {

        homePage = new LinkedInHomepage(driver);
        String homePageTitle = homePage.getTitle();
        assertEquals(homePageTitle, "LinkedIn: Log In or Sign Up");
        homePage.setUsername();
        homePage.setPassword();
        homePage.clickSignInLink();
        System.out.println("Processed to Login Page");


        profileArea = new LinkedInProfileArea(driver);
        String profileAreaTitle = profileArea.getTitle();
        assertNotSame(profileAreaTitle, homePageTitle);
        profileArea.openPostBox();
        profileArea.setPostMessage();
        profileArea.openPostBox();
    }




}
