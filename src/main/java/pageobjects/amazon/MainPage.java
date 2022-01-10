package pageobjects.amazon;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage {
    WebDriver driver;

    int timeoutSearch = 10;
    By searchBArSelector = By.id("twotabsearchtextbox");
    By searchResultSelector = By.cssSelector("[data-component-type='s-search-result']");

    public MainPage(WebDriver driver){

        this.driver=driver;
    }

    public void searchProduct(String productName){

        driver.findElement(searchBArSelector).sendKeys(productName + Keys.ENTER);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutSearch)) ;
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchResultSelector));
        //PageObjects.amazon.SearchResultPage searchResultPage=new PageObjects.amazon.SearchResultPage(driver);
       // searchResultPage.openResult(0);


    }
}



