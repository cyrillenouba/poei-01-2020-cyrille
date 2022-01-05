import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class tp1 {

    WebDriver driver;

    @BeforeMethod
    public void setup(){


        driver = new ChromeDriver();
        //les methode findElement attende 2s avant de
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
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
    @AfterMethod
    public  void tearDown() {
        driver.quit();

    }
}
