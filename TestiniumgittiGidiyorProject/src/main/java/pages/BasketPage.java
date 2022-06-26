package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class BasketPage {
    private WebDriver driver;


    private By clickShowBasket = By.linkText("Sepete Git");
    private By increaseProduct = By.xpath("//*[@class='amount']");
    private By clickdelete =By.className("btn-delete");
    private By totalProductPiece = By.cssSelector("li[class='clearfix total-price-sticky-container']>:nth-of-type(1)");
    private By emptyBasket = By.cssSelector("#empty-cart-container > div.gg-w-15.gg-d-14.gg-t-14.gg-m-24 > div:nth-child(1) > div > div.gg-d-19.gg-w-21.gg-t-19.gg-m-18 > h2");


    public BasketPage(WebDriver driver){this.driver = driver;}

    public void Basket(){driver.findElement(clickShowBasket).click();}

    public String getBasketPrice(){
        String text2 = driver.findElement(By.cssSelector(".total-price")).getText();
        System.out.println(text2);
        return text2;
    }

    public void ProductIncrease() throws InterruptedException {
        Select Sugggested = new Select(driver.findElement(increaseProduct));
        Sugggested.selectByVisibleText("2");
        TimeUnit.SECONDS.sleep(1);
    }
    public String getTotalProductPiece(){
        return driver.findElement(totalProductPiece).getText();
    }

    public void Delete() throws InterruptedException {
        driver.findElement(clickdelete).click();
        TimeUnit.SECONDS.sleep(2);
    }
    public String isEmpty(){
        return driver.findElement(emptyBasket).getText();
    }


}
