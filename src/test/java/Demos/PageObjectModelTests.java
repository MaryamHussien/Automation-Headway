package Demos;

import PageClasses.*;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilities.DriverFactory;
import utilities.JsonFileManager;


public class PageObjectModelTests {
    WebDriver driver;
    JavascriptExecutor js;
    private JsonFileManager jsonFileManager;

    @Test
    @Description("Register new user testcase.")
    @Severity(SeverityLevel.BLOCKER)
    public void RegisterUser() {
        new HomePage(driver)
                .NavigateToHomepage();
        new MainMenu(driver)
                .ClickOnLoginOrSignupButton();
        new LoginSignup(driver)
                .FillSignupData(jsonFileManager.getTestData("name"), jsonFileManager.getTestData("email"))
                .ClickOnSignupButton();
        new CreateAccount(driver, js)
                .FillAccountInformationData(jsonFileManager.getTestData("firstname"), jsonFileManager.getTestData("lastname"), "password123", "22", "May", "2001", "01111111111")
                .FillAddressInformationData("Canada", "m", "m", "m", "m", "0000", "m")
                .ClickOnCheckboxNewsletter()
                .ClickOnCheckboxOptions()
                .ClickOnCreateAccountButton();
        new CreateAccountContinue(driver)
                .AssertCreateAccount()
                .ClickOnContinueButton();
        new MainMenu(driver)
                .ClickOnDeleteButton();
        new DeleteAccountContinue(driver)
                .AssertDeleteAccount()
                .ClickOnContinueButton();
    }

    @Test
    @Description("Navigating to signup page")
    @Severity(SeverityLevel.MINOR)
    public void OpenSignupPage() {
        new HomePage(driver)
                .NavigateToHomepage();
        new MainMenu(driver)
                .ClickOnLoginOrSignupButton();
    }


    @BeforeClass
    public void BeforeClass() {
        framework.engine.PropertiesReader.loadProperties();
        driver = DriverFactory.initiateDriver(System.getProperty("browserName"), System.getProperty("headless"), true);
        js = (JavascriptExecutor) driver;
        jsonFileManager = new JsonFileManager("src/test/resources/TestDataJsonFiles/RegisterTestsJsonFile.json");
    }

    @AfterClass
    public void AfterClass() {
        driver.quit();
    }

    @AfterMethod
    public void AfterMethod() {
        driver.close();
    }
}