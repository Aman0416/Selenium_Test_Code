package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.Iterator;
import java.util.Set;

public class SomeInterviewQues {
    public static void main(String[] args) throws InterruptedException {
        //Ques 1 - Give me the count on Links on the Page
        WebDriver driver = new ChromeDriver();

        driver.get("http://qaclickacademy.com/practice.php");
        System.out.println(driver.findElements(By.tagName("a")).size());

        //Ques 2 - Give me the count on all Links but only in the Footer Section on Page
        //Limiting Scope
        WebElement footer = driver.findElement(By.id("gf-BIG"));

        System.out.println(footer.findElements(By.tagName("a")).size());

        //Ques 3 - Click on Each Links in a Coloumn and check that if Page is opening or not
        WebElement coloumn = footer.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
        System.out.println(coloumn.findElements(By.tagName("a")).size());

        Actions action = new Actions(driver);
        for(int i=1;/*skipping 1st one as its a waste*/ i<coloumn.findElements(By.tagName("a")).size(); i++){
            action.moveToElement(coloumn.findElements(By.tagName("a")).get(i)).keyDown(Keys.CONTROL).click().build().perform();
            //Another way
            //coloumn.findElements(By.tagName("a")).get(i).sendKeys(Keys.chord(Keys.CONTROL, Keys.ENTER));
        }

        //Ques 3.1 - Print all Window Handles in SOUT
        Set<String> windows = driver.getWindowHandles();
        Iterator<String> it = windows.iterator();

        it.next();
        while(it.hasNext()){
            Thread.sleep(2000);
            driver.switchTo().window(it.next());
            System.out.println(driver.getTitle());
        }
    }
}
