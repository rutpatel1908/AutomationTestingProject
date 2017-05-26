package Sources;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Global InfoTech Dev on 25/05/2017.
 */
public class LinkedInHomepage {

    WebDriver driver;

    @FindBy(className = "title")
    WebElement title;

    @FindBy(xpath = "//*[@id='login-submit']")
    WebElement loginButton;

    By username = By.xpath("//*[@id='login-email']");
    By password = By.xpath("//*[@id='login-password']");

    public LinkedInHomepage(WebDriver driver) {
        this.driver = driver;

        // initalising all the elements with @Findby
        PageFactory.initElements(driver, this);
    }

    public void clickSignInLink() {
       loginButton.click();
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public void setUsername() {

        driver.findElement(username).clear();
        driver.findElement(username).sendKeys("elitewarrior1908@gmail.com");
    }

    public void setPassword() {

        driver.findElement(password).clear();
        driver.findElement(password).sendKeys("rutpatel1010");
    }
}

