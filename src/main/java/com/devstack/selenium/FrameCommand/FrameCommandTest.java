package com.devstack.selenium.FrameCommand;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebElement;

public class FrameCommandTest {
    static void main(String[] args) throws InterruptedException {
        singleFrame();
    }

    public static void  singleFrame() throws InterruptedException {
        WebDriver driver = WebDriverManager.chromedriver().create();
        driver.manage().window().maximize();
        driver.get("https://demo.automationtesting.in/Frames.html");
        Thread.sleep(2000);

        driver.switchTo().frame("singleframe");
        Thread.sleep(2000);

        driver.findElement(By.cssSelector("input")).sendKeys("Devstack automation");
        Thread.sleep(2000);

        driver.switchTo().defaultContent();
        Thread.sleep(2000);

        driver.findElement(By.xpath("//a[text()='Home']")).click();
        Thread.sleep(2000);

        System.out.println("Test completed successfully");
    }
}
