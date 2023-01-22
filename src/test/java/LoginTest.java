import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pom.LoginPage;
import pom.MainPage;
import pom.RegisterPage;

import java.util.concurrent.TimeUnit;

public class LoginTest {

    private WebDriver driver;
    private String expectedTextAfterLogin = "Соберите бургер";
    private String email;
    private String password;

    @Before
    public void startUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
        email="Test235dfgа235613@mail.ru";
        password= "fw34252fe2";
    }

    @Test
    public void LoginTest() {
        LoginPage loginPage = new LoginPage(driver);
        MainPage mainPage= new MainPage(driver);
        loginPage.open();
        driver.manage().window().maximize();
        loginPage.fillEmailField(email);
        loginPage.fillPasswordField(password);
        loginPage.clickLoginButton();
        Assert.assertEquals(expectedTextAfterLogin, mainPage.getTextAfterLogin());
    }

    @Test
    public void LoginFromPasswordRecoveryTest() {
        LoginPage loginPage = new LoginPage(driver);
        MainPage mainPage= new MainPage(driver);
        loginPage.open();
        loginPage.scrollPasswordRecoveryButton();
        loginPage.clickPasswordRecoveryButton();
        loginPage.clickLoginButtonRecoveryPasswordPage();
        loginPage.fillEmailField(email);
        loginPage.fillPasswordField(password);
        loginPage.clickLoginButton();
        Assert.assertEquals(expectedTextAfterLogin, mainPage.getTextAfterLogin());
    }

    @Test
    public void LoginFromRegisterPageTest() {
        LoginPage loginPage = new LoginPage(driver);
        MainPage mainPage= new MainPage(driver);
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.open();
        registerPage.clickLoginButton();
        loginPage.fillEmailField(email);
        loginPage.fillPasswordField(password);
        loginPage.clickLoginButton();
        Assert.assertEquals(expectedTextAfterLogin, mainPage.getTextAfterLogin());
    }

    @Test
    public void LoginFromMainPageTest() {
        MainPage mainPage= new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        mainPage.open();
        mainPage.clickLoginButton();
        loginPage.fillEmailField(email);
        loginPage.fillPasswordField(password);
        loginPage.clickLoginButton();
        Assert.assertEquals(expectedTextAfterLogin, mainPage.getTextAfterLogin());
    }

    @Test
    public void LoginFromAccountTest() {
        MainPage mainPage= new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        mainPage.open();
        mainPage.clickAccountButton();
        loginPage.fillEmailField(email);
        loginPage.fillPasswordField(password);
        loginPage.clickLoginButton();
        Assert.assertEquals(expectedTextAfterLogin, mainPage.getTextAfterLogin());
    }
    @After
    public void tearDown() {
        driver.quit();
    }

}
