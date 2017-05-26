package Sources;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AmazonProductSearch {

	WebDriver driver;

	@FindBy(className = "title")
	WebElement title;

	@FindBy(xpath = "//*[@id='twotabsearchtextbox']")
	WebElement searchBox;
	
	
	@FindBy(xpath = "//*[@id='nav-search']/form/div[2]/div/input")
	WebElement searchButton;
	
	

	public AmazonProductSearch(WebDriver driver) {
		this.driver = driver;

		// initalising all the elements with @Findby
		PageFactory.initElements(driver, this);
	}

	public void clickSearchButton() {
		searchButton.click();
	}
	
	
	public void setSearchCriteria(String searchBoxCriteria) {
		
		searchBox.clear();
		searchBox.sendKeys(searchBoxCriteria);
	}
	
	public String getTitle() {
		return driver.getTitle();
	}
}