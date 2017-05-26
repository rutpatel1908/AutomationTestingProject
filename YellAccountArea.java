package Sources;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class YellAccountArea {

    WebDriver driver;

    @FindBy(className = "title")
    WebElement title;
    
    

    @FindBy(xpath = "/html/body/div[2]/div[1]/div[2]/div/div/div/a[3]")
    WebElement createAccountButton;
    
    @FindBy(xpath = "/html/body/div[2]/div[1]/div[1]/div/div/div[2]/h2")
    WebElement getUsername;

    public YellAccountArea(WebDriver driver) {
        this.driver = driver;

        // initalising all the elements with @Findby
        PageFactory.initElements(driver, this);
    }

    public void clickLogOutButton() {
        driver.get(createAccountButton.getAttribute("href"));
    }

    public String getTitle() {
        return driver.getTitle();
    }
    
    public String getUsername() {
    	
    	return driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[1]/div/div/div[2]/h2")).getText();
    }
}
