import org.testng.annotations.Test;

public class OpenGoogleAndAmazonTest extends BaseTest {
    @Test
    public void openApple() {
        obj.get("https://www.google.com/");
    }

    @Test
    public void openFacebook() {
        obj.get("https://www.amazon.com/");
    }
}
