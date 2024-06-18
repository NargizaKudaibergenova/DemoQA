package com.demoqa.drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;

public class EdgeWebDriver {

    public static WebDriver loadEdgeDriver(){
    //    System.setProperty("webdriver.edge.driver", "src/main/resources/drivers/chromedriver.exe");

        WebDriver driver = new EdgeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        return driver;

    }
}
