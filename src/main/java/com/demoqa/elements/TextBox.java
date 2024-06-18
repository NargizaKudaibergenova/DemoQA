package com.demoqa.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class TextBox {

    @Test
    void textBoxTest() throws InterruptedException {
        //// Указываем путь к драйверу Chrome
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Home\\DemoQAWinter24\\src\\main\\resources\\drivers\\chromedriver.exe");

        WebDriver driver = new ChromeDriver(); // Создаем экземпляр браузера Chrome

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //driver.manage().window().maximize(); //увеличит экран страницы
        driver.get("https://demoqa.com/text-box"); //// Открываем сайт
        //Thread.sleep(5000);

        WebElement fullName = driver.findElement(By.id("userName"));

        fullName.sendKeys("Nargiza");

        // Закрываем браузер
        //driver.close();
        //driver.quit();
    }
}
