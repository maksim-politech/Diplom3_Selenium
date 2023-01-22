package pom;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage {

    private final WebDriver driver;
    private final String url = "https://stellarburgers.nomoreparties.site/register";
    private final By nameField = By.xpath (".//*[text()='Имя']/../*[@type='text']");
    private final By emailField = By.xpath (".//*[text()='Email']/../*[@type='text']");
    private final By passwordField =By.xpath(".//input[@class='text input__textfield text_type_main-default' and @type='password']");
    private final By registerButton = By.xpath(".//button[text()='Зарегистрироваться']");

    public final By textAboutIncorrectPassword = By.xpath(".//p[@class='input__error text_type_main-default']");

    public final By textAboutInput =By.xpath (".//h2[text()='Вход']");

    private final By loginButton = By.xpath (".//a[text()='Войти']");
    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get(url);
    }

    public void fillNameField(String name){
        driver.findElement(nameField).sendKeys(name);
    }

    public void fillEmailField(String email){
        driver.findElement(emailField).sendKeys(email);
    }

    public void fillPasswordField(String password){
        driver.findElement(passwordField).sendKeys(password);
    }

    public void fillPasswordFieldWIncorrect(String incorrectPassword){
        driver.findElement(passwordField).sendKeys(incorrectPassword);
    }

    public void clickRegisterButton(){
        driver.findElement(registerButton).click();
    }

    public String getTextAboutIncorrectPassword(){
        return driver.findElement(textAboutIncorrectPassword).getText();
    }

    public String getTextAboutInput(){
        return driver.findElement(textAboutInput).getText();
    }

    public void clickLoginButton(){
        driver.findElement(loginButton).click();
    }
}
