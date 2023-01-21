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
import pom.RegisterPage;

import java.util.concurrent.TimeUnit;

public class SiteTransitionsTest {

    private WebDriver driver;
    private String expectedTextHeaderPage = "Профиль";
    private String expectedTextAfterLogin = "Соберите бургер";
    private String expectedTextInput = "Вход";
    private String expectedTextSauce = "Соусы";
    private String expectedTextBulki = "Булки";
    private String expectedTextNachinki = "Начинки";
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
        AccountProfilePage accountProfilePage = new AccountProfilePage(driver);
        loginPage.open();
        driver.manage().window().maximize();
        loginPage.fillEmailField();
        loginPage.fillPasswordField();
        loginPage.clickLoginButton();
        mainPage.clickAccountButton();
        Assert.assertEquals(expectedTextHeaderPage, accountProfilePage.getTextHeaderPage());
    }

    @Test
    public void LogOutTransitionTest() {
        AccountProfilePage accountProfilePage = new AccountProfilePage(driver);
        MainPage mainPage= new MainPage(driver);
        RegisterPage registerPage = new RegisterPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        driver.manage().window().maximize();
        loginPage.fillEmailField();
        loginPage.fillPasswordField();
        loginPage.clickLoginButton();
        mainPage.clickAccountButton();
        accountProfilePage.clickLogOutButton();
        Assert.assertEquals(expectedTextInput, registerPage.getTextAboutInput());
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
        Assert.assertEquals(expectedTextAfterLogin, mainPage.getTextAfterLogin());
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
        Assert.assertEquals(expectedTextSauce, mainPage.getFromConstructorSauce());
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
            Assert.assertEquals(expectedTextBulki, mainPage.getTextFromConstructorBulki());
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
        Assert.assertEquals(expectedTextNachinki, mainPage.getTextFromConstructorNachinki());
    }


    @After
    public void tearDown() {
    driver.quit();
    }

}

