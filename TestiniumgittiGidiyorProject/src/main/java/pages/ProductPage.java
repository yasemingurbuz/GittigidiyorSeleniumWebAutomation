package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage {
    private WebDriver driver;


    private By productTitle = By.id("sp-title");
    private By productPrice = By.id("sp-price-highPrice");
    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }


    public String productPrice(){
        String text = driver.findElement(productPrice).getText();

        System.out.println(text);
        return text;
    }


}
