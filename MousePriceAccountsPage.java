package Sources;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class MousePriceAccountsPage {

	WebDriver driver;
	By title = By.className("title");
	
	@FindBy(xpath = "//*[@id='A1']")
	WebElement logOutButton;
	
	@FindBy(xpath = "//*[@id='A2']")
	WebElement accountSettingsButton;
	
	@FindBy(xpath = "//*[@id='BTSaveUserInfo']")
	WebElement saveAccountDetais;
	
	@FindBy(xpath = "//*[@id='tabSoldPrice']")
	WebElement valuationButton;
	
	By txtPassword = By.xpath("//*[@id='txtPassword']");
	By txtFirstName = By.xpath("//*[@id='txtFirstName']");
	By txtLastName = By.xpath("//*[@id='txtLastName']");
	By txtTelephone = By.xpath("//*[@id='txtTelephone']");
	By cmbUserType = By.xpath("//*[@id='cmbUserType']");
	By txtPostcode = By.xpath("//*[@id='txtPostCode']");
	By cmbAddress = By.xpath("//*[@id='cmbAddress']");
	
	
	public MousePriceAccountsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public void clickOnAccountSettings() {
		accountSettingsButton.click();
	}
	
	public String findAccountSettingsButton(){
		return accountSettingsButton.getText();
	}
	
	
	public void clickOnLogOut() {
		logOutButton.click();
	}
	
	public String findLogOutButton(){
		return logOutButton.getText();
	}
	
	public String findValuationButton(){
		return valuationButton.getText();
	}
	
	public void clickOnValutionButton() {
		valuationButton.click();
	}
	
	
	public void setPassword(String changePassword) {
		
		driver.findElement(txtPassword).clear();
		
		driver.findElement(txtPassword).sendKeys(changePassword);
	}
	
	public void setFirstName(String changeFirstName) {
		
		driver.findElement(txtFirstName).clear();
		driver.findElement(txtFirstName).sendKeys(changeFirstName);
	}
	
	public void setLastName(String changeLastName) {
		
		driver.findElement(txtLastName).clear();
		
		driver.findElement(txtLastName).sendKeys(changeLastName);
	}
	
	public void setTelephone(String changeTelephone) {
		
		driver.findElement(txtTelephone).clear();
		driver.findElement(txtTelephone).sendKeys(changeTelephone);
	}
	
	public void setUserType(int userTypeIndex) {
		

		Select oSelect = new Select(driver.findElement(cmbUserType));
 
		oSelect.selectByIndex(userTypeIndex);
	}
	
	public void setPostcode(String changePostcode) {
		
		driver.findElement(txtPostcode).clear();
		driver.findElement(txtPostcode).sendKeys(changePostcode);
	}

	public void setAddress(int addressIndex) {

		Select oSelect = new Select(driver.findElement(cmbAddress));
		
		oSelect.selectByIndex(addressIndex);

	}
	
	public void clickOnSave() {
		saveAccountDetais.click();
	}
	
	
	public String getTitle() {
		return driver.getTitle();
	}
}
