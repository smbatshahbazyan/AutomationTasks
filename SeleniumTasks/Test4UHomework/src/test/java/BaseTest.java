import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import java.time.Duration;

public class BaseTest {
    protected WebDriver driver;
    protected WebDriverWait wait;

    @BeforeSuite
    public void setupChromeDriver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @BeforeTest
    public void openUrlAndAddFirstOfferToBasket() throws InterruptedException {
        driver.get("https://4u.am/en/");
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        WebElement firstElementFromOffer = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id = 'offer1']//div[contains(@class, 'swiper-slide-active')]//div[@class='item_basket']//a")));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1050)", "");
        Thread.sleep(3000);
        firstElementFromOffer.click();
    }

    @AfterSuite
    public void closeChromeDriver() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
    }
}
