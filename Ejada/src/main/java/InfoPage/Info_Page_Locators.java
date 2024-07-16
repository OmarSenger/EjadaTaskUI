package InfoPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Info_Page_Locators {

    // Constructor
    private WebDriver driver;
    public Info_Page_Locators(WebDriver driver){
        this.driver = driver ;
    }

    // Locators

    private By firstNameField = By.id("first-name");
    private By lastNameField = By.id("last-name");
    private By zipCodeField = By.id("postal-code");
    private By continueButton = By.id("continue");

    //Actions

    public void infoPageAction(String firstName , String lastName , String code){
        driver.findElement(firstNameField).sendKeys(firstName);
        driver.findElement(lastNameField).sendKeys(lastName);
        driver.findElement(zipCodeField).sendKeys(code);
        driver.findElement(continueButton).click();

    }
}
