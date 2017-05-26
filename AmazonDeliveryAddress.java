package Sources;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by Global InfoTech Dev on 24/05/2017.
 */
public class AmazonDeliveryAddress{

    WebDriver driver;

    @FindBy(className = "title")
    WebElement title;

    @FindBy(xpath = "//*[@id='address-book-entry-0']/div[2]/span/a")
    WebElement deliveryAddressButton;



    public AmazonDeliveryAddress(WebDriver driver) {
        this.driver = driver;

        // initalising all the elements with @Findby
        PageFactory.initElements(driver, this);
    }


    public String getTitle() {
        return driver.getTitle();
    }

    public void clickOnDeliveryAddressButton(){

        driver.get(deliveryAddressButton.getAttribute("href"));
        

    }
}
