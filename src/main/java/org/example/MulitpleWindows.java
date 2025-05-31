package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;

public class MulitpleWindows {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/angularpractice/");

        driver.switchTo().newWindow(WindowType.TAB);

        Set<String> handles = driver.getWindowHandles();
        Iterator<String> it = handles.iterator();

        String mainWindow = it.next();
        String newWindow = it.next();

        driver.switchTo().window(newWindow);

        driver.get("https://rahulshettyacademy.com/learning-path");

        String courseName = driver.findElements(By.xpath("//h4/a[@onclick='showLearningPath(this)']")).get(1).getText();

        driver.switchTo().window(mainWindow);
        driver.findElement(By.cssSelector("[name = 'name']")).sendKeys(courseName);

        Thread.sleep(1000);

        driver.quit();
    }
}
