import io.github.bonigarcia.wdm.WebDriverManager;
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

    @Before
    public void startUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
    }

    @Test
    public void LoginTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        driver.manage().window().maximize();
        loginPage.fillEmailField();
        loginPage.fillPasswordField();
        loginPage.clickLoginButton();
        Assert.assertEquals("Соберите бургер", driver.findElement(By.xpath (".//h1[text()='Соберите бургер']")).getText());
    }

    @Test
    public void LoginFromPasswordRecoveryTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        loginPage.scrollPasswordRecoveryButton();
        loginPage.clickPasswordRecoveryButton();
        driver.findElement(By.xpath (".//a[text()='Войти']")).click(); //не стал ради одного локатора создавать pom для этой страницы восстановления
        loginPage.fillEmailField();
        loginPage.fillPasswordField();
        loginPage.clickLoginButton();
        Assert.assertEquals("Соберите бургер", driver.findElement(By.xpath (".//h1[text()='Соберите бургер']")).getText());
    }

    @Test
    public void LoginFromRegisterPageTest() {
        LoginPage loginPage = new LoginPage(driver);
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.open();
        //driver.manage().window().maximize();
        driver.findElement(By.xpath(".//a[text()='Войти']")).click();
        loginPage.fillEmailField();
        loginPage.fillPasswordField();
        loginPage.clickLoginButton();
        Assert.assertEquals("Соберите бургер", driver.findElement(By.xpath(".//h1[text()='Соберите бургер']")).getText());
    }

    @Test
    public void LoginFromMainPageTest() {
        MainPage mainPage= new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        mainPage.open();
        //driver.manage().window().maximize();
        mainPage.clickLoginButton();
        loginPage.fillEmailField();
        loginPage.fillPasswordField();
        loginPage.clickLoginButton();
        Assert.assertEquals("Соберите бургер", driver.findElement(By.xpath(".//h1[text()='Соберите бургер']")).getText());
    }

    @Test
    public void LoginFromAccountTest() {
        MainPage mainPage= new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        mainPage.open();
        //driver.manage().window().maximize();
        mainPage.clickAccountButton();
        loginPage.fillEmailField();
        loginPage.fillPasswordField();
        loginPage.clickLoginButton();
        Assert.assertEquals("Соберите бургер", driver.findElement(By.xpath(".//h1[text()='Соберите бургер']")).getText());
    }
    @After
    public void tearDown() {
        driver.quit();
    }

}
