package com.demoqa.drivers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import static com.demoqa.utils.ConfigReader.getValue;

public class ChromeWebDriver {

    public static WebDriver loadChromeDriver() {
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-extensions");
        options.addArguments("--window-size-1920,1080");//даем расширение экрана
        options.addArguments("--no-sandbox");//чтобы наши тесты могли работать через определенные сервисы


//        ChromeOptions browserOptions = new ChromeOptions();
//        browserOptions.setPlatformName("Windows 11");
//        browserOptions.setBrowserVersion("latest");
//        Map<String, Object> sauceOptions = new HashMap<>();
//        sauceOptions.put("username", "oauth-nargizaknd210986-d20c4");
//        sauceOptions.put("accessKey", "5be50b96-b7e3-4bf8-9128-7d857ed809d8");
//        sauceOptions.put("build", "<your build id>");
//        sauceOptions.put("name", "<your test name>");
//        browserOptions.setCapability("sauce:options", sauceOptions);
//
//        URL url = null;
//        try {
//            url = new URL("https://ondemand.eu-central-1.saucelabs.com:443/wd/hub");
//        }catch (MalformedURLException e){
//         throw new RuntimeException(e);
//        }
//        RemoteWebDriver driver = new RemoteWebDriver(url, options);

        if (Boolean.parseBoolean(getValue("headless"))) {//если тру в app.properties то значение запарсь
            options.addArguments("--headless"); //мы говорим не открывай браузер при запуске
        }

        WebDriver driver = new ChromeDriver();

        //driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        return driver;
    }
}
