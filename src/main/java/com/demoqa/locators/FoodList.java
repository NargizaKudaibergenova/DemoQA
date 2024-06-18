package com.demoqa.locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class FoodList {

    @Test
    void findFoodList (){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Home\\DemoQAWinter24\\src\\main\\resources\\drivers\\chromedriver.exe");

        WebDriver driver = new ChromeDriver(); // Создаем экземпляр браузера Chrome

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://nambafood.kg/kukhnya-na-rayone?language=en");

        List<WebElement> foodList = driver.findElements(By.xpath("//div[@class='card--item-info']/div[2]"));
        for (WebElement food : foodList){
            System.out.println(food.getText());
        }
    }

}
