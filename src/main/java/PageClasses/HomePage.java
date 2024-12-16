package PageClasses;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    //Action Methods
    @Step("Navigate to home page")
    public void NavigateToHomepage() {
        //navigate
        driver.navigate().to("http://automationexercise.com");
    }
}
