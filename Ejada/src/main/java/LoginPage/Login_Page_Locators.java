package LoginPage;
import org.openqa.selenium.*;

public class Login_Page_Locators {

    // Constructor
    private WebDriver driver;
    public Login_Page_Locators(WebDriver driver){
        this.driver = driver ;
    }

    // Locators

    private By userNameField = By.id("user-name");
    private By passwordField = By.id("password");
    private By loginButton = By.id("login-button");

    //Actions

    public void loginSuccessfully(String userName , String passWord){
        driver.findElement(userNameField).sendKeys(userName);
        driver.findElement(passwordField).sendKeys(passWord);
        driver.findElement(loginButton).click();
    }

}
