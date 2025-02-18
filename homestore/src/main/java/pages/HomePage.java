package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "#woocommerce-product-search-field-0")
    private WebElement upperSearchInput;

    @FindBy(xpath = "//*[text()='My Account']")
    private WebElement myAccountButton;


    public void goToMenuSection(String menuButtonName) {
        driver.findElement(By.xpath("//*[text()='" + menuButtonName + "']")).click();
    }

    public void typeToSearchField(String mySearch) {
        upperSearchInput.sendKeys(mySearch + Keys.ENTER);
    }

    public void goToMyAccount(){
        myAccountButton.click();
    }

}

