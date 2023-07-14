import org.testng.annotations.Test;

public class OpenAppleAndFacebook extends SetupChromeDriver {
    @Test
    public void openApple() {
        getObj().get("https://www.apple.com/");
    }

    @Test
    public void openFacebook() {
        getObj().get("https://www.facebook.com/");
    }
}
