package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;

public class DropDowns {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();

        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

        driver.manage().window().maximize();

        //Handling Dropdowns with Select Tag
        Select dropdown = new Select(driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency")));
        dropdown.selectByIndex(3);
        System.out.println(dropdown.getFirstSelectedOption().getText());
        dropdown.selectByVisibleText("AED");
        System.out.println(dropdown.getFirstSelectedOption().getText());

        //Handling Looping UI Dropdowns now
        driver.findElement(By.id("divpaxinfo")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("hrefIncAdt")).click();
        driver.findElement(By.id("btnclosepaxoption")).click();
        //for Multiple Clicks on Buttons
        driver.findElement(By.id("divpaxinfo")).click();
        Thread.sleep(1000);
        int i=0;
        while(i<4){
            driver.findElement(By.id("hrefIncAdt")).click();
            i++;
        }
        driver.findElement(By.id("btnclosepaxoption")).click();
        System.out.println(driver.findElement(By.id("divpaxinfo")).getText());

        //Handling Dynamic Dropdowns
        driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
        driver.findElement(By.cssSelector("a[value='GOI']")).click();
        Thread.sleep(2000);//Waiting for other window to open
//        driver.findElement(By.id("ctl00_mainContent_ddl_destinationStation1_CTXT")).sendKeys("DEL");
        driver.findElement(By.xpath("//div[@id='ctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='DEL']")).click();

        //Handling Calender UI
        driver.findElement(By.cssSelector(".ui-state-default.ui-state-active")).click();

        //Handling AutoSuggestive Dropdowns
        driver.findElement(By.id("autosuggest")).sendKeys("IND");
        Thread.sleep(1000);
        List<WebElement> options = driver.findElements(By.cssSelector(".ui-menu-item a"));

        for(WebElement element : options){
            System.out.println(element.getText());
            if(element.getText().equalsIgnoreCase("India")){
                element.click();
                break;
            }
        }

        //Handling CheckBox and using Assert
        Assert.assertFalse(driver.findElement(By.cssSelector("input[id*='friendsandfamily']")).isSelected());
        driver.findElement(By.cssSelector("input[id*='friendsandfamily']")).click();
        Assert.assertTrue(driver.findElement(By.cssSelector("input[id*='friendsandfamily']")).isSelected());
        //Calculating No. of all checkboxes on the Page
        Assert.assertEquals(driver.findElements(By.cssSelector("input[type='checkbox']")).size(), 6);

        //Validating if Return Date Calander is enabled when One Way is selected or not
        //As we are not able to find correct answer from default selenium functions(Explained in Notes)
        System.out.println(driver.findElement(By.id("Div1")).getAttribute("style"));
//        driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
        System.out.println(driver.findElement(By.id("Div1")).getAttribute("style"));
        if(driver.findElement(By.id("Div1")).getAttribute("style").contains("0.5")){
            System.out.println("It is Enabled");
            Assert.assertTrue(true);
        }else Assert.assertTrue(false);
    }
}
