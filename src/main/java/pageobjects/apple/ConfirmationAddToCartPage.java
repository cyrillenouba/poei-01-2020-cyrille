package pageobjects.apple;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ConfirmationAddToCartPage {

    WebDriver driver;
    By proceedSelector = By.cssSelector("[name='proceed']");
    int timeoutforgetstring = 5;
    By bag = By.id("shoppingCart.actions.checkout");


    public ConfirmationAddToCartPage(WebDriver driver){

        this.driver=driver;
    }



    public CartPage openCartPage(){
 driver.findElement(proceedSelector).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutforgetstring)) ;
        wait.until(ExpectedConditions.visibilityOfElementLocated(bag));

        CartPage cartPage = new CartPage(driver);
        return cartPage;
    }
}
