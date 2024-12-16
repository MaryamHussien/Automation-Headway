package PageClasses;

import io.qameta.allure.Step;
import jdk.jfr.Description;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class CreateAccount {
    WebDriver driver;
    JavascriptExecutor js;

    private By dayDropdown = By.id("days");
    private By monthDropdown = By.id("months");
    private By yearDropdown = By.id("years");
    private By countryDropdown = By.id("country");
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

    public CreateAccount(WebDriver driver, JavascriptExecutor js) {
        this.driver = driver;
        this.js = js;
    }

    //Action Methods
    public void NavigateTOCreateAccount() {
        //navigate
        driver.navigate().to("https://automationexercise.com/signup");
    }

    @Step("Fill Account Information Data")
    public CreateAccount FillAccountInformationData(String firstname, String lastname, String Password, String day, String month, String year, String MobileNumber) {
        //radio button
        driver.findElement(mrsRadiobtn).click();

        //dropdowns
        (new Select(driver.findElement(dayDropdown))).selectByVisibleText(day);
        (new Select(driver.findElement(monthDropdown))).selectByVisibleText(month);
        (new Select(driver.findElement(yearDropdown))).selectByVisibleText(year);

        //data
        driver.findElement(password).sendKeys(Password);
        driver.findElement(FirstName).sendKeys(firstname);
        driver.findElement(lastName).sendKeys(lastname);
        driver.findElement(mobileNumber).sendKeys(MobileNumber);

        //driver.findElement(By.xpath("//button[@data-qa='create-account']")).click();
        //js.executeScript("document.getElementsByClassName(\"btn btn-default\")[0].click()");  //create account button using js
        return this;
    }

    @Step("Fill Account Address Data")
    public CreateAccount FillAddressInformationData(String country, String State, String Address1, String Address2, String City, String zipcode, String Company) {
        //dropdown
        (new Select(driver.findElement(countryDropdown))).selectByVisibleText(country);

        driver.findElement(company).sendKeys(Company);
        driver.findElement(address1).sendKeys(Address1);
        driver.findElement(address2).sendKeys(Address2);
        driver.findElement(state).sendKeys(State);
        driver.findElement(city).sendKeys(City);
        driver.findElement(ZipCode).sendKeys(zipcode);

        return this;
    }

    @Step("Clicking on Newsletter checkbox")
    public CreateAccount ClickOnCheckboxNewsletter() {
        //driver.findElement(By.id("newsletter")).click();
        js.executeScript("document.getElementById(\"newsletter\").click()");
        return this;
    }

    @Step("Clicking on Options checkbox")
    public CreateAccount ClickOnCheckboxOptions() {
        //driver.findElement(By.id("optin")).click();
        js.executeScript("document.getElementById(\"optin\").click()");
        return this;
    }

    @Step("Click on Create account button")
    public void ClickOnCreateAccountButton() {
        //driver.findElement(By.xpath("//button[@data-qa='create-account']")).click();
        js.executeScript("document.getElementsByClassName(\"btn btn-default\")[0].click()");  //create account button using js
    }

}
