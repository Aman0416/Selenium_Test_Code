package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Locators1 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://rahulshettyacademy.com/locatorspractice/");

        driver.findElement(By.id("inputUsername")).sendKeys("Aman");
        driver.findElement(By.name("inputPassword")).sendKeys("Test111");
        driver.findElement(By.className("signInBtn")).click();

        Thread.sleep(3000);
        String Data = driver.findElement(By.cssSelector("p.error")).getText();
        System.out.println(Data);

        driver.findElement(By.linkText("Forgot your password?")).click();
        driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("Aman");
        driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("abc@gmail.com");
        driver.findElement(By.cssSelector("input[type='text']:nth-child(3)")).clear();
        driver.findElement(By.xpath("//input[@type='text'][2]")).sendKeys("aman@test.com");
        driver.findElement(By.xpath("//form/input[3]")).sendKeys("987654321");
        driver.findElement(By.className("reset-pwd-btn")).click();

        System.out.println(driver.findElement(By.cssSelector("form p")).getText());

        driver.findElement(By.xpath("//div[@class='forgot-pwd-btn-conainer']/button[1]")).click();

        //Now, Logging in to the website
        driver.findElement(By.cssSelector("#inputUsername")).sendKeys("Aman");
        driver.findElement(By.cssSelector("input[type*='pass']")).sendKeys("rahulshettyacademy");

        //Waiting for page to load
        Thread.sleep(1000);
        driver.findElement(By.id("chkboxOne")).click();

        driver.findElement(By.xpath("//button[contains(@class,'submit')]")).click();

        Thread.sleep(1000);
        System.out.println(driver.findElement(By.tagName("p")).getText());
        driver.findElement(By.xpath("//button[text()='Log Out']")).click();

        driver.manage().window().fullscreen();
        driver.close();
    }
}
