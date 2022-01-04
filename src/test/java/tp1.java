import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class tp1 {
//System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");

    @Test
    public  void test1(){

        //System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
    WebDriver driver = new ChromeDriver();
    driver.get("https://www.amazon.fr");
    driver.manage().window().maximize();
    //fermer cookies
        WebElement buttonCookies = driver.findElement(By.id("sp-cc-accept"));
        buttonCookies.click();
    WebElement barreRecherche = driver.findElement(By.id("twotabsearchtextbox"));
    barreRecherche.sendKeys("machine a raclette");
    barreRecherche.sendKeys(Keys.ENTER);
    driver.quit();

    }

    @Test
    public void test2(){

    }
}
