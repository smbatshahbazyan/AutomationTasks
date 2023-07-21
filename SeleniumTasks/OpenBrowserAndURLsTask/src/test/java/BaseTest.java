import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class BaseTest {

    protected WebDriver obj;

    @BeforeSuite
    public void setupChromeDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void openChromeBrowser() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        obj = new ChromeDriver(options);
    }

    @AfterMethod
    public void closeChromeDriver() {
        obj.quit();
    }
}

