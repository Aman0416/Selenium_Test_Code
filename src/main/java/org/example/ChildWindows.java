package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;

public class ChildWindows {
    public static void main(String[] args) {
        WebDriver driver= new ChromeDriver();

        driver.get("https://rahulshettyacademy.com/loginpagePractise/#");
        driver.findElement(By.cssSelector(".blinkingText")).click();

        //Going to Child Window
        Set<String> windows = driver.getWindowHandles();
        Iterator<String> it = windows.iterator();

        String parentId = it.next();
        String childId = it.next();

        driver.switchTo().window(childId);

        String userName = driver.findElement(By.cssSelector("p.im-para.red strong a")).getText();

        //Switching Back
        driver.switchTo().window(parentId);

        driver.findElement(By.id("username")).sendKeys(userName);
        driver.findElement(By.id("password")).sendKeys("learning");
    }
}
