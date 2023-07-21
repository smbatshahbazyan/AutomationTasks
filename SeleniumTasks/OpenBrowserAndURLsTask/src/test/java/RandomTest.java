import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class RandomTest extends BaseTest {
    @Test
    public void openMenu() throws InterruptedException {
        obj.get("https://www.tutorialspoint.com/");
        obj.findElement(By.id("search-strings"));
        obj.findElement(By.className("mb-sm-0"));
        obj.findElement(By.name("viewport"));
        obj.findElement(By.linkText(" Jobs"));
        obj.findElement(By.partialLinkText("Tutorials Point is a leading"));
        Thread.sleep(2000);
    }

}
