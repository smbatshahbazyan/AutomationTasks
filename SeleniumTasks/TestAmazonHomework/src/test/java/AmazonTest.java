import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AmazonTest extends BaseTest {
    String URLForAmazon = "https://www.amazon.com/";
    By allButtonFromSearchXpath = By.xpath(" //div[@id='nav-search-dropdown-card']");
    By searchField = By.xpath("//div[@class='nav-search-field ']/input[@id='twotabsearchtextbox']");
    By searchButton = By.xpath("//input[@id='nav-search-submit-button']");

    @BeforeClass
    public void openUrlAndMaximizePage() {
        driver.get(URLForAmazon);
        driver.manage().window().maximize();
    }

    @Test
    public void searchBoxTest() {
        wait.until(ExpectedConditions.elementToBeClickable(allButtonFromSearchXpath)).click();
        Select fromDropdown = new Select(driver.findElement(By.id("searchDropdownBox")));
        fromDropdown.selectByVisibleText("Books");
        wait.until(ExpectedConditions.elementToBeClickable(searchField)).sendKeys("Mark Twain");
        wait.until(ExpectedConditions.elementToBeClickable(searchButton)).click();
        String searchResultText = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='search']//span[@data-component-type='s-result-info-bar']//div[contains (@class, 's-breadcrumb')]//span[1]"))).getText();
        String[] textSplit = searchResultText.split(" ");
        String[] splitForGetSearchResultQuantity = textSplit[0].split("-");
        int searchResultQuantity = Integer.parseInt(splitForGetSearchResultQuantity[1]);
        int countOFItemsAfterSearch = driver.findElements(By.xpath("//span[@data-component-type='s-search-results']//div[@data-component-type='s-search-result']")).size();
        Assert.assertEquals(searchResultQuantity, countOFItemsAfterSearch, "Search result quantity in text not equal to items in search bar");
    }
}
