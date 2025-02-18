package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class ShopPage extends BasePage {

    public ShopPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "a.next.page-numbers")
    private WebElement nextPageButton;

    @FindBy(css = "a.prev.page-numbers")
    private WebElement previousPageButton;

    @FindBy(css = "span.page-numbers.current")
    private WebElement currentPage;

    @FindBy(css = ".products.columns-4 h2")
    private List<WebElement> productsList;

    @FindBy(css = "div p.woocommerce-result-count")
    private WebElement theNumberOfResultsShown;


    public void clickPageButton(String pageNumber) {
        driver.findElement(By.xpath("//*[text()='" + pageNumber + "']")).click();
    }

    public void clickNextPageButton() {
        nextPageButton.click();
    }

    public void clickPreviousPageButton() {
        previousPageButton.click();
    }

    public boolean isTheRightPageLoaded(String expectedPageNumber) {
        List<WebElement> buttonsHavingSameNumber = driver.findElements(By.xpath("//*[text()='" + expectedPageNumber +
                "']"));
        boolean sameClassOfElements =
                buttonsHavingSameNumber.stream().map(WebElement::getClass).distinct().count() == 1;
        return sameClassOfElements;
    }

    public List<String> getProductsList() {
        return productsList.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }

    public String getProductsListCount() {
        return Integer.toString(productsList.size());
    }

    public String getTextOfSearchResult() {
        return theNumberOfResultsShown.getText();
    }

    public String getExpectedTextOfSearchResult(String count) {
        return driver.findElements(By.xpath("//p[contains(text()," + count + ")]")).getFirst().getText();
    }

    public void openRandomProductInTheList() {
        Random random = new Random();
        int randomProductIndex = random.nextInt(productsList.size());
        WebElement randomProduct = productsList.get(randomProductIndex);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", randomProduct);
        randomProduct.click();
    }
}
