package pageobjects.apple;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {

    WebDriver driver;

    By iphonePageSelector = By.cssSelector(".ac-gn-link-iphone");
    public MainPage(WebDriver driver){

        this.driver=driver;
    }

    public IphonePage openIphonePage(){

       driver.findElement(iphonePageSelector).click();

        IphonePage iphonePage = new IphonePage(driver);
        return iphonePage;
    }

}
