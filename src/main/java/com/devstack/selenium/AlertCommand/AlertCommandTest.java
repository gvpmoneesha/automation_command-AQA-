package com.devstack.selenium.AlertCommand;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AlertCommandTest {
    public static void main(String[] args) throws InterruptedException {
        //alertWithOK();
        // alertWithOKAndCancel();
        alertWithTextBox();
    }

    public static void alertWithOK() throws InterruptedException{
        WebDriver driver = WebDriverManager.chromedriver().create();
        driver.manage().window().maximize();
        driver.get("https://demo.automationtesting.in/Alerts.html");
        driver.findElement(By.xpath("//a[normalize-space(text())='Alert with OK']")).click();
        driver.findElement(By.cssSelector("[class='btn btn-danger']")).click();
        Thread.sleep(3000);
        Alert alert = driver.switchTo().alert();
        System.out.println("Alert Text: " + alert.getText());
        Thread.sleep(3000);
        alert.accept();
    }

    public static void alertWithOKAndCancel() throws InterruptedException{
        WebDriver driver = WebDriverManager.chromedriver().create();
        driver.manage().window().maximize();
        driver.get("https://demo.automationtesting.in/Alerts.html");
        driver.findElement(By.xpath("//a[normalize-space(text())='Alert with OK & Cancel']")).click();
        driver.findElement(By.cssSelector("[class='btn btn-primary']")).click();
        Thread.sleep(3000);
        Alert alertAccept = driver.switchTo().alert();
        System.out.println("Alert Text: " + alertAccept.getText());
        Thread.sleep(3000);
        alertAccept.accept();
        System.out.println(driver.findElement(By.id("demo")).getText());

        driver.findElement(By.cssSelector("[class='btn btn-primary']")).click();
        Thread.sleep(3000);
        Alert alertCancel = driver.switchTo().alert();
        System.out.println("Alert Text: " + alertCancel.getText());
        Thread.sleep(3000);
        alertCancel.dismiss();
        System.out.println(driver.findElement(By.id("demo")).getText());
    }

    public static void alertWithTextBox() throws InterruptedException{
        WebDriver driver = WebDriverManager.chromedriver().create();
        driver.manage().window().maximize();
        driver.get("https://demo.automationtesting.in/Alerts.html");
        driver.findElement(By.xpath("//a[normalize-space(text())='Alert with Textbox']")).click();
        driver.findElement(By.cssSelector("[class='btn btn-info']")).click();
        Thread.sleep(3000);
        Alert alert = driver.switchTo().alert();
        alert.sendKeys("DevStack QA");
        alert.accept();
        System.out.println(driver.findElement(By.id("demo1")).getText());
    }
}

