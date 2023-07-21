import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class FindingEmailsTest extends BaseTest {
    @Test
    public void findingEmails() {
        obj.get("https://practice.expandtesting.com/tables");
        List<WebElement> emails = obj.findElements(By.xpath("//*[@id='table2']//td[contains(@class, 'email')]"));
        for (WebElement email : emails) {
            System.out.println(email.getText());
        }
        obj.findElement(By.xpath("//*[@id='table2']//tbody/tr/td[text() = 'Smith']//..//following-sibling:: a[contains(@class, 'btn btn-danger')]")).click();
    }
}
