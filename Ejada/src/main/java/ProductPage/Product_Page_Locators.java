package ProductPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Product_Page_Locators {

    // Constructor
    private WebDriver driver;
    public Product_Page_Locators(WebDriver driver){
        this.driver = driver ;
    }

    // Locators

    private By addToCartButtonFirst = By.id("add-to-cart-sauce-labs-fleece-jacket");
    private By addToCartButtonSecond = By.id("add-to-cart-sauce-labs-backpack");
    private By cartButton = By.className("shopping_cart_link");

    //Actions

    public void addItemsToCart(){
        driver.findElement(addToCartButtonFirst).click();
        driver.findElement(addToCartButtonSecond).click();
    }

    public void accessCartPage(){

        driver.findElement(cartButton).click();
    }
}
