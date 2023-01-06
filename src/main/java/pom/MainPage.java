package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {

    private final WebDriver driver;
    private final String url = "https://stellarburgers.nomoreparties.site/";

    private final By loginButton = By.xpath(".//button[text()='Войти в аккаунт']");

    private final By AccountButton = By.xpath(".//a[@href='/account']");

    private final By SauceButton = By.xpath(".//span[text()='Соусы']");
    private final By BulkiButton = By.xpath(".//span[text()='Булки']");
    private final By NachinkiButton = By.xpath(".//span[text()='Начинки']");

   public final By TextFromConstructorBulki = By.xpath(".//h2[text()='Булки']");

   public final By TextFromConstructorSauce = By.xpath(".//h2[text()='Соусы']");

   public final By TextFromConstructorNachinki = By.xpath(".//h2[text()='Начинки']");
    public MainPage(WebDriver driver) {
        this.driver = driver;
    }
    public void open() {
        driver.get(url);
    }

    public void clickLoginButton(){
        driver.findElement(loginButton).click();
    }

    public void clickAccountButton(){
        driver.findElement(AccountButton).click();
    }

    public void clickSauceButton(){
        driver.findElement(SauceButton).click();
    }

    public void clickBulkiButton(){
        driver.findElement(BulkiButton).click();
    }

    public void clickNachinkiButton(){
        driver.findElement(NachinkiButton).click();
    }


    public String getTextFromConstructorBulki(){
         return driver.findElement(TextFromConstructorBulki).getText();
    }
    public String getFromConstructorSauce(){
        return driver.findElement(TextFromConstructorSauce).getText();
    }
    public String getTextFromConstructorNachinki(){
        return driver.findElement(TextFromConstructorNachinki).getText();
    }
}
