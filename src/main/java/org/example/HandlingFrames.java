package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class HandlingFrames {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("http://jqueryui.com/droppable/");

        //Handling Frames
        driver.switchTo().frame(driver.findElement(By.cssSelector("iframe.demo-frame")));
        //Another Way to Switch Items
        //driver.switchTo().frame(0);

        Actions action = new Actions(driver);
        WebElement source = driver.findElement(By.id("draggable"));
        WebElement target = driver.findElement(By.id("droppable"));

        action.dragAndDrop(source, target).build().perform();

        //Back to Main Page
        driver.switchTo().defaultContent();
    }
}
