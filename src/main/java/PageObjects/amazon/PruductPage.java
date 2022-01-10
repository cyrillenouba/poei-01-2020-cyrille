package PageObjects.amazon;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PruductPage {
    WebDriver driver;


    public PruductPage(WebDriver driver){
        this.driver=driver;
    }

    By addToCartbuttonSelector = By.id("add-to-cart-button");
    By addWarrantyButtonSelector = By.cssSelector("#attachSiAddCoverage input");

    By noCoverageButton = By.cssSelector("#attachSiNoCoverage input");
    By confirmatioImageSelector = By.id("add-to-cart-confirmation-image");
    int timeoutSideBar = 3;
   int  timeoutCarButton=10;



    public void addToCart(){

        driver.findElement(addToCartbuttonSelector).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutSideBar)) ;
        wait.until(ExpectedConditions.elementToBeClickable(addWarrantyButtonSelector));

    }

    public void noCoverrage(){

        driver.findElement(noCoverageButton).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutCarButton)) ;
        wait.until(ExpectedConditions.visibilityOfElementLocated(confirmatioImageSelector ));

    }
}
