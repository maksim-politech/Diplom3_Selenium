import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pom.AccountProfilePage;
import pom.LoginPage;
import pom.MainPage;

import java.util.concurrent.TimeUnit;

public class SiteTransitionsTest {

    private WebDriver driver;

    @Before
    public void startUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
    }


    @Test
    public void AccountTransitionTest() {
        LoginPage loginPage = new LoginPage(driver);
        MainPage mainPage= new MainPage(driver);
        loginPage.open();
        driver.manage().window().maximize();
        loginPage.fillEmailField();
        loginPage.fillPasswordField();
        loginPage.clickLoginButton();
        mainPage.clickAccountButton();
        Assert.assertEquals("Профиль", driver.findElement(By.xpath (".//a[text()='Профиль']")).getText());
    }

    @Test
    public void LogOutTransitionTest() {
        AccountProfilePage accountProfilePage = new AccountProfilePage(driver);
        MainPage mainPage= new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        driver.manage().window().maximize();
        loginPage.fillEmailField();
        loginPage.fillPasswordField();
        loginPage.clickLoginButton();
        mainPage.clickAccountButton();
        accountProfilePage.clickLogOutButton();
        Assert.assertEquals("Вход", driver.findElement(By.xpath (".//h2[text()='Вход']")).getText());
    }

    @Test
    public void ConstructorTransitionTest() {
        AccountProfilePage accountProfilePage = new AccountProfilePage(driver);
        MainPage mainPage= new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        loginPage.fillEmailField();
        loginPage.fillPasswordField();
        loginPage.clickLoginButton();
        mainPage.clickAccountButton();
        accountProfilePage.clickLogOutButton();
        accountProfilePage.clickConstructorButton();
        Assert.assertEquals("Соберите бургер", driver.findElement(By.xpath(".//h1[text()='Соберите бургер']")).getText());
    }

    @Test
    public void SauceTransitionTest() {
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        driver.manage().window().maximize();
        loginPage.fillEmailField();
        loginPage.fillPasswordField();
        loginPage.clickLoginButton();
        mainPage.clickSauceButton();
        Assert.assertEquals("Соусы", mainPage.getFromConstructorSauce());
    }

        @Test
        public void BulkiTransitionTest() {
            MainPage mainPage = new MainPage(driver);
            LoginPage loginPage = new LoginPage(driver);
            loginPage.open();
            driver.manage().window().maximize();
            loginPage.fillEmailField();
            loginPage.fillPasswordField();
            loginPage.clickLoginButton();
            mainPage.clickSauceButton();
            mainPage.clickBulkiButton();
            Assert.assertEquals("Булки", mainPage.getTextFromConstructorBulki());
        }

    @Test
    public void NachinkiTransitionTest() {
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        driver.manage().window().maximize();
        loginPage.fillEmailField();
        loginPage.fillPasswordField();
        loginPage.clickLoginButton();
        mainPage.clickNachinkiButton();
        Assert.assertEquals("Начинки", mainPage.getTextFromConstructorNachinki());
    }


    @After
    public void tearDown() {
    driver.quit();
    }

}

