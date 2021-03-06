package pageobjects.apple;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BuyIphonePro13Page {

    WebDriver driver;

    int timeout = 2;
    int timeoutcapacity = 2;


    By dimSelector = By.cssSelector("[data-autom='dimensionScreensize6_7inch']+label");
    By iphonePromaxSelector = By.cssSelector("[data-autom='dimensionScreensize6_7inch']+label");
    By colorSelector = By.cssSelector("[data-autom='dimensionColorsierrablue' ]+label");
    By dimensionCapacitySelector = By.cssSelector("[data-autom='dimensionCapacity256gb']+label");
    By notreInLabelSelector = By.cssSelector("[data-autom='choose-noTradeIn']+label");
    By addToCartSelector = By.cssSelector("[name='add-to-cart']");
    By addToCartSelector2 = By.cssSelector("[value='add-to-cart']");
    By validCartSelector = By.id("shoppingCart.actions.checkout");

    public BuyIphonePro13Page(WebDriver driver) {

        this.driver = driver;
    }


    public BuyIphonePro13Page SelectIphonePro13Max() {

        driver.findElement(iphonePromaxSelector).click();


        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        wait.until(ExpectedConditions.elementToBeClickable(colorSelector));

        try {
            Thread.sleep(500);
        } catch (Exception e) {
            e.getStackTrace();
        }

        return this;
    }

    public BuyIphonePro13Page selectBlueAplin() {

        driver.findElement(colorSelector).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        wait.until(ExpectedConditions.elementToBeClickable(dimensionCapacitySelector));

        try {
            Thread.sleep(500);
        } catch (Exception e) {
            e.getStackTrace();
        }


        return this;
    }

    public BuyIphonePro13Page select256go() {


        driver.findElement(dimensionCapacitySelector).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("noTradeIn_label")));

        try {
            Thread.sleep(500);
        } catch (Exception e) {
            e.getStackTrace();
        }
        return this;
    }

    public BuyIphonePro13Page noAppleTrading() {

        driver.findElement(notreInLabelSelector).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        wait.until(ExpectedConditions.visibilityOfElementLocated(addToCartSelector));
        return this;
    }


    public ConfirmationAddToCartPage addToCart() {

        driver.findElement(addToCartSelector2).click();
        ConfirmationAddToCartPage confirmationAddToCartPage = new ConfirmationAddToCartPage(driver);
        return confirmationAddToCartPage;
    }

}
