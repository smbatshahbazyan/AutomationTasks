import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class ExpandTestingTest extends BaseTest {
    String ExpandTesting_WebParkUrl = "https://practice.expandtesting.com/webpark";


    @BeforeMethod
    public void openUrlAndMaximizePage() {
        driver.get(ExpandTesting_WebParkUrl);
        driver.manage().window().maximize();
    }

    @Test(dataProvider = "data")
    public void ParkingCostCalculatorTest(String startDate, String startTime, String endDate, String endTime) {

        Select parkingLotDropdown = new Select(driver.findElement(By.id("parkingLot")));
        parkingLotDropdown.selectByVisibleText("Short-Term Parking");

        WebElement entryDate = driver.findElement(By.id("entryDate"));
        entryDate.clear();
        entryDate.sendKeys(startDate);

        WebElement entryTime = driver.findElement(By.id("entryTime"));
        entryTime.clear();
        entryTime.sendKeys(startTime);

        WebElement exitDate = driver.findElement(By.id("exitDate"));
        exitDate.clear();
        exitDate.sendKeys(endDate);

        WebElement exitTime = driver.findElement(By.id("exitTime"));
        exitTime.clear();
        exitTime.sendKeys(endTime);

        wait.until(ExpectedConditions.elementToBeClickable(By.id("calculateCost"))).click();
        WebElement elem = driver.findElement(By.xpath("//div[@id= 'result']/div/p[0]"));
        int actualPrice = getResult(elem);
        int expectedPrice = costCalculator(findTimeDiff(startDate, startTime, endDate, endTime));
        Assert.assertEquals(actualPrice, expectedPrice);
    }

    public int costCalculator(double hours) {
        if (hours <= 5) {
            return 12;
        } else if (hours > 5 || hours < 24) {
            return 18;
        } else return (int) (hours % 24 * 18);
    }

    @DataProvider(name = "data")
    public Object[][] dpForDate() {
        return new Object[][]{
                {"2023-08-12", "15:00", "2023-08-12", "17:00"},
                {"2023-08-12", "12:00", "2023-08-12", "17:00"},
                {"2023-08-12", "12:00", "2023-08-12", "16:59"},
                {"2023-08-12", "12:00", "2023-08-12", "17:01"},
                {"2023-08-12", "12:00", "2023-08-12", "17:01"},
                {"2023-08-12", "12:00", "2023-08-13", "17:00"}
        };
    }

    public double findTimeDiff(String startDate, String startTime, String endDate, String endTime) {
        String[] startDateSplit = startDate.split("-");
        String[] startTimeSplit = startTime.split(":");
        String[] endDateSplit = endDate.split("-");
        String[] endTimeSplit = endTime.split(":");
        double year = stringToInt(endDateSplit[0]) - stringToInt(startDateSplit[0]);
        double month = stringToInt(endDateSplit[1]) - stringToInt(startDateSplit[1]);
        double day = stringToInt(endDateSplit[2]) - stringToInt(startDateSplit[2]);
        double hour = stringToInt(endTimeSplit[0]) - stringToInt(startTimeSplit[0]);
        double minutes = stringToInt(endTimeSplit[1]) - stringToInt(startTimeSplit[1]);
        double sumOfHours = year * 8765 + month * 730 + day * 24 + hour + minutes * 0.0166666667;
        return sumOfHours;
    }

    public int stringToInt(String text) {
        return Integer.parseInt(text);
    }

    public int getResult(WebElement elem) {
        String actual = elem.getText();
        String[] actualSplit = actual.split(".");
        int result = Integer.parseInt(actualSplit[0]);
        return result;
    }
}
