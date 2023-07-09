import org.example.User;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class RegisterTests {
    @DataProvider(name = "valid names")
    public Object[][] validNames() {
        return new Object[][]{
                {"Armen"},
                {"Vazgen"},
                {"Beniamin"},
                {"Anatoli"}
        };
    }

    @DataProvider(name = "invalid names")
    public Object[][] invalidNames() {
        return new Object[][]{
                {"armen"},
                {"vazgen18"},
                {"199987"},
                {"Anatoli$"}
        };
    }

    @DataProvider(name = "valid surnames")
    public Object[][] validSurnames() {
        return new Object[][]{
                {"Sahakyan"},
                {"Azatyan"},
                {"Franklin"},
                {"Fedyukov"}
        };
    }

    @DataProvider(name = "invalid surnames")
    public Object[][] invalidSurnames() {
        return new Object[][]{
                {"sahakyan"},
                {"Azatyan18"},
                {"19875248"},
                {"Fedyukov$"}
        };
    }

    @DataProvider(name = "valid mails")
    public Object[][] validMails() {
        return new Object[][]{
                {"sahakyan@gmail.com"},
                {"azatyan18@mail.ru"},
                {"1987mansuhak@bk.ru"},
                {"fedfed@gmail.com"}
        };
    }

    @DataProvider(name = "invalid mails")
    public Object[][] invalidMails() {
        return new Object[][]{
                {"sahakyanGmail"},
                {"azatyan18@"},
                {"19875248.ru"},
                {"fedyukov$2@"}
        };
    }

    @DataProvider(name = "valid logins")
    public Object[][] validLogins() {
        return new Object[][]{
                {"azatyan9"},
                {"azatyan99"},
                {"181818aaaa"},
                {"fedyukov18"}
        };
    }

    @DataProvider(name = "invalid logins")
    public Object[][] invalidLogins() {
        return new Object[][]{
                {"Sahakyan"},
                {"19Azat"},
                {"19875"},
                {"fedya"}
        };
    }

    @DataProvider(name = "valid passwords")
    public Object[][] validPassword() {
        return new Object[][]{
                {"Azatyan999"},
                {"azatyaN777"},
                {"AAaa1122"},
                {"fedyukoV-$18"}
        };
    }

    @DataProvider(name = "invalid passwords")
    public Object[][] invalidPassword() {
        return new Object[][]{
                {"Sahakyan"},
                {"1997azatyan"},
                {"19875889"},
                {"fedyaFedya"}
        };
    }

    @BeforeClass
    public void registerUserBeforeTesting() {
        User.register("Aram", "Aramyan", "aramyan@mail.ru", "aram1999", "Aramik1999");
        Assert.assertFalse(User.users.isEmpty());
    }

    @AfterClass
    public void deleteUserAfetTesting() {
        User.users.clear();
    }

    @Test(dataProvider = "valid names")//positive cases
    public void testRegistrationWithValidNames(String name) {
        User.users.get(0).setName(name);
        Assert.assertEquals(User.users.get(0).getName(), name);
    }

    @Test(dataProvider = "invalid names", expectedExceptions = IllegalArgumentException.class)//negative cases
    public void testRegistrationWithInvalidNames(String name) {
        User.users.get(0).setName(name);
        Assert.assertEquals(User.users.get(0).getName(), name);
    }

    @Test(dataProvider = "valid surnames")//positive cases
    public void testRegistrationWithValidSurnames(String surname) {
        User.users.get(0).setSurname(surname);
        Assert.assertEquals(User.users.get(0).getSurname(), surname);
    }

    @Test(dataProvider = "invalid surnames", expectedExceptions = IllegalArgumentException.class)//negative cases
    public void testRegistrationWithInvalidSurnames(String surname) {
        User.users.get(0).setSurname(surname);
        Assert.assertEquals(User.users.get(0).getSurname(), surname);
    }

    @Test(dataProvider = "valid mails")//positive cases
    public void testRegistrationWithValidMails(String mail) {
        User.users.get(0).setMail(mail);
        Assert.assertEquals(User.users.get(0).getMail(), mail);
    }

    @Test(dataProvider = "invalid mails", expectedExceptions = IllegalArgumentException.class)//negative cases
    public void testRegistrationWithInvalidMails(String mail) {
        User.users.get(0).setMail(mail);
        Assert.assertEquals(User.users.get(0).getMail(), mail);
    }

    @Test(dataProvider = "valid logins")//positive cases
    public void testRegistrationWithValidLogins(String login) {
        User.users.get(0).setLogin(login);
    }

    @Test(dataProvider = "invalid logins", expectedExceptions = IllegalArgumentException.class)//negative cases
    public void testRegistrationWithInvalidLogins(String login) {
        User.users.get(0).setLogin(login);
    }

    @Test(dataProvider = "valid passwords")//positive cases
    public void testRegistrationWithValidPassword(String password) {
        User.users.get(0).setPassword(password);
    }

    @Test(dataProvider = "invalid passwords", expectedExceptions = IllegalArgumentException.class)//negative cases
    public void testRegistrationWithInvalidPassword(String password) {
        User.users.get(0).setPassword(password);
    }
}
