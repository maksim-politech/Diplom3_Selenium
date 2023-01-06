package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountProfilePage {

    private final WebDriver driver;
    private final String url = "https://stellarburgers.nomoreparties.site/account/profile";

    private final By ConstructorButton = By.xpath(".//a[@href='/']");
    private final By LogOutButton = By.xpath(".//button[text()='Выход']");

    public AccountProfilePage(WebDriver driver) {
        this.driver = driver;
    }

    public  void open() {
        driver.get(url);
    }

    public void clickConstructorButton(){
        driver.findElement(ConstructorButton).click();
    }

    public void clickLogOutButton(){
        driver.findElement(LogOutButton).click();
    }

}
