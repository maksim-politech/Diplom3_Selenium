package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage {

    private final WebDriver driver;
    private final String url = "https://stellarburgers.nomoreparties.site/register";
    private final By nameField = By.xpath (".//*[text()='Имя']/../*[@type='text']");
    private final By emailField = By.xpath (".//*[text()='Email']/../*[@type='text']");
    private final By passwordField =By.xpath(".//input[@class='text input__textfield text_type_main-default' and @type='password']");
    private final By registerButton = By.xpath(".//button[text()='Зарегистрироваться']");

    public final By TextAboutIncorrectPassword = By.xpath(".//p[@class='input__error text_type_main-default']");

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get(url);
    }

    public void fillNameField(){
        driver.findElement(nameField).sendKeys("Максим");
    }

    public void fillEmailField(){
        driver.findElement(emailField).sendKeys("Test234WHEfg@mail.ru");
    }

    public void fillPasswordField(){
        driver.findElement(passwordField).sendKeys("fw34252fe2");
    }

    public void fillPasswordFieldWIncorrect(){
        driver.findElement(passwordField).sendKeys("12345");
    }

    public void clickRegisterButton(){
        driver.findElement(registerButton).click();
    }

    public String getTextAboutIncorrectPassword(){
        return driver.findElement(TextAboutIncorrectPassword).getText();
    }
}
