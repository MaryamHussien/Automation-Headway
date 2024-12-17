package Demos;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.*;
import utilities.DriverFactory;

public class TestNG {

    WebDriver driver;
    JavascriptExecutor js;

    private By SignupName = By.xpath("//input[@data-qa='signup-name']");
    private By loginSignupbtn = By.xpath("//a[@href='/login']");
    private By SignupEmail = By.xpath("//input[@data-qa='signup-email']");
    private By SignupButton = By.xpath("//button[@data-qa='signup-button']");
    private By dayDropdown = By.id("days");
    private By monthDropdown = By.id("months");
    private By yearDropdown = By.id("years");
    private By countryDropdown = By.id("country");
    private By continuebtn = By.xpath("//a[@data-qa='continue-button']");
    private By deletebtn = By.xpath("//a[@href='/delete_account']");
    private By mrsRadiobtn = By.id("id_gender2");
    private By password = By.xpath("//input[@data-qa='password']");
    private By FirstName = By.id("first_name");
    private By lastName = By.id("last_name");
    private By company = By.id("company");
    private By address1 = By.id("address1");
    private By address2 = By.id("address2");
    private By state = By.id("state");
    private By city = By.id("city");
    private By ZipCode = By.id("zipcode");
    private By mobileNumber = By.id("mobile_number");
    private By createAccountMessage = By.xpath("//h2[@class='title text-center']");
    private By deleteAccountMessage = By.xpath("//h2[@class='title text-center']");

    @Test
    public void Test() {
        Navigate();
        ClickOnLoginOrSignupButton();

        FillSignupData();
        ClickOnSignupButton();

        FillCreateAccountData();
        ClickOnCreateAccountButton();

        AssertCreateAccount();
        ClickOnContinueButton();

        ClickOnDeleteButton();
        AssertDeleteAccount();
        ClickOnContinueButton();
    }

    @BeforeClass
    public void BeforeClass() {
        driver = DriverFactory.initiateDriver(System.getProperty("browserName"), System.getProperty("headless"), true);
        js = (JavascriptExecutor) driver;
        //maximize
        driver.manage().window().maximize();
    }

    @AfterClass
    public void AfterClass() {
        driver.quit();
    }

    //Methods
    private void Navigate() {
        //navigate
        driver.navigate().to("http://automationexercise.com");
    }

    private void ClickOnLoginOrSignupButton() {
        //click login/signup button
        driver.findElement(loginSignupbtn).click();
    }

    private void FillSignupData() {
        //Fill sign up data and click signup button
        driver.findElement(SignupName).sendKeys("m");
        driver.findElement(SignupEmail).sendKeys("mariammm@gmail.com");
    }

    private void ClickOnSignupButton() {
        //click signup button
        driver.findElement(SignupButton).click();

    }

    private void FillCreateAccountData() {
        //radio button
        driver.findElement(mrsRadiobtn).click();

        //dropdowns
        (new Select(driver.findElement(dayDropdown))).selectByVisibleText("22");
        (new Select(driver.findElement(monthDropdown))).selectByVisibleText("May");
        (new Select(driver.findElement(yearDropdown))).selectByVisibleText("2001");
        (new Select(driver.findElement(countryDropdown))).selectByVisibleText("Canada");

        //checkboxes
        js.executeScript("document.getElementById(\"newsletter\").click()");
        js.executeScript("document.getElementById(\"optin\").click()");
        //driver.findElement(By.id("newsletter")).click();
        //driver.findElement(By.id("optin")).click();

        //data
        driver.findElement(password).sendKeys("password123");
        driver.findElement(FirstName).sendKeys("m");
        driver.findElement(lastName).sendKeys("m");
        driver.findElement(company).sendKeys("m");
        driver.findElement(address1).sendKeys("m");
        driver.findElement(address2).sendKeys("m");
        driver.findElement(state).sendKeys("m");
        driver.findElement(city).sendKeys("m");
        driver.findElement(ZipCode).sendKeys("00000");
        driver.findElement(mobileNumber).sendKeys("01111111111");

        //driver.findElement(By.xpath("//button[@data-qa='create-account']")).click();
        js.executeScript("document.getElementsByClassName(\"btn btn-default\")[0].click()");  //create account button using js
    }

    private void ClickOnCreateAccountButton() {
        //driver.findElement(By.xpath("//button[@data-qa='create-account']")).click();
        js.executeScript("document.getElementsByClassName(\"btn btn-default\")[0].click()");  //create account button using js
    }

    private void AssertCreateAccount() {
        //System.out.println(driver.findElement(By.xpath("//h2[@class='title text-center']")).getText()); //ACCOUNT CREATED!
        Assert.assertTrue(driver.findElement(createAccountMessage).getText().contains("CREATED"));

    }

    private void ClickOnContinueButton() {
        //click continue button
        driver.findElement(continuebtn).click();

    }

    private void AssertDeleteAccount() {
        Assert.assertTrue(driver.findElement(deleteAccountMessage).getText().contains("DELETED"));
        //System.out.println(driver.findElement(By.xpath("//h2[@class='title text-center']")).getText()); //ACCOUNT DELETED!

    }

    private void ClickOnDeleteButton() {
        //click delete button
        driver.findElement(deletebtn).click();

    }


}