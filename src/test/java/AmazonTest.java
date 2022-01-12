import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageobjects.amazon.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.swing.*;
import java.time.Duration;

public class AmazonTest {

    WebDriver driver;
    @BeforeMethod
    public void setup(){

        driver = new ChromeDriver();
        driver.get("https://www.amazon.fr");
        driver.manage().window().maximize();
        driver.findElement(By.id("sp-cc-accept")).click();


    }

@Test

public void hoverTest() throws InterruptedException {

       By buttonSelector = By.id("nav-link-accountList");


    Actions hover = new Actions(driver);
    WebElement button = driver.findElement(buttonSelector);

    hover.moveToElement(button);
    hover.perform();

    By myAccountSelector = By.cssSelector("#nav-al-your-account .nav-title + a");
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
    wait.until(ExpectedConditions.elementToBeClickable(myAccountSelector)).click();

    Thread.sleep(1000);

}

    @AfterMethod
    public void teardown(){

        driver.quit();
    }
}
