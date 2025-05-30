package org.example;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;

public class ScreenShits {
    private static final Logger log = LoggerFactory.getLogger(ScreenShits.class);

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.google.com/");

        File ss = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        try{
            FileUtils.copyFile(ss, new File("C:\\Users\\aman0\\OneDrive\\Pictures\\Screenshots\\test.png"));
        }catch (IOException io){
            log.error("e: ", io);
        };
    }
}
