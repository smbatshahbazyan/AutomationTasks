import org.testng.annotations.Test;

public class OpenAppleAndFacebookTest extends BaseTest {
    @Test
    public void openApple() {
        obj.get("https://www.apple.com/");
    }

    @Test
    public void openFacebook() {
        obj.get("https://www.facebook.com/");
    }
}
