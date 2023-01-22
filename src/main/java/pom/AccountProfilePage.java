package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountProfilePage {

    private final WebDriver driver;

    private final By ConstructorButton = By.xpath(".//a[@href='/']");
    private final By LogOutButton = By.xpath(".//button[text()='Выход']");

    private final By textHeaderPage = By.xpath (".//a[text()='Профиль']");

    public AccountProfilePage(WebDriver driver) {
        this.driver = driver;
    }


    public void clickConstructorButton(){
        driver.findElement(ConstructorButton).click();
    }

    public void clickLogOutButton(){
        driver.findElement(LogOutButton).click();
    }

    public String getTextHeaderPage(){
        return driver.findElement(textHeaderPage).getText();
    }

}
