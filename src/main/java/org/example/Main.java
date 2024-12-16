package org.example;

import dev.failsafe.internal.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Main {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        //maximize
        driver.manage().window().maximize();

        //navigate
        driver.navigate().to("http://automationexercise.com");

        //click login
        driver.findElement(By.xpath("//a[@href='/login']")).click();

        //Fill sign up data and click button
        driver.findElement(By.xpath("//input[@data-qa='signup-name']")).sendKeys("m");
        driver.findElement(By.xpath("//input[@data-qa='signup-email']")).sendKeys("mariaqqqq@gmail.com");
        driver.findElement(By.xpath("//button[@data-qa='signup-button']")).click();

        //Fill create account data
        //radio button
        driver.findElement(By.id("id_gender2")).click();
        driver.findElement(By.xpath("//input[@data-qa='password']")).sendKeys("password123");

        //dropdowns
        WebElement day = driver.findElement(By.id("days"));
        Select dSelect = new Select(day);
        dSelect.selectByVisibleText("22");

        WebElement month = driver.findElement(By.id("months"));
        Select mSelect = new Select(month);
        mSelect.selectByVisibleText("May");

        WebElement year = driver.findElement(By.id("years"));
        Select ySelect = new Select(year);
        ySelect.selectByVisibleText("2001");

        //checkbox1
        driver.findElement(By.id("newsletter")).click();

        //checkbox2
        driver.findElement(By.id("optin")).click();
        //driver.findElement(By.xpath("//input/[@name='newsletter']")).click();
        //driver.findElement(By.xpath("//input[@name='optin']")).click();

        //data
        driver.findElement(By.id("first_name")).sendKeys("m");
        driver.findElement(By.id("last_name")).sendKeys("m");
        driver.findElement(By.id("company")).sendKeys("m");
        driver.findElement(By.id("address1")).sendKeys("m");
        driver.findElement(By.id("address2")).sendKeys("m");

        //dropdown
        WebElement country = driver.findElement(By.id("country"));
        Select cSelect = new Select(country);
        cSelect.selectByVisibleText("Canada");

        //data
        driver.findElement(By.id("state")).sendKeys("m");
        driver.findElement(By.id("city")).sendKeys("m");
        driver.findElement(By.id("zipcode")).sendKeys("00000");
        driver.findElement(By.id("mobile_number")).sendKeys("01111111111");

        //create account button
        driver.findElement(By.xpath("//button[@data-qa='create-account']")).click();

        //continue
        driver.findElement(By.xpath("//a[@data-qa='continue-button']")).click();

        //delete
        driver.findElement(By.xpath("//a[@href='/delete_account']")).click();

        //continue
        driver.findElement(By.xpath("//a[@data-qa='continue-button']")).click();

    }
}