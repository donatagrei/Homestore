package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "#username")
    private WebElement usernameInput;

    @FindBy(css = "#password")
    private WebElement passwordInput;

    @FindBy(css = "#rememberme")
    private WebElement rememberMeCheckbox;

    @FindBy(xpath = "//button[text()='Log in']")
    private WebElement logInButton;

    @FindBy(css = "ul.woocommerce-error li")
    private WebElement errorMessage;

    @FindBy(xpath = "//a[text()='Lost your password?']")
    private WebElement lostPasswordBtn;

    @FindBy(css = "#user_login")
    private WebElement usernameLostInput;

    public void typeUsernameOrEmail(String username){
        usernameInput.sendKeys(username);
    }

    public void typePassword(String password){
        passwordInput.sendKeys(password);
    }

    public void checkRememberMe(){
        rememberMeCheckbox.click();
    }

    public void clickLogIn(){
        logInButton.click();
    }

    public String getErrorText(){
        return errorMessage.getText();
    }

    public void clickLostPassword(){
        lostPasswordBtn.click();
    }

    public void typeUsernameOrEmailInLost(String username){
        usernameLostInput.sendKeys(username + Keys.ENTER);
    }

}

