import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class UrlTest {
    @BeforeMethod
    public void beforeOpeningBrowser(){
        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\Smart\\Desktop\\AutomationTasks\\SeleniumTasks\\OpenAndCloseGoogle\\src\\main\\resources\\chromedriver.exe");
    }
    @Test
    public void openBrowser (){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver obj =new ChromeDriver(options);
        obj.get("https://www.google.com/");
        obj.quit();
    }
}
