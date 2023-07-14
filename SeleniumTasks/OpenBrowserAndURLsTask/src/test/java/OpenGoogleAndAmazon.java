import org.testng.annotations.Test;

public class OpenGoogleAndAmazon extends SetupChromeDriver {
    @Test
    public void openApple() {
        getObj().get("https://www.google.com/");
    }

    @Test
    public void openFacebook() {
        getObj().get("https://www.amazon.com/");
    }
}
