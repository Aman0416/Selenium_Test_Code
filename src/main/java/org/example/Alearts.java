package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Alearts {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        //Sending Data to Alert
        driver.findElement(By.id("name")).sendKeys("Aman Deep");
        driver.findElement(By.id("alertbtn")).click();

        //To get Text from Alert
        System.out.println(driver.switchTo().alert().getText());
        //To accept the Alert
        driver.switchTo().alert().accept();

        driver.findElement(By.id("confirmbtn")).click();

        //To reject the Alert
        driver.switchTo().alert().dismiss();
    }
}
