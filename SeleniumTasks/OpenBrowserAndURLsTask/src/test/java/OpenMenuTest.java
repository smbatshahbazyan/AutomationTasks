
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class OpenMenuTest extends BaseTest {
    @Test
    public void openMenu() throws InterruptedException {
        obj.get("https://menu.am/");
        obj.findElement(By.cssSelector(".MuiDialogActions-root div>.MuiButtonBase-root")).click();
        obj.findElement(By.cssSelector(".MuiBox-root.jss65.jss39 [aria-label=\"basket\"]")).click();
        Thread.sleep(2000);
    }
}
