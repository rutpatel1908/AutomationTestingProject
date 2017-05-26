package Sources;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Random;

/**
 * Created by Global InfoTech Dev on 25/05/2017.
 */
public class YellCreateAccount {

    WebDriver driver;

    @FindBy(className = "title")
    WebElement title;

    @FindBy(xpath = "//*[@id='register']")
    WebElement createAccountButton;

    By firstName = By.xpath("//*[@id='firstName']");
    By lastName = By.xpath("//*[@id='lastName']");
    By password = By.xpath("//*[@id='password']");
    By emailAddress = By.xpath("//*[@id='emailAddress']");
    By confirmPassword = By.xpath("//*[@id='passwordConfirmation']");

    public YellCreateAccount(WebDriver driver) {
        this.driver = driver;

        // initalising all the elements with @Findby
        PageFactory.initElements(driver, this);
    }

    public void clickCreateAccountButton() {
        createAccountButton.click();
    }

    public String getTitle() {
        return driver.getTitle();
    }



    public void setFirstName() {

        String generateFirstName[] = {"Albin", "Levi", "Adedayo", "Petia", "Jack", "John", "Anna", "Amy", "Julia", "Jack", "Craig", "Steve"};



        driver.findElement(firstName).clear();
        driver.findElement(firstName).sendKeys(generateFirstName[new Random().nextInt(generateFirstName.length)]);
    }

    public void setLastName() {

        String generateLastName[] = {"Savage", "Vargas", "Watson", "Lee", "Jackson", "Clark", "Johnson", "Starc", "Warner", "Southee"};
        driver.findElement(lastName).clear();

        driver.findElement(lastName).sendKeys(generateLastName[new Random().nextInt(generateLastName.length)]);;
    }

    public void setPassword() {

        driver.findElement(password).clear();

        driver.findElement(password).sendKeys("testing123");
    }


    public void setEmail() {

        Random randomGenerator = new Random();
        int randomInt = randomGenerator.nextInt(1000);

        driver.findElement(emailAddress).clear();

        driver.findElement(emailAddress).sendKeys("username"+ randomInt +"@gmail.com");
    }


    public void setConfirmPassword() {

        driver.findElement(confirmPassword).clear();

        driver.findElement(confirmPassword).sendKeys("testing123");
    }

}
