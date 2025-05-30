package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class CartItems {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        String[] names = {"Cucumber", "Brinjal", "Beetroot"};

        //Implicit Wait of 2 Sec
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        //Constructing Explicit Wait
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        //This is a Utility to add Items to the Cart
        addItems(driver, names);

        driver.findElement(By.xpath("//img[@alt='Cart']")).click();
        driver.findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']")).click();
        driver.findElement(By.cssSelector("input.promoCode")).sendKeys("rahulshettyacademy");
        driver.findElement(By.cssSelector("button.promoBtn")).click();

        //Applying Explicit Wait Defined Above
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.promoInfo")));
        System.out.println(driver.findElement(By.cssSelector("span.promoInfo")).getText());
    }

    public static void addItems(WebDriver driver, String[] names){
        //Converting array to Array List
        List list = Arrays.asList(names);
        int counter = 0;

        driver.get("https://rahulshettyacademy.com/seleniumPractise/");
        driver.manage().window().maximize();

        List<WebElement> elements = driver.findElements(By.cssSelector("h4.product-name"));

        for(int i = 0; i<elements.size(); i++){
            String[] name = elements.get(i).getText().split("-");
            String correctedData = name[0].trim();

            if(list.contains(correctedData)){
                counter++;
                driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
            }

            if(counter== names.length)
                break;
        }
    }
}
