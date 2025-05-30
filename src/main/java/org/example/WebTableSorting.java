package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

public class WebTableSorting {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
 
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offersx");

        //Click to sort the Data
        driver.findElement(By.xpath("//tr/th[1]")).click();

        //Capture all data into one list
        List<WebElement> elements = driver.findElements(By.xpath("//tr/td[1]"));

        //Capture text of all WebElements into a Stream
        List<String> orginalList = elements.stream().map(s -> s.getText()).collect(Collectors.toList());

        //Sort the Original List into Sorted List
        List<String> sortedList = orginalList.stream().sorted().collect(Collectors.toList());

        Assert.assertEquals(sortedList, orginalList);

        //Ques 2 - Scan the name coloumn with gettext -> When Rice Found -> Print the price of Rice
        List<String> price = elements.stream().filter(s -> s.getText().contains("Rice"))
                .map(s -> getPriceVeggie(s)).collect(Collectors.toList());
    }

    private static String getPriceVeggie(WebElement s){
        return null;
    }
}

