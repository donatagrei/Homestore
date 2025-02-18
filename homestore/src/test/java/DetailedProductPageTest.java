import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import pages.HomePage;
import pages.DetailedProductPage;
import pages.ShopPage;

public class DetailedProductPageTest extends BaseTest {

    @Test
    void productDetailsTest() {

        HomePage homePage = new HomePage(driver);
        ShopPage shopPage = new ShopPage(driver);
        DetailedProductPage detailedProductPage = new DetailedProductPage(driver);
        homePage.goToMenuSection("Shop");
        shopPage.openRandomProductInTheList();

        Assertions.assertTrue(detailedProductPage.isPriceVisible());
        Assertions.assertTrue(detailedProductPage.isDescriptionVisible());
        Assertions.assertTrue(detailedProductPage.isProductCategoriesVisible());
    }


    @ParameterizedTest
    @ValueSource(strings = {"1", "7", "15"})
    void addToCartFunctionTest(String amount) {

        HomePage homePage = new HomePage(driver);
        ShopPage shopPage = new ShopPage(driver);
        DetailedProductPage detailedProductPage = new DetailedProductPage(driver);
        homePage.goToMenuSection("Shop");
        shopPage.openRandomProductInTheList();
        detailedProductPage.enterItemQuantity(amount);
        detailedProductPage.clickAddToCartButton();

        Assertions.assertTrue(detailedProductPage.isMessageBlockAppeared());
        Assertions.assertTrue(detailedProductPage.isButtonViewCartVisible());
        Assertions.assertTrue(detailedProductPage.isItemNameInMessageCorrect());
        Assertions.assertTrue(detailedProductPage.isAmountInMessageCorrect());
    }


    @ParameterizedTest
    @ValueSource(strings = {"1", "20", "9"})
    void cartSectionInfoTest(String amount){

        HomePage homePage = new HomePage(driver);
        ShopPage shopPage = new ShopPage(driver);
        DetailedProductPage detailedProductPage = new DetailedProductPage(driver);
        homePage.goToMenuSection("Shop");
        shopPage.openRandomProductInTheList();
        detailedProductPage.enterItemQuantity(amount);
        detailedProductPage.clickAddToCartButton();

        Assertions.assertTrue(detailedProductPage.isItemNameInCartSectionCorrect());
        Assertions.assertTrue(detailedProductPage.isItemAmountInCartCorrect());
        Assertions.assertTrue(detailedProductPage.isItemPriceInCartCorrect());
        Assertions.assertTrue(detailedProductPage.isItemPhotoInCartCorrect());
        Assertions.assertTrue(detailedProductPage.isCancelItemButtonVisible());
        Assertions.assertTrue(detailedProductPage.isTextSubtotalVisible());
        Assertions.assertEquals(detailedProductPage.countTotalPrice(), detailedProductPage.getTotalPriceInCart());
        Assertions.assertTrue(detailedProductPage.isViewCartButtonVisible());
        Assertions.assertTrue(detailedProductPage.isCheckoutButtonVisible());
    }

}

