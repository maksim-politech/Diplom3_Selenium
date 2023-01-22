package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

    private final WebDriver driver;
    private final String url = "https://stellarburgers.nomoreparties.site/login";
    private final By emailField = By.xpath (".//*[text()='Email']/../*[@type='text']");
    private final By passwordField =By.xpath(".//input[@class='text input__textfield text_type_main-default' and @type='password']");
    private final By loginButton = By.xpath("/html/body/div/div/main/div/form/button");
    private final By passwordRecoveryButton = By.xpath(".//a[@href='/forgot-password']");

    private final By loginButtonRecoveryPasswordPage = By.xpath (".//a[text()='Войти']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get(url);
    }

    public void fillEmailField(String email){
        driver.findElement(emailField).sendKeys(email);
    }

    public void fillPasswordField(String password){
        driver.findElement(passwordField).sendKeys(password);
    }


    public void clickLoginButton(){
        driver.findElement(loginButton).click();
    }

    public void clickPasswordRecoveryButton(){
        driver.findElement(passwordRecoveryButton).click();
    }

    public void clickLoginButtonRecoveryPasswordPage(){
        driver.findElement(loginButtonRecoveryPasswordPage).click();
    }

    public void scrollPasswordRecoveryButton() {
        WebElement element = driver.findElement(passwordRecoveryButton);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
    }

}
