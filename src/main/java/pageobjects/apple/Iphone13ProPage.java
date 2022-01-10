package pageobjects.apple;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Iphone13ProPage {

    WebDriver driver;
    By selectIphone13ProMaxSelector = By.cssSelector(".ac-ln-button");

    public Iphone13ProPage(WebDriver driver){

        this.driver=driver;
    }

    public BuyIphonePro13Page buy(){

        driver.findElement(selectIphone13ProMaxSelector).click();
        BuyIphonePro13Page buyIphonePro13Page = new BuyIphonePro13Page(driver);
        return buyIphonePro13Page;
    }


}
