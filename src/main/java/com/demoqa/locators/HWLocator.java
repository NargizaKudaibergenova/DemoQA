package com.demoqa.locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class HWLocator {

    WebDriver driver;

    @BeforeClass
    void openBrowsers() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Home\\DemoQAWinter24\\src\\main\\resources\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        Thread.sleep(5000);
        driver.get("https://dostavka312.kg/");
    }

    @AfterSuite
    void СloseTab() throws InterruptedException {
        Thread.sleep(7000);
        driver.close();
        driver.quit();
    }

    @Test
    public void openLinks() throws InterruptedException {

        WebElement allEstablishments = driver.findElement(By.xpath("//*[@id=\"tab-01\"]/div/p/a/img"));
        allEstablishments.click();

        WebElement kfcRestaurant = driver.findElement(By.xpath("//a[@href='https://dostavka312.kg/garnirygpt/kfc-moskovskaja']"));
        kfcRestaurant.click();

        WebElement orderKombo = driver.findElement(By.xpath("//a[@href='https://dostavka312.kg/garnirygpt/kfc-moskovskaja#menu_0']"));
        orderKombo.click();

        WebElement basket = driver.findElement(By.xpath("//p[normalize-space(text())='Баскет L Комбо']/following-sibling::form/button"));
        basket.click();

        WebElement openBasket = driver.findElement(By.xpath("//div[@class = 'icon_pulse']"));
        openBasket.click();

        WebElement order = driver.findElement(By.xpath("//a[@href='https://dostavka312.kg/cart']"));
        order.click();

        WebElement name = driver.findElement(By.xpath("//input[@name='name']"));
        name.sendKeys("Masha");

        WebElement address = driver.findElement(By.xpath("//input[@name='address']"));
        address.sendKeys("3 Chui str");

        WebElement phone = driver.findElement(By.xpath("//input[@placeholder='Ваш телефон']"));
        phone.sendKeys("559874589");

        WebElement change = driver.findElement(By.xpath("//input[@placeholder='Сдача с']"));
        change.sendKeys("422");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        Thread.sleep(6000);

       // WebElement checkout = driver.findElement(By.xpath("//button[@class='btn btn-yellow btn-lg btn-savecart']"));
        //checkout.click();


    }
}

