package Sources;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AmazonSignIn {

	WebDriver driver;
	By title = By.className("title");
	
	By txtEmail = By.xpath("//*[@id='ap_email']");
	
	By txtPassword = By.xpath("//*[@id='ap_password']");
	
	By signInButtonVerify = By.xpath("//*[@id='a-autoid-0-announce']");
	
	@FindBy(xpath = "//*[@id='signInSubmit']")
	WebElement loginButton;
	
	
	public AmazonSignIn(WebDriver driver) {
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
		
		return driver.findElement(signInButtonVerify).getText();
		
	}
}
