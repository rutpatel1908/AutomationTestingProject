package Sources;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Random;

/**
 * Created by Global InfoTech Dev on 25/05/2017.
 */
public class LinkedInProfileArea {

    WebDriver driver;

    @FindBy(className = "title")
    WebElement title;

    @FindBy(css = ".sharing-share-box__post-button")
    WebElement postingButton;

    @FindBy(css = ".sharing-textarea__textarea--original.sharing-textarea__textarea--original")
    WebElement postMessage;

    public LinkedInProfileArea(WebDriver driver) {
        this.driver = driver;

        // initalising all the elements with @Findby
        PageFactory.initElements(driver, this);
    }

    public void openPostBox() {

      postingButton.click();

    }

    public void setPostMessage(){

      String[] facts = {

              "Sometimes I pretend I’m the Mayor of my kitchen and veto fish for dinner. ‘Too fishy’ is what I say! - By Albert Einstein",
              "Hello, 911? I think I just glued a Cabbage Patch doll to my penis. Her name is Addison Earlene. - By Shakespeare",
              "Are you a cop? Legally you have to tell me if you’re a cop. - By Albert Einstein",
              "While you’re thinking about it, get two of them. That way you’ll have a backup. - By Benjamin Franklin",
              "Hello, 911? I think I just glued a Cabbage Patch doll to my penis. Her name is Addison Earlene. - By Theodore Roosevelt",
              "While you’re thinking about it, get two of them. That way you’ll have a backup. - By Karl Marx",
              "Yeah I pronounce it ‘pasketti’. Why? Is there another way? - By Marie Curie",
              "They’re real and they’re spectacular. - By Benjamin Franklin",
              "While you’re thinking about it, get two of them. That way you’ll have a backup. - By Theodore Roosevelt",
              "Britney, will you accept this rose? - By Benjamin Franklin",
              "God, I’ve had the worst itch right at the top of my ass for like three days. Are you writing? Don’t write that. We’re not doing quotes yet. - By Karl Marx"
      };

        Random random = new Random();
        int index = random.nextInt(facts.length);

        postMessage.sendKeys(facts[index]);
    }

    public String getTitle() {
        return driver.getTitle();
    }

}