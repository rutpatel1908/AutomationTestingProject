package Sources;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AmazonProductDescription {

	WebDriver driver;

	@FindBy(className = "title")
	WebElement title;

	@FindBy(name = "submit.add-to-cart")
	WebElement addBasketButton;

	
	public AmazonProductDescription(WebDriver driver) {
		this.driver = driver;

		// initalising all the elements with @Findby
		PageFactory.initElements(driver, this);
	}
	

	public String getTitle() {
		return driver.getTitle();
	}
	
	public void clickOnAddBasket(){
		
		addBasketButton.click();
		
	}
	
	
}
