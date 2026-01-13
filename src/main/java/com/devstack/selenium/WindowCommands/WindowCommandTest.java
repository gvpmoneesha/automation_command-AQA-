package com.devstack.selenium.WindowCommands;

import java.util.Set;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowCommandTest {
    public static void main(String[] args) throws InterruptedException {
        // openNewTabbedWindow();
        openNewSeparateWindow();
    }

    public static void openNewTabbedWindow() throws InterruptedException{
        WebDriver driver = WebDriverManager.chromedriver().create();
        driver.manage().window().maximize();
        driver.get("https://demo.automationtesting.in/Windows.html");
        Thread.sleep(2000);

        driver.findElement(By.xpath("//a[normalize-space(text())='Open New Tabbed Windows']")).click();
        Thread.sleep(2000);

        String parentWindow = driver.getWindowHandle(); //save the parent window
        Thread.sleep(2000);

        driver.findElement(By.cssSelector("[class='btn btn-info']:nth-child(1)")).click();
        Thread.sleep(2000);

        Set<String> getAllWindows = driver.getWindowHandles(); //get all the windows
        for (String window : getAllWindows) {
            if(!window.equals(parentWindow)){
                driver.switchTo().window(window);
                Thread.sleep(2000);
                @Nullable
                String title = driver.getTitle();
                System.out.println("Child window title: " + title);
                Thread.sleep(2000);
                break;
            }
        }
        driver.switchTo().window(parentWindow);
        Thread.sleep(2000);

        @Nullable
        String parentTitle = driver.getTitle();
        System.out.println("Parent window title: " + parentTitle);
        Thread.sleep(2000);
        Thread.sleep(2000);
    }

    public static void openNewSeparateWindow() throws InterruptedException{
        WebDriver driver = WebDriverManager.chromedriver().create();
        driver.manage().window().maximize();
        driver.get("https://demo.automationtesting.in/Windows.html");
        Thread.sleep(2000);

        driver.findElement(By.xpath("//a[text()='Open New Seperate Windows']")).click();
        Thread.sleep(2000);

        String parentWindow = driver.getWindowHandle();
        Thread.sleep(2000);

        driver.findElement(By.cssSelector("[class='btn btn-primary']")).click();
        Thread.sleep(2000);

        Set<String> getAllWindows = driver.getWindowHandles();
        for (String window : getAllWindows) {
            if(!window.equals(parentWindow)){
                driver.switchTo().window(window);
                Thread.sleep(2000);
                @Nullable
                String title = driver.getTitle();
                System.out.println("Child window title: " + title);
                Thread.sleep(2000);
                driver.close();
                break;
            }
        }
        driver.switchTo().window(parentWindow);
        Thread.sleep(2000);

        @Nullable
        String parentTitle = driver.getTitle();
        System.out.println("Parent window title: " + parentTitle);
        Thread.sleep(2000);
        Thread.sleep(2000);
    }
}
