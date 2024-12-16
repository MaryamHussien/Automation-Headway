package PageClasses;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CreateAccountContinue {
    WebDriver driver;

    private By createAccountMessage = By.xpath("//h2[@class='title text-center']");
    private By continuebtn = By.xpath("//a[@data-qa='continue-button']");

    public CreateAccountContinue(WebDriver driver) {
        this.driver = driver;
    }

    //Action Methods
    public void NavigateToAccountCreated() {
        //navigate
        driver.navigate().to("https://automationexercise.com/account_created");
    }

    @Step("Assertion that account is created successfully")
    public CreateAccountContinue AssertCreateAccount() {
        //System.out.println(driver.findElement(By.xpath("//h2[@class='title text-center']")).getText()); //ACCOUNT CREATED!
        Assert.assertTrue(driver.findElement(createAccountMessage).getText().contains("CREATED"));
        return this;
    }

    @Step("Click on continue button")
    public void ClickOnContinueButton() {
        //click continue button
        driver.findElement(continuebtn).click();

    }
}
