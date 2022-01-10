package pageobjects.apple;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {

    WebDriver driver;


    By productNameSelector = By.cssSelector("[data-autom='bag-item-name']");
            By cartTitleSelector = By.cssSelector(".rs-bag-header");//titre
    By productPriceSelector = By.cssSelector(".rs-iteminfo-price");
    By subTotalSelector = By.cssSelector("[data-autom='bagrs-summary-subtotalvalue']");
    By totalSelector = By.cssSelector("[data-autom='bagtotalvalue']");



    public CartPage(WebDriver driver){

        this.driver=driver;
    }
    public String getProductName(int index){



        return driver.findElements(productNameSelector).get(index).getText();
    }


    public String getCartTitle(){



        return driver.findElement(cartTitleSelector).getText();
    }


    public String getProductPrice(int index){



        return driver.findElements(productPriceSelector).get(index).getText();
    }
    public String getSubTotal(){



        return driver.findElement(subTotalSelector).getText();
    }
    public String getTotal(){



        return driver.findElement(totalSelector).getText();
    }



}
