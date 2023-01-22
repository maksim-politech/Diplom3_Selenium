import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.lang3.RandomStringUtils;
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
    private String name;
    private String email;
    private String password;
    private String incorrectPassword;
    @Before
    public void startUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);

        name="Максим";
        email=(RandomStringUtils.randomAlphanumeric(5))+"@mail.ru";
        password= "fw34252fe2";
        incorrectPassword="12345";
    }

    @Test
    public void registrationTest() {
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.open();
        registerPage.fillNameField(name);
        registerPage.fillEmailField(email);
        registerPage.fillPasswordField(password);
        registerPage.clickRegisterButton();
        Assert.assertEquals(expectedTextInput,  registerPage.getTextAboutInput());
    }

    @Test
    public void registrationWIncorrectPasswordTest(){
        RegisterPage registerPage= new RegisterPage(driver);
        registerPage.open();
        registerPage.fillNameField(name);
        registerPage.fillEmailField(email);
        registerPage.fillPasswordFieldWIncorrect(incorrectPassword);
        registerPage.clickRegisterButton();
        Assert.assertEquals(expectedTextAboutIncorrectPassword, registerPage.getTextAboutIncorrectPassword());
    }

    @After
    public void tearDown() {
        driver.quit();
    }

}
