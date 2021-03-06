import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class tp1 {

    WebDriver driver;

    @BeforeMethod
    public void setup(){


        driver = new ChromeDriver();
        //attends que l'element soit present dans le code html
      //  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        driver.get("https://www.amazon.fr");
        driver.manage().window().maximize();
        //fermer cookies
        WebElement buttonCookies = driver.findElement(By.id("sp-cc-accept"));
        buttonCookies.click();

    }



    @Test
    public  void test1(){


    WebElement barreRecherche = driver.findElement(By.id("twotabsearchtextbox"));
    barreRecherche.sendKeys("machine a raclette");
    barreRecherche.sendKeys(Keys.ENTER);


    }

    @Test
    public void test2(){

        WebElement barreRecherche = driver.findElement(By.id("twotabsearchtextbox"));
        barreRecherche.sendKeys("machine a raclette");
        barreRecherche.sendKeys(Keys.ENTER);

        //yere is implicit wait



        WebElement firstElement = driver.findElement(By.cssSelector("[data-cel-widget='search_result_1']"));
        firstElement.click();
      //
        WebElement addProduct = driver.findElement(By.cssSelector("[aria-labelledby='submit.add-to-cart-announce']"));
        addProduct.click();




    }
    @Test
    public  void testLivres(){

driver.findElement(By.id("nav-hamburger-menu")).click();
WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10)) ;
wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".hmenu-item[data-menu-id='10']")));
driver.findElement(By.cssSelector(".hmenu-item[data-menu-id='10']")).click();
wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("ul.hmenu-visible>li:nth-child(3)")));
driver.findElement(By.cssSelector("ul.hmenu-visible>li:nth-child(3)")).click();

    }

    @Test
    public void testMultipleElements(){

        //ArranreActAction

        int expectedNumberOfResult = 60;
        String keyword = "machine a raclette";
        int timeoutSearchLoad=10;
        By searchBarSelector = By.id("twotabsearchtextbox");
        By searchResultSelector = By.cssSelector("[data-component-type='s-search-result']");



        //action

        WebElement barreRecherche = driver.findElement(searchBarSelector);
        barreRecherche.sendKeys(keyword + Keys.ENTER);

        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(timeoutSearchLoad)) ;
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchResultSelector));

        List<WebElement> listeDeResultat = driver.findElements(searchResultSelector);
        //listeDeResultat.get(0).click();

//assert

        Assert.assertEquals(listeDeResultat.size(),expectedNumberOfResult,"the number of search is no correct");

    }


    @AfterMethod
    public  void tearDown() {
        driver.quit();

    }
}
