package com.devstack.selenium.ActionCommands;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class KeyboardActionCommandTest {
    static WebDriver driver;
    public static void main(String[] args) throws InterruptedException {
        driver = WebDriverManager.chromedriver().create();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/text-box");
        WebElement userName = waitForElement(By.id("userName"), 5);
        userName.sendKeys("Autotest User1");
        Thread.sleep(2000);
        WebElement userEmail = waitForElement(By.id("userEmail"), 5);
        userEmail.sendKeys("autotestuser1@testmail.com");
        Thread.sleep(2000);
        WebElement currentAddress = waitForElement(By.id("currentAddress"), 5);
        currentAddress.sendKeys("ABCD, EFGH, IJKL, MNOP.");
        Thread.sleep(2000);
        currentAddress.sendKeys(Keys.chord(Keys.COMMAND,"a"));
        Thread.sleep(2000);
        currentAddress.sendKeys(Keys.chord(Keys.COMMAND,"c"));
        Thread.sleep(2000);
        currentAddress.sendKeys(Keys.TAB);
        Thread.sleep(2000);
        WebElement permanentAddress = waitForElement(By.id("permanentAddress"), 5);
        permanentAddress.sendKeys(Keys.chord(Keys.COMMAND,"v"));
        Thread.sleep(2000);

    }

    public static WebElement waitForElement(By element, long time){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }
}
