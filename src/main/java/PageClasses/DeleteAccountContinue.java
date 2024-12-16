package PageClasses;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class DeleteAccountContinue {
    WebDriver driver;

    private By continuebtn = By.xpath("//a[@data-qa='continue-button']");
    private By deleteAccountMessage = By.xpath("//h2[@class='title text-center']");

    public DeleteAccountContinue(WebDriver driver) {
        this.driver = driver;
    }

    //Action Methods
    public void NavigateToDeleteAccount() {
        //navigate
        driver.navigate().to("https://automationexercise.com/delete_account");
    }

    @Step("Click on continue button")
    public void ClickOnContinueButton() {
        //click continue button
        driver.findElement(continuebtn).click();
    }
    @Step("Assertion that account is deleted successfully")
    public DeleteAccountContinue AssertDeleteAccount() {
        Assert.assertTrue(driver.findElement(deleteAccountMessage).getText().contains("DELETED"));
        //System.out.println(driver.findElement(By.xpath("//h2[@class='title text-center']")).getText()); //ACCOUNT DELETED!
        return this;
    }
}
