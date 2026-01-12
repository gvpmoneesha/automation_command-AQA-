package com.devstack.selenium.BrowserInformation.Command;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.sql.Driver;
import java.util.List;

public class BrowserInformationCommandTest {
    public static void  main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverManager.chromedriver().create();
        driver.navigate().to("https://www.ebay.com");
        Thread.sleep(3000);

        List<WebElement> elements = driver.findElements(By.cssSelector("[class=\"gh-identity-signed-out-unrecognized\"] a"));

        for (WebElement element : elements) {
            System.out.println("Link Text: " + element.getText());
        }

//        String value = driver.findElement(By.id("gh-search-btn")).getAttribute("value");
//        System.out.println("Attribute value: " + value);

        String value = driver.findElement(By.id("gh-search-btn")).getDomAttribute("value");
        System.out.println("Attribute value: " + value);

        driver.findElement(By.id("gh-ac")).click();
        driver.findElement(By.id("gh-ac")).clear();
        driver.findElement(By.id("gh-ac")).sendKeys("iphone");

        Select selectDropDown = new Select(driver.findElement(By.id("gh-cat")));
        selectDropDown.selectByVisibleText("Cell Phones & Accessories");
        Thread.sleep(3000);

        driver.findElement(By.id("gh-search-btn")).click();
        Thread.sleep(3000);

        List<WebElement> options = driver.findElements(By.xpath("//li[@class='x-refine__main__list--value']/div"));
        for (WebElement option : options) {
            if (option.getDomAttribute("class").contains("disabled")) {
                System.out.println("Disabled Option Text: " + option.getText());
            }
        }
    }
}
