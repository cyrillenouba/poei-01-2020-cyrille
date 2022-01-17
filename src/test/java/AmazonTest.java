import io.cucumber.java.en.Given;
import org.testng.annotations.Test;
import pageobjects.amazon.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.Test;

public class AmazonTest {

    WebDriver driver;
   // @BeforeMethod
    public void setup(){

        driver = new ChromeDriver();
        driver.get("https://www.amazon.fr");
        driver.manage().window().maximize();
        driver.findElement(By.id("sp-cc-accept")).click();


    }



   // @Test


    public void laptopAddToCartPriceTest(){
        //Arrange

        String productName = "HP Chromebook x360 14a-ca0000sf";
         String expectedPrice="369,00 €";

        MainPage mainPage = new MainPage(driver);
        mainPage.searchProduct(productName);

        SearchResultPage searchResultPage=new SearchResultPage(driver);
        searchResultPage.openResult(0);

       PruductPage pruductPage = new PruductPage(driver);
        pruductPage.addToCart();
        pruductPage.noCoverrage();

        ConfirmationAddToCartPage confirmationAddToCartPage = new ConfirmationAddToCartPage(driver);
        confirmationAddToCartPage.openCart();

        CartPage cartPage = new CartPage(driver);
        cartPage.getProductPrice(0);
        cartPage.getActiveCarSubtotal();
        cartPage.getBuyboxCartSubtotal();

//Assert
        //Assert.assertEquals(cartPage.getProductPrice(0),expectedPrice);

    }


    //@AfterMethod
    public void teardown(){

        driver.quit();
    }
}
