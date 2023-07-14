import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTests {
    private WebDriver obj;

    @BeforeClass
    public void setupChromeDriver() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        obj = new ChromeDriver(options);
    }

    @Test(dataProvider = "ValidUsernames")
    public void loginFunctionality(String username) {
        obj.get("https://www.saucedemo.com/");
        WebElement log = obj.findElement(By.id("user-name"));
        log.sendKeys(username);
        log = obj.findElement(By.id("password"));
        log.sendKeys("secret_sauce");
        log = obj.findElement(By.id("login-button"));
        log.click();
    }

    @DataProvider(name = "ValidUsernames")
    public Object[][] loginWithValidUsernames() {
        return new Object[][]{
                {"standard_user"},
                {"locked_out_user"},
                {"problem_user"},
                {"performance_glitch_user"},
        };
    }
}
