package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;

public class BrokenLinks {
    public static void main(String[] args) throws IOException {
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        //To Capture the count of all broken links in a Section
        //Step 1 - Is to get all the URLs tied up to the links using Selenium
        //Java Methods will call URLs and get you Status Codes
        //If Status Code > 400 then that URL is not working -> link which tied to URL is broken

        driver.get("http://rahulshettyacademy.com/AutomationPractice/");
        SoftAssert soft = new SoftAssert();

        List<WebElement> links = driver.findElements(By.cssSelector("li[class = 'gf-li'] a"));

        for(WebElement link : links){
            String url = link.getAttribute("href");

            assert url != null;
            HttpURLConnection conn = (HttpURLConnection)new URL(url).openConnection();
            conn.setRequestMethod("HEAD");
            conn.connect();

            int respCode = conn.getResponseCode();
            System.out.println(respCode);

            soft.assertTrue(respCode<400, "The link with text " + link.getText() + " is broken with code " + respCode);

//            if(respCode > 400){
//                System.out.println("The link with text " + link.getText() + " is broken with code " + respCode);
//                Assert.fail();
//            }
        }
        soft.assertAll();
    }
}
