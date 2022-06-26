package base;

import org.junit.After;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.HomePage;

import java.util.concurrent.TimeUnit;
public class BaseTests {
    public WebDriver driver;
    protected HomePage homePage;
    @BeforeClass
    public void setUp(){

        ChromeOptions ops = new ChromeOptions();
        ops.addArguments("--disable-notifications");
        System.setProperty("webdriver.chrome.driver","resources/chromedriver.exe");
        driver = new ChromeDriver(ops);
        goHome();
    }
    @BeforeMethod
    public void goHome(){
        driver.get("https://www.gittigidiyor.com/");
        driver.manage().window().maximize();
        homePage = new HomePage(driver);
    }
    @AfterMethod
    public void quitDriver() {
        driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
        driver.quit();
    }
}
