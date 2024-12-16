package PageClasses;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainMenu {
    WebDriver driver;

    private By loginSignupbtn = By.xpath("//a[@href='/login']");
    private By deletebtn = By.xpath("//a[@href='/delete_account']");

    public MainMenu(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Click on login/signup button")
    public void ClickOnLoginOrSignupButton() {
        //click login/signup button
        driver.findElement(loginSignupbtn).click();
    }

    @Step("Click on delete button")
    public void ClickOnDeleteButton() {
        //click delete button
        driver.findElement(deletebtn).click();
    }
}
