import org.example.Main;
import org.testng.Assert;
import org.testng.annotations.*;

public class SumTest {
    @Test
    public void testSum() {
        Main main = new Main();
        Assert.assertEquals(main.sum(5, 8), 13);
        System.out.println("Test for sum method");
    }

    @AfterMethod
    public void exampleAfterMethod() {
        System.out.println("Testing after method");
    }

    @BeforeMethod
    public void exampleBeforeMethod() {
        System.out.println("Testing before method");
    }

    @BeforeSuite
    public void exampleBeforeSuit() {
        System.out.println("Testing before suit");
    }

    @BeforeTest
    public void exampleBeforeTest() {
        System.out.println("Testing before test");
    }

    @BeforeClass
    public void exampleBeforeClass() {
        System.out.println("Testing before class");
    }

}
