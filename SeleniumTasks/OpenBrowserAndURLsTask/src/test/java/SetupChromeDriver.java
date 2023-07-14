import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class SetupChromeDriver {
    public WebDriver getObj() {
        return obj;
    }

    public void setObj(WebDriver obj) {  //encapsulation is incomplete
        this.obj = obj;
    }

    private WebDriver obj;

    @BeforeSuite
    public void setupChromeDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void openChromeBrowser() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        obj = new ChromeDriver(options);
        setObj(obj);
    }

    @AfterMethod
    public void closeChromeDriver() {
        getObj().quit();
    }
}

