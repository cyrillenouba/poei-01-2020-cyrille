package steps.amazon;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageobjects.amazon.MainPage;


public class MainPageSteps {

    WebDriver driver;
    @Given("utilisateur est sur la  page Acceuil amazon")
    public void connexionPageAcceuil() {
        driver = new ChromeDriver();
        driver.get("https://www.amazon.fr");
        driver.manage().window().maximize();
        driver.findElement(By.id("sp-cc-accept")).click();
       // throw new io.cucumber.java.PendingException();
    }

    /*@Given("utilisateur est sur la  page Acceuil amazon")
    public void utilisateur_est_sur_la_page_Acceuil_amazon() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }*/

    @When("l utilsateur saisie l'article voulu et valide")
    public void lUtilsateurSaisieLArticleVouluEtValide() {
        String productName = "HP Chromebook x360 14a-ca0000sf";
        String expectedPrice="369,00 €";

        MainPage mainPage = new MainPage(driver);
        mainPage.searchProduct(productName);
    }


    @Then("la liste des produits apparait")
    public void laListeDesProduitsApparait() {
        System.out.println("bienvenue page accueil");
    }
}
