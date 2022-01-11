import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;
import java.util.function.Function;

public class UberEatsTests {

    WebDriver driver;

    @BeforeMethod
    public void setup(){

       String cookieeSelector ="#cookie-banner button.bj";

       // driver = new ChromeDriver();
        URL seleniumGridUrl = null;
        try {
            seleniumGridUrl = new URL("http://127.0.0.1:4444");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        ChromeOptions chromeOptions = new ChromeOptions();
        driver = new RemoteWebDriver(seleniumGridUrl, chromeOptions);
        driver.get("https://www.ubereats.com");
        driver.manage().window().maximize();
        //fermer cookies
        driver.findElement(By.cssSelector(cookieeSelector)).click();


    }

    @Test
    public  void addBurggerTocart(){


        String keyword = "la defense";
        int timeoutSearchLoad =10;


        By searchBarSelector = By.id("location-typeahead-home-input");
        By searchAdressList = By.id("location-typeahead-home-menu");
        By burgerSelector = By.cssSelector("img[alt='Burgers']");
        By searchResultKmarcelSelector = By.cssSelector("a[href='/fr/store/king-marcel-nanterre/07TTIgUiQPWyz4uq4_H35w'] > h3");
        By burgerMArcelSelector = By.cssSelector("img[alt='Le Marcel Jackson']");
        By validateBurgerButton = By.cssSelector(".spacer._24 + button.b8");
        //.spacer._24 + button.b8 (another selector)
        By cart = By.cssSelector(".ia.ch");



        WebElement barreRecherche = driver.findElement(searchBarSelector);
        barreRecherche.sendKeys(keyword );
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutSearchLoad)) ;
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchAdressList));
        barreRecherche.sendKeys(Keys.ENTER);
        wait.until(ExpectedConditions.visibilityOfElementLocated(burgerSelector));
         //select burger
       driver.findElement(burgerSelector).click();


        //serch kmarcel restaurant
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchResultKmarcelSelector));
        driver.findElement(searchResultKmarcelSelector).click();


        //select burger marcel
        wait.until(ExpectedConditions.visibilityOfElementLocated(burgerMArcelSelector));
        driver.findElement(burgerMArcelSelector ).click();


        //add marcel bugger button

        wait.until(ExpectedConditions.visibilityOfElementLocated(validateBurgerButton));
        WebElement validateBurger = driver.findElement(validateBurgerButton);
        validateBurger.click();


        wait.until(ExpectedConditions.invisibilityOf(validateBurger));

        WebElement cartContain = driver.findElement(cart);

       char cartNumber = cartContain.getText().charAt(9);



        Assert.assertEquals(cartNumber,'1',"le panier ne contient pas un marcel buger");






    }

    @AfterMethod
    public  void tearDown() {
        driver.quit();

    }


}
