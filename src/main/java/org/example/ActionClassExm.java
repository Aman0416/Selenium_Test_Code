package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class ActionClassExm {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(1));
        driver.get("https://www.amazon.in/");

        //Using Actions Class
        Actions action = new Actions(driver);

        //Hover Effect Check
        action.moveToElement(driver.findElement(By.id("nav-link-accountList"))).contextClick().build().perform();
        Thread.sleep(1000);

        //Keyboard Actions Example
        action.moveToElement(driver.findElement(By.id("twotabsearchtextbox"))).click().keyDown(Keys.SHIFT)
                .sendKeys("hello").doubleClick().build().perform();
    }
}
