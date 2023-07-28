import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Offer4uTest extends BaseTest {
    @Test(priority = 1)
    public void addingItemToBasketTest() {
        String itemPrice = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id = 'offer1']//div[contains(@class, 'swiper-slide-active')]//div[contains(@class, 'price')]"))).getText();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='basketIcon']"))).click(); //open basket list
        String totalPriceInBasket = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//p[contains(@class, 'total_price')]"))).getText();
        String itemName = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id = 'offer1']//div[contains(@class, 'swiper-slide-active')]//div[contains(@class, 'item_descr')]//p[contains(@class, 'name')]"))).getText();
        String itemNameInBasket = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class = 'basket_content']//a/h4"))).getText();

        Assert.assertEquals(itemName, itemNameInBasket, "Added item name and name item in basket are different");
        Assert.assertEquals(itemPrice, totalPriceInBasket, "Added item price and basket price are different");
    }
}
