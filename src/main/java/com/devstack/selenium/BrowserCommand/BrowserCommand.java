package com.devstack.selenium.BrowserCommand;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class BrowserCommand {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverManager.chromedriver().create();
        //driver.get(URL);
        driver.get("https://ebay.com");
        Thread.sleep(3000);

        //driver.getCurrentUrl();
        String currentURL = driver.getCurrentUrl();
        System.out.println(currentURL);

        //driver.getTitle();
        String title = driver.getTitle();
        System.out.println(title);

        //driver.close();
        //driver.quit();
    }
}
