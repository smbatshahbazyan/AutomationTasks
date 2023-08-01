import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AmazonTest extends BaseTest {
    String amazon = "https://www.amazon.com/";
    String allButtonFromSearchXpath="//div[@id='nav-search-dropdown-card']";
    String booksFromDropdownInSearchXpath="//select[@id='searchDropdownBox']/option[6]";
    String searchField="//div[@class='nav-search-field ']/input[@id='twotabsearchtextbox']";
    String searchButton="//input[@id='nav-search-submit-button']";

    @BeforeClass
    public void openUrlAndAddFirstOfferToBasket() throws InterruptedException {
        driver.get(amazon);
        driver.manage().window().maximize();
    }

    @Test
    public void aaa() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(allButtonFromSearchXpath))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(allButtonFromSearchXpath+booksFromDropdownInSearchXpath))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(searchField))).sendKeys("Mark Twain");
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(searchButton))).click();
        String searchResultText = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='search']//span[@data-component-type='s-result-info-bar']//div[@class='a-section a-spacing-small a-spacing-top-small']"))).getText();
        String[] textSplit = searchResultText.split(" ");
        String[] splitForGetSearchResultQuantity = textSplit[0].split("-");
        int searchResultQuantity = Integer.parseInt(splitForGetSearchResultQuantity[1]);
        int countOFItemsAfterSearch = driver.findElements(By.xpath("//span[@class='rush-component s-latency-cf-section']//div[@data-component-type='s-search-result']")).size();
        Assert.assertEquals(searchResultQuantity, countOFItemsAfterSearch, "Search result quantity in text not equal to items in search bar");
    }
}
