package Sources;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class AmazonProductResult {

	WebDriver driver;

	@FindBy(className = "title")
	WebElement title;

	@FindBy(xpath = "//*[@id='result_2']/div/div/div/div[2]/div[1]/div[1]/a")
	WebElement productLink;
	
	public AmazonProductResult(WebDriver driver) {
		this.driver = driver;

		// initalising all the elements with @Findby
		PageFactory.initElements(driver, this);
	}

	public String getTitle() {
		return driver.getTitle();
	}
	
	
	public void clickOnSelectedProduct(){
		
		driver.get(productLink.getAttribute("href"));
		
	}
	
	
}