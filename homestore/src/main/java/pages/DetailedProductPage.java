package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Objects;

public class DetailedProductPage extends BasePage{

    public DetailedProductPage(WebDriver driver){
        super(driver);
    }

    @FindBy(css = ".woocommerce-product-details__short-description")
    private WebElement productDescription;

    @FindBy (css = "span.posted_in")
    private WebElement productCategory;

    @FindBy (css = ".input-text")
    private WebElement amountInput;

    @FindBy (xpath = "//button[text()='Add to cart']" )
    private WebElement addToCartButton;

    @FindBy (css = "div.woocommerce-message")
    private WebElement messageBlock;

    @FindBy (xpath = "//div[contains(@class, 'woocommerce-message')]/a")
    private WebElement viewCartButtonInMessage;

    @FindBy (css = "h1.product_title")
    private WebElement productTitle;

    @FindBy (xpath = "//bdi[span[contains(@class, 'woocommerce-Price-currencySymbol')]]")
    private List<WebElement> allPricesShownOnPage;

    @FindBy (xpath = "//div[contains(@class, 'woocommerce-product-gallery__image')]/a/img")
    private WebElement productPhoto;

    @FindBy (css = "span.onsale")
    private WebElement onSaleBadge;

    @FindBy (css = "li.mini_cart_item .attachment-woocommerce_thumbnail.size-woocommerce_thumbnail")
    private WebElement productPhotoInCart;

    @FindBy (xpath = "(//a[text()='View cart'])[position()=3]")
    private WebElement viewCartButton;

    @FindBy (xpath = "(//a[text()='Checkout'])[last()]")
    private WebElement checkoutButton;



    public boolean isPriceVisible() {
        return driver.findElements(By.cssSelector(".woocommerce-Price-amount.amount")).get(2).isDisplayed();
    }

    public boolean isDescriptionVisible(){
        return productDescription.isDisplayed();
    }

    public boolean isProductCategoriesVisible(){
        return productCategory.isDisplayed();
    }

    public void enterItemQuantity(String amount){
        amountInput.clear();
        amountInput.sendKeys(amount);
    }

    public void clickAddToCartButton(){
        addToCartButton.click();
    }

    public boolean isMessageBlockAppeared(){
        return messageBlock.isDisplayed();
    }

    public boolean isButtonViewCartVisible(){
        return viewCartButtonInMessage.isDisplayed();
    }

    public boolean isItemNameInMessageCorrect(){
        String correctItemName = productTitle.getText();
        String messageText = messageBlock.getText();
        return messageText.contains(correctItemName);
    }

    public boolean isAmountInMessageCorrect(){
        String correctAmount = amountInput.getAttribute("value");
        String messageText = messageBlock.getText();
        if (correctAmount.equals("1")){
            return true;
        }else {
            return messageText.contains(Objects.requireNonNull(correctAmount));
        }
    }

    public boolean isItemNameInCartSectionCorrect(){
        String correctItemName = productTitle.getText();
        String itemNameInCart = driver.findElements(By.cssSelector(".remove_from_cart_button + *")).get(1).getText();
        return itemNameInCart.contains(correctItemName);
    }

    public boolean isItemAmountInCartCorrect() {
        String correctAmount = amountInput.getAttribute("value");
        return driver.findElements(By.xpath("//span[@class='quantity'][contains(text(), '" + correctAmount + " × ')]")).get(1).isDisplayed();
    }

    public boolean isProductOnSale (){
        WebElement container = driver.findElement(By.cssSelector("figure.woocommerce-product-gallery__wrapper"));
        List <WebElement> elementInContainer = container.findElements(By.cssSelector("span.onsale"));
        return !elementInContainer.isEmpty();
    }

    public String getProductPrice(){
        if (isProductOnSale()){
            return allPricesShownOnPage.get(3).getText();
        }else {
            return allPricesShownOnPage.get(2).getText();
        }
    }

    public boolean isItemPriceInCartCorrect(){
        String correctPrice = getProductPrice();
        String priceInCart = driver.findElements(By.xpath("//div[contains(@class, 'widget_shopping_cart')" +
                "]//span[@class='woocommerce-Price-amount amount']/bdi")).get(2).getText();
        if (correctPrice.equals(priceInCart)){
            return true;
        }else {
            return false;
        }
    }

    public boolean isItemPhotoInCartCorrect(){
        String correctPhotoUrl = productPhoto.getAttribute("src");
        String photoInCartUrl = driver.findElements(By.cssSelector("li.mini_cart_item .attachment-woocommerce_thumbnail" +
                ".size-woocommerce_thumbnail")).get(1).getAttribute("src");
        char cutOffChar = '?';
        int index = photoInCartUrl.indexOf(cutOffChar);
        String partUrl = photoInCartUrl.substring(0, index);
        return correctPhotoUrl.contains(partUrl);
    }

    public boolean isCancelItemButtonVisible(){
        return driver.findElements(By.cssSelector(".remove_from_cart_button")).get(1).isDisplayed();
    }

    public boolean isTextSubtotalVisible(){
        return driver.findElements(By.cssSelector(".woocommerce-mini-cart__total")).get(1).isDisplayed();
    }

    public double getTotalPriceInCart(){
        String totalPrice = driver.findElement(By.xpath("(//p[@class='woocommerce-mini-cart__total " +
                "total'])[2]/span[contains(@class, 'woocommerce-Price-amount')]/bdi")).getText();
        String part = totalPrice.substring(1);
        String cleanedPart = part.replace(",", "");
        return Double.parseDouble(cleanedPart);
    }

    public double countTotalPrice(){
        double amount = Double.parseDouble(Objects.requireNonNull(amountInput.getAttribute("value")));
        String priceInString = getProductPrice().substring(1);
        double price = Double.parseDouble(priceInString);
        return amount * price;
    }

    public boolean isViewCartButtonVisible(){
        return viewCartButton.isDisplayed();
    }

    public boolean isCheckoutButtonVisible(){
        return checkoutButton.isDisplayed();
    }

}
