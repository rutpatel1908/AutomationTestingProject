package Sources;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Global InfoTech Dev on 25/05/2017.
 */
public class YellHomepage {

    WebDriver driver;

    @FindBy(className = "title")
    WebElement title;

    @FindBy(xpath = "/html/body/div[1]/div/div/div[1]/div[2]/a")
    WebElement myAccountLink;

    public YellHomepage(WebDriver driver) {
        this.driver = driver;

        // initalising all the elements with @Findby
        PageFactory.initElements(driver, this);
    }

    public void clickMyAccountLink() {
        driver.get(myAccountLink.getAttribute("href"));
    }
    
    public String findMyAccountLink(){
    	
    	return driver.findElement(By.xpath("/html/body/div[1]/div/div/div[1]/div[2]/a")).getText();
    }

    public String getTitle() {
        return driver.getTitle();
    }
}
