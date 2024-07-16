package Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import settings.configProperties;

public class baseTest {

    public WebDriver driver;

    @Parameters("browser")
    @BeforeMethod
    public void setUp(String browserName) {

        if (browserName.equalsIgnoreCase("chrome")){
            //ChromeOptions opt = new ChromeOptions();
            //opt.addArguments("--headless");
            driver = new ChromeDriver();

        }
        else if(browserName.equalsIgnoreCase("firefox")){
            //FirefoxOptions options = new FirefoxOptions();
            //options.addArguments("--headless");
            driver = new FirefoxDriver();

        }

        String baseUrl = configProperties.getBaseUrl();
        driver.get(baseUrl);
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
