import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

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

    public void nSwitchAddToCartPriceTest(){
        //Arrange

        String productName = "Nitendo Switch Oled";

        MainPage mainPage = new MainPage(driver);
        mainPage.searchProduct(productName);
        SearchResultPage searchResultPage=new SearchResultPage(driver);
        searchResultPage.openResult(1);

        PruductPage pruductPage = new PruductPage(driver);
        pruductPage.addToCart();
        pruductPage.noCoverrage();

    }

    @Test

    public void machineAracletteTest(){
        //Arrange

        String productName = "Machine a raclette";
//ACt
        MainPage mainPage = new MainPage(driver);
        mainPage.searchProduct(productName);

    }
    @AfterMethod
    public void teardown(){

        driver.quit();
    }
}
