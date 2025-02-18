import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.HomePage;
import pages.LoginPage;
import utils.Generator;

public class LoginTest extends BaseTest {

    @Test
    void InvalidDataLogInTest(){
        HomePage homepage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);
        homepage.goToMyAccount();
        String username = Generator.generateUsername();
        loginPage.typeUsernameOrEmail(username);
        String password = Generator.generatePassword();
        loginPage.typePassword(password);
        loginPage.checkRememberMe();
        loginPage.clickLogIn();

        String expectedErrorText = "Error: The username " + username + " is not registered on this site. If you are " +
                "unsure " +
                "of your username, try your email address instead.";
        Assertions.assertEquals(expectedErrorText, loginPage.getErrorText(), "Error message text is not as expected.");
    }

    @Test
    void invalidEmailTest(){
        HomePage homepage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);
        homepage.goToMyAccount();
        String email = Generator.generateEmail();
        loginPage.typeUsernameOrEmail(email);
        String password = Generator.generatePassword();
        loginPage.typePassword(password);
        loginPage.checkRememberMe();
        loginPage.clickLogIn();

        String expectedErrorMessage = "Unknown email address. Check again or try your username.";
        Assertions.assertEquals(expectedErrorMessage, loginPage.getErrorText(), "Error message text is not as expected.");
    }

    @Test
    void lostPasswordTest(){
        HomePage homepage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);
        homepage.goToMyAccount();
        loginPage.clickLostPassword();
        String username = Generator.generateUsername();
        loginPage.typeUsernameOrEmailInLost(username);

        String expectedErrorText = "Invalid username or email.";
        Assertions.assertEquals(expectedErrorText, loginPage.getErrorText(), "Error message text is not as expected.");
    }

    @Test
    void emptyUsernameFieldTest(){
        HomePage homepage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);

        homepage.goToMyAccount();
        String password = Generator.generatePassword();
        loginPage.typePassword(password);
        loginPage.clickLogIn();

        String expectedErrorText = "Error: Username is required.";
        Assertions.assertEquals(expectedErrorText, loginPage.getErrorText(), "Error message text is not as expected.");
    }

    @Test
    void emptyPasswordFieldTest(){
        HomePage homepage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);
        homepage.goToMyAccount();
        String username = Generator.generateUsername();
        loginPage.typeUsernameOrEmail(username);
        loginPage.clickLogIn();

        String expectedErrorText = "Error: The password field is empty.";
        Assertions.assertEquals(expectedErrorText, loginPage.getErrorText(), "Error message text is not as expected.");
    }


}

