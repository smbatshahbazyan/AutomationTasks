import org.example.User;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTests {
    @BeforeClass
    public void registerUserBeforeTesting() {
        User.register("Aram", "Aramyan", "aramyan@mail.ru", "aram1999", "Aramik1999");
        User.register("Karen", "Abgaryan", "karen@gmail.com", "karijkaren55", "karenKarij1999+");
        User.register("Margar", "Margaryan", "margarg@mail.ru", "margarin66", "Margarin1010+");
        User.register("John", "Lennon", "lennon@mail.ru", "lennon666", "Lennon555");

    }


    @DataProvider(name = "valid logins valid passwords")
    public Object[][] validLoginsValidPasswords() {
        return new Object[][]{
                {"aram1999", "Aramik1999"},
                {"karijkaren55", "karenKarij1999+"},
                {"margarin66", "Margarin1010+"},
                {"lennon666", "Lennon555"}
        };
    }

    @DataProvider(name = "invalid logins valid passwords")
    public Object[][] invalidLoginsValidPasswords() {
        return new Object[][]{
                {"aram199", "Aramik1999"},
                {"$$1255asaa", "karenKarij1999+"},
                {"margarin", "Margarin1010+"},
                {"", "Lennon555"}
        };
    }

    @DataProvider(name = "valid logins invalid passwords")
    public Object[][] validLoginsInvalidPasswords() {
        return new Object[][]{
                {"aram1999", "Aramik"},
                {"karijkaren55", "Karij1999+"},
                {"margarin66", "10102020+"},
                {"lennon666", ""}
        };
    }

    @Test(dataProvider = "valid logins valid passwords")
    public void loginWithValidLoginValidPassword(String login, String password) {
        User.login(login, password);
    }

    @Test(dataProvider = "invalid logins valid passwords", expectedExceptions = IllegalArgumentException.class)
    public void loginWithInvalidLoginValidPassword(String login, String password) {
        User.login(login, password);
    }

    @Test(dataProvider = "valid logins invalid passwords", expectedExceptions = IllegalArgumentException.class)
    public void loginWithValidLoginInvalidPassword(String login, String password) {
        User.login(login, password);
    }

    @AfterClass
    public void deleteUserAfetTesting() {
        User.users.clear();
    }
}