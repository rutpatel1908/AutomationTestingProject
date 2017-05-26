package Sources;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MousePriceHomepage {

	WebDriver driver;

	@FindBy(className = "title")
	WebElement title;

	@FindBy(xpath = "//*[@id='form1']/div[4]/div/ul/li[1]/a")
	WebElement signInLink;

	public MousePriceHomepage(WebDriver driver) {
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
