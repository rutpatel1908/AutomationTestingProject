package Sources;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Global InfoTech Dev on 25/05/2017.
 */
public class YellLogin {

    WebDriver driver;

    @FindBy(className = "title")
    WebElement title;

    @FindBy(xpath = "//*[@id='content']/div/div[2]/div/ul[2]/li/a")
    WebElement createAccountButton;

    public YellLogin(WebDriver driver) {
        this.driver = driver;

        // initalising all the elements with @Findby
        PageFactory.initElements(driver, this);
    }

    public void clickCreateAccountLink() {
        driver.get(createAccountButton.getAttribute("href"));
    }
    
    public String findCreateAccountButton(){
		
		return driver.findElement(By.xpath("//*[@id='content']/div/div[2]/div/ul[2]/li/a")).getText();
		
	}

    public String getTitle() {
        return driver.getTitle();
    }
}