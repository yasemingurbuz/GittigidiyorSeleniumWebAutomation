package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Random;


import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;


import static java.lang.Thread.sleep;

public class SearchProductPage{
    private WebDriver driver;


    private By searchBox = By.xpath("//*[@id=\"main-header\"]/div[3]/div/div/div/div[2]/form/div/div[1]/div[2]/input");
    private By clickSearchBtn = By.xpath("//*[@id=\"main-header\"]/div[3]/div/div/div/div[2]/form/div/div[2]/button");

    int min_val = 1;
    int max_val = 32;
    ThreadLocalRandom tlr = ThreadLocalRandom.current();
    int randomNum = tlr.nextInt(min_val, max_val + 1);
    String productNameLocatorXpath = "//*[@id=\"2\"]/li["+randomNum+"]";
    private By productNameLocator = By.xpath(productNameLocatorXpath);



    public SearchProductPage(WebDriver driver){ this.driver = driver; }

   //search product
    public void setSearch(String search) throws InterruptedException {
        driver.findElement(searchBox).sendKeys(search);
        TimeUnit.SECONDS.sleep(1);
    }
    public void clickIcon() throws InterruptedException {
        driver.findElement(clickSearchBtn).click();
        TimeUnit.SECONDS.sleep(1);
    }

    // choose page 2nd page
    public void scrollToPage(String pixel){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0," + pixel + ")");
    }

    public void choosePage(String pageNumber) throws InterruptedException {
        driver.get(driver.getCurrentUrl() + "&sf=" + pageNumber);
        TimeUnit.SECONDS.sleep(1);
    }

    //random select product
    public void selectProduct() throws InterruptedException {
        driver.findElement(productNameLocator).click();
        TimeUnit.SECONDS.sleep(1);
    }

}

