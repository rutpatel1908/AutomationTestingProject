package Sources;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MousePriceSignIn {

	WebDriver driver;
	By title = By.className("title");
	
	By txtEmail = By.xpath("//*[@id='txtEmail']");
	
	By txtPassword = By.xpath("//*[@id='txtPassword']");
	
	@FindBy(xpath = "//*[@id='cmdLogin']")
	WebElement loginButton;
	
	
	public MousePriceSignIn(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void setEmail(String email) {
		driver.findElement(txtEmail).sendKeys(email);
	}
	
	public void setPassword(String password) {
		driver.findElement(txtPassword).sendKeys(password);
	}
	
	public void clickOnSignIn() {
		loginButton.click();
	}
	
	public String getTitle() {
		return driver.getTitle();
	}
	
	public String findSigninButton(){
		
		return loginButton.getAttribute("value");
		
	}
}
