import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import pageobjects.apple.CartPage;
import pageobjects.apple.MainPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AppleTests {

    WebDriver driver;
    @BeforeMethod
    public void setup(){

        driver = new ChromeDriver();
        driver.get("https://www.apple.com/fr");
        driver.manage().window().maximize();




    }

    @Test

    public void openIphonePage(){


        MainPage mainPage = new MainPage(driver);

        CartPage cartPage = mainPage.openIphonePage()
                .openIphone13ProPage().
                buy()
                .SelectIphonePro13Max()
                .SelectIphonePro13Max()
                .selectBlueAplin()
                .select256go()
                .noAppleTrading()
                .addToCart()
                .openCartPage();


        String expectedPrice = "1 379,00";
        String productName = cartPage.getProductName(0);
        String expectedName = "iPhone 13 Pro Max 256 Go Bleu Alpin";
        String cartTitle = cartPage.getCartTitle();
        String productPrice = cartPage.getProductPrice(0);
        String subTotal = cartPage.getSubTotal();
        String totalPrice = cartPage.getTotal();


        System.out.println(cartPage.getProductPrice(0));
        System.out.println("ecpectedprice"+expectedPrice);
        Assert.assertEquals(productName, expectedName);
        Assert.assertTrue(cartTitle.contains(expectedPrice), "The Cart price Title is not the same");
        Assert.assertTrue(productPrice.contains(expectedPrice), "The Product price is not the same");
        Assert.assertTrue(subTotal.contains(expectedPrice), "The subtotal is not the same");
        Assert.assertTrue(cartTitle.contains(expectedPrice), "The Total is not the same");





    }
    @AfterMethod
    public void teardown() {

        driver.quit();

    }

}
