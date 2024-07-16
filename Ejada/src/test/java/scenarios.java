import Base.baseTest;
import InfoPage.Info_Page_Locators;
import LoginPage.Login_Page_Locators;
import ProductPage.Product_Page_Locators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class scenarios extends baseTest {

    Login_Page_Locators login_page;
    Product_Page_Locators product_page;
    Info_Page_Locators info_page;

    @Test
    public void ScenarioOne() throws InterruptedException {

        login_page = new  Login_Page_Locators(driver);
        login_page.loginSuccessfully("standard_user2","secret_sauce");
        Thread.sleep(2000);
        String errorMessage = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[1]/div/div/form/div[3]")).getText();
        Assert.assertEquals(errorMessage,"Epic sadface: Username and password do not match any user in this service");


    }


    @Test(priority = 1)
    public void ScenarioTwo() throws InterruptedException {

        login_page = new  Login_Page_Locators(driver);
        product_page = new  Product_Page_Locators(driver);
        info_page = new  Info_Page_Locators(driver);
        login_page.loginSuccessfully("standard_user","secret_sauce");
        String currentUrl = driver.getCurrentUrl();
        String expectedUrl = "https://www.saucedemo.com/inventory.html";
        Assert.assertEquals(currentUrl,expectedUrl);
        product_page.addItemsToCart();
        product_page.accessCartPage();
        String cartURL = driver.getCurrentUrl();
        String expURL = "https://www.saucedemo.com/cart.html";
        Assert.assertEquals(cartURL,expURL);
        Thread.sleep(2000);
        WebElement firstItem = driver.findElement(By.cssSelector("#item_5_title_link > div"));
        Assert.assertTrue(firstItem.isDisplayed());
        WebElement secItem = driver.findElement(By.cssSelector("#item_4_title_link > div"));
        Assert.assertTrue(secItem.isDisplayed());
        driver.findElement(By.id("checkout")).click();
        info_page.infoPageAction("Omar","Senger","123");
        String overviewURL = driver.getCurrentUrl();
        Assert.assertEquals(overviewURL,"https://www.saucedemo.com/checkout-step-two.html");
        String itemTotal = driver.findElement(By.className("summary_subtotal_label")).getText();
        System.out.println(itemTotal);
        driver.findElement(By.id("finish")).click();
        String firstText = driver.findElement(By.cssSelector("#checkout_complete_container > h2")).getText();
        Assert.assertEquals(firstText,"Thank you for your order!");
        String secText = driver.findElement(By.cssSelector("#checkout_complete_container > div")).getText();
        Assert.assertEquals(secText,"Your order has been dispatched, and will arrive just as fast as the pony can get there!");

    }

}
