package com.devstack.selenium.ActionCommands;

//import org.jspecify.annotations.Nullable;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class MouseActionCommandTest {
    public static void main(String[] args) throws InterruptedException {
        // contextClickExample();
        // doubleClickExample();
        // sliderActionExample();
           mouseHoverExample();
    }

    public static void contextClickExample() throws InterruptedException {
        WebDriver driver = WebDriverManager.chromedriver().create();
        driver.manage().window().maximize();
        driver.get("https://www.testmu.ai/selenium-playground/context-menu/");
        WebElement contextClickBox = driver.findElement(By.id("hot-spot"));
        Actions action = new Actions(driver);
        action.contextClick(contextClickBox).perform();
        Thread.sleep(3000);
        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        System.out.println("Alert text: " + alertText);
        alert.accept();
    }

    public static void doubleClickExample() throws InterruptedException {
        WebDriver driver = WebDriverManager.chromedriver().create();
        driver.manage().window().maximize();
        driver.get("https://unixpapa.com/js/testmouse.html");
        WebElement clickableTestLink = driver.findElement(By.linkText("click here to test"));
        Actions action = new Actions(driver);
        action.doubleClick(clickableTestLink).perform();
        Thread.sleep(3000);
        //@Nullable
        String domTextValue = driver.findElement(By.cssSelector("textarea")).getAttribute("value");
        System.out.println("DOM Text Area Value: " + domTextValue);
    }

    public static void sliderActionExample() throws InterruptedException {
        WebDriver driver = WebDriverManager.chromedriver().create();
        driver.manage().window().maximize();
        driver.get("https://www.testmu.ai/selenium-playground/drag-drop-range-sliders-demo/");
        Thread.sleep(2000);
        WebElement sliderInput = driver.findElement(By.cssSelector("#slider1 input"));
        WebElement sliderValue = driver.findElement(By.id("range"));
        System.out.println("Initial Slider Value: " + sliderValue.getText());
        Thread.sleep(2000);

        Point sliderLocation = sliderInput.getLocation();
        int xcord = sliderLocation.getX();
        int ycord = sliderLocation.getY();
        System.out.println("Slider Location - X: " + xcord + " Y: " + ycord);

        Actions action = new Actions(driver);
        action.clickAndHold(sliderInput).moveByOffset(10, 0).release().perform();
        Thread.sleep(2000);
        System.out.println("Updated Slider Value: " + sliderValue.getText());
    }

    public static void mouseHoverExample() throws InterruptedException {
        WebDriver driver = WebDriverManager.chromedriver().create();
        driver.manage().window().maximize();
        driver.get("https://ecommerce-playground.lambdatest.io/");
        WebElement element = driver.findElement(By.xpath("(//span[normalize-space(text())='My account'])[2]"));
        Thread.sleep(2000);
        Actions action = new Actions(driver);
        action.moveToElement(element).build().perform();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//span[normalize-space(text())='Login']")).click();
        System.out.println("Clicked on Login successfully");
    }
}
