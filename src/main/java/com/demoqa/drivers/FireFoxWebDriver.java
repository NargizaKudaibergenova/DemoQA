package com.demoqa.drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class FireFoxWebDriver {

    public static WebDriver loadFireFoxDriver(){
     //   System.setProperty("webdriver.firefox.driver", "src/main/resources/drivers/chromedriver.exe");

        WebDriver driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        return driver;

    }
}
