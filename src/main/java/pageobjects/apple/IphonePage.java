package pageobjects.apple;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class IphonePage {

    WebDriver driver;

    By iphone13ProPageSelector= By.cssSelector(".chapternav-item-iphone-13-pro");

    public IphonePage(WebDriver driver){

        this.driver=driver;
    }

    public Iphone13ProPage openIphone13ProPage(){

        driver.findElement(iphone13ProPageSelector).click();

        Iphone13ProPage iphone13ProPage = new Iphone13ProPage(driver);
        return iphone13ProPage;
    }

}
