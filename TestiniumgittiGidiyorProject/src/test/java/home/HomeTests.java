package home;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BasketPage;
import pages.ProductPage;
import pages.SearchProductPage;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class HomeTests extends BaseTests {


    @Test
    public void testSuccessfulLogin() throws InterruptedException {

        homePage.closeCathce();
        //Search Product

        SearchProductPage searchProductPage = homePage.clickSearch();
        searchProductPage.setSearch("bilgisayar");
        searchProductPage.clickIcon();
        searchProductPage.scrollToPage("7200");
        searchProductPage.choosePage("2");
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.gittigidiyor.com/arama/?k=bilgisayar&sf=2");
        searchProductPage.selectProduct();

        //Add Product to Basket and price comparison
        ProductPage productPage = homePage.addToBasket();
        String text = productPage.productPrice();

        BasketPage basketPage = new BasketPage(driver);
        basketPage.Basket();
        String text2 = basketPage.getBasketPrice();
        Assert.assertEquals(text, text2);

        //Increase product
        basketPage.ProductIncrease();
        assertTrue(basketPage.getTotalProductPiece().contains("2 Adet"));

        //delete product
        basketPage.Delete();
        String basketMessage = "Sepetinizde ürün bulunmamaktadır.";
        assertEquals(basketMessage, basketPage.isEmpty());

    }
    }



