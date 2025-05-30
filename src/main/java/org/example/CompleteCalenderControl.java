package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.List;

public class CompleteCalenderControl {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        String date = "15";
        String month = "July";
        String year = "2028";
        String[] expectedResult = {"7", date, year};
        int i = 0;

        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");

        driver.findElement(By.cssSelector(".react-date-picker__calendar-button.react-date-picker__button")).click();
        driver.findElement(By.className("react-calendar__navigation__label")).click();
        driver.findElement(By.className("react-calendar__navigation__label")).click();

        driver.findElement(By.xpath("//button[text()='"+ year +"']")).click();
        driver.findElement(By.xpath("//abbr[text()='"+ month +"']")).click();
        driver.findElement(By.xpath("//abbr[text()='"+ date +"']")).click();

        //Fetching Data from Textbox
        List<WebElement> dataList = driver.findElements(By.cssSelector(".react-date-picker__inputGroup__input"));

        for(WebElement ele : dataList){
            System.out.println(ele.getAttribute("value"));
            Assert.assertEquals(ele.getAttribute("value"), expectedResult[i]);
            i++;
        }
    }
}
