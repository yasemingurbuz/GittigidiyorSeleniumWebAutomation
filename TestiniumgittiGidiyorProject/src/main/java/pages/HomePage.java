package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class HomePage {
    public WebDriver driver;
    private By clickSearchBtn = By.xpath("//*[@id=\"main-header\"]/div[3]/div/div/div/div[2]/form/div/div[1]/div[2]/input");
    private By clickAddProduct = By.xpath("//*[@id=\"add-to-basket\"]");
    private By confirmBasketBtn = By.cssSelector("a[href='https://www.gittigidiyor.com/sepetim']");
    private By closeCatcheBtn = By.xpath("//*[@id=\"__next\"]/main/div[3]/section[1]/section[2]");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }
    public HomePage closeCathce(){
        driver.findElement(closeCatcheBtn).click();
        return new HomePage(driver);

    }
    public SearchProductPage clickSearch() throws InterruptedException {
        driver.findElement(clickSearchBtn).click();
        TimeUnit.SECONDS.sleep(1);
        return new SearchProductPage(driver);
    }

    public ProductPage addToBasket() throws InterruptedException {
        driver.findElement(clickAddProduct).click();
        TimeUnit.SECONDS.sleep(2);
        return new ProductPage(driver);
    }

    public BasketPage Basket(){
        driver.findElement(confirmBasketBtn).click();
        return new BasketPage(driver); }

}

