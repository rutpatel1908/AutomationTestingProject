package Sources;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Global InfoTech Dev on 24/05/2017.
 */
public class AmazonBasket{

    WebDriver driver;

    @FindBy(className = "title")
    WebElement title;

    @FindBy(id = "hlb-ptc-btn-native")
    WebElement proceedToCheckoutButton;



    public AmazonBasket(WebDriver driver) {
        this.driver = driver;

        // initalising all the elements with @Findby
        PageFactory.initElements(driver, this);
    }


    public String getTitle() {
        return driver.getTitle();
    }

    public void clickProceedToCheckoutButton(){

        driver.get(proceedToCheckoutButton.getAttribute("href"));
        

    }
}
