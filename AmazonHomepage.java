package Sources;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AmazonHomepage {

	WebDriver driver;

	@FindBy(className = "title")
	WebElement title;

	@FindBy(xpath = "//*[@id='nav-link-yourAccount']")
	WebElement signInLink;

	public AmazonHomepage(WebDriver driver) {
		this.driver = driver;

		// initalising all the elements with @Findby
		PageFactory.initElements(driver, this);
	}

	public void clickSignInLink() {
		driver.get(signInLink.getAttribute("href"));
	}

	public String getTitle() {
		return driver.getTitle();
	}
}
