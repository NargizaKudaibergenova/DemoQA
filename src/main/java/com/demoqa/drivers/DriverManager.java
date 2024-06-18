package com.demoqa.drivers;

import com.demoqa.utils.ConfigReader;
import org.openqa.selenium.WebDriver;

public class DriverManager {

    private static WebDriver driver;

    public static WebDriver getDriver() {

        if (driver == null) {
            switch (ConfigReader.getValue("browser").toLowerCase()) {
                case "chrome":
                    driver = ChromeWebDriver.loadChromeDriver();
                    break;
                case "edge":
                    driver = EdgeWebDriver.loadEdgeDriver();
                    break;
                case "firefox":
                    driver = FireFoxWebDriver.loadFireFoxDriver();
                    break;
//                case "Safari":
//                    driver=SafariWebDriver.loadSafariDriver();
//                case "opera":
//                    driver = OperaWebDrive.loadOperaDriver();
//                    break;
                default:
                    throw new IllegalArgumentException("Неправильное название драйвера");
            }
        }
        return driver;
    }

    public static void closeDriver() {
        try {
            if (driver != null) {
                driver.close();
                driver.quit();
                driver = null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
