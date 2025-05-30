package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class HandlingTables {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        int total = 0;

        driver.get("https://rahulshettyacademy.com/AutomationPractice");

        //Using Scroll to go to Table
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)");
        Thread.sleep(2000);
        js.executeScript("document.querySelector('.tableFixHead').scrollTop = 5000");

        List<WebElement> elements = driver.findElements(By.xpath("//div[@class = 'tableFixHead'] //td[4]"));

        for(WebElement ele : elements){
            total += Integer.parseInt(ele.getText());
        }

        System.out.println(total);

        //Now, comparing our data
        int total2 = Integer.parseInt(driver.findElement(By.className("totalAmount")).getText().split(":")[1].trim());

        Assert.assertEquals(total, total2);
        driver.quit();
    }
}
