
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class OpenMenu extends SetupChromeDriver {
    @Test
    public void openMenu() {
        getObj().get("https://menu.am/");
        getObj().findElement(By.xpath("/html/body/div[2]/div[3]/div/div[3]/div/button")).click();
        getObj().findElement(By.xpath("//*[@id=\"__next\"]/div/header/div[1]/div/div[3]/div/div[3]/div[1]/button")).click();
//      //waiting 2 seconds incomplete
    }
}
