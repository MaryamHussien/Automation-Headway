package PageClasses;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginSignup {
    WebDriver driver;

    public LoginSignup(WebDriver driver) {
        this.driver = driver;
    }

    private By SignupName = By.xpath("//input[@data-qa='signup-name']");
    private By SignupEmail = By.xpath("//input[@data-qa='signup-email']");
    private By SignupButton = By.xpath("//button[@data-qa='signup-button']");

    //Action Methods
    public void NavigateToLogin() {
        //navigate
        driver.navigate().to("https://automationexercise.com/login");
    }

    @Step("Fill signup data")
    public LoginSignup FillSignupData(String name, String email) {
        //Fill sign up data and click signup button
        driver.findElement(SignupName).sendKeys(name);
        driver.findElement(SignupEmail).sendKeys(email);
        return this;
    }
    @Step("Click on signup button")
    public void ClickOnSignupButton() {
        //click signup button
        driver.findElement(SignupButton).click();

    }
}
