import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.HomePage;
import pages.ShopPage;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class FilterAndSearchTest extends BaseTest {


    @Test
    void secondProductsPageTest() {

        HomePage homePage = new HomePage(driver);
        ShopPage shopPage = new ShopPage(driver);
        homePage.goToMenuSection("Shop");
        shopPage.clickPageButton("2");

        Assertions.assertTrue(shopPage.isTheRightPageLoaded("2"));
    }


    @Test
    void nextAndPreviousPageTest() {

        HomePage homePage = new HomePage(driver);
        ShopPage shopPage = new ShopPage(driver);
        homePage.goToMenuSection("Shop");
        shopPage.clickNextPageButton();

        Assertions.assertTrue(shopPage.isTheRightPageLoaded("2"));

        shopPage.clickPreviousPageButton();

        Assertions.assertTrue(shopPage.isTheRightPageLoaded("1"));
    }


    @Test
    void productSearchTest() {

        HomePage homePage = new HomePage(driver);
        ShopPage shopPage = new ShopPage(driver);
        homePage.typeToSearchField("wooden");

        List<String> actualProductList = shopPage.getProductsList();
        String actualProductsCount = shopPage.getProductsListCount();

        assertThat(actualProductList).allSatisfy(item -> assertThat(item).containsIgnoringCase("wooden"));
        Assertions.assertEquals(shopPage.getExpectedTextOfSearchResult(actualProductsCount),
                shopPage.getTextOfSearchResult());
    }
}

