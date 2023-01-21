import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pom.RegisterPage;

import java.util.concurrent.TimeUnit;

public class RegisterTest {
    private String expectedTextInput = "Вход";
    private String expectedTextAboutIncorrectPassword = "Некорректный пароль";
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
    public void registrationTest() {
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.open();
        registerPage.fillNameField();
        registerPage.fillEmailField();
        registerPage.fillPasswordField();
        registerPage.clickRegisterButton();
        Assert.assertEquals(expectedTextInput,  registerPage.getTextAboutInput());
    }

    @Test
    public void registrationWIncorrectPasswordTest(){
        RegisterPage registerPage= new RegisterPage(driver);
        registerPage.open();
        registerPage.fillNameField();
        registerPage.fillEmailField();
        registerPage.fillPasswordFieldWIncorrect();
        registerPage.clickRegisterButton();
        Assert.assertEquals(expectedTextAboutIncorrectPassword, registerPage.getTextAboutIncorrectPassword());
    }

    @After
    public void tearDown() {
        driver.quit();
    }

}
