package com.demoqa.locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class BasicLocators {

@Test(description = "Find by ID")
    void findByIDTest(){
    System.setProperty("webdriver.chrome.driver", "C:\\Users\\Home\\DemoQAWinter24\\src\\main\\resources\\drivers\\chromedriver.exe");

    WebDriver driver = new ChromeDriver(); // Создаем экземпляр браузера Chrome

    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    //driver.manage().window().maximize(); //увеличит экран страницы
    driver.get("https://demoqa.com/text-box"); //// Открываем сайт
    //Thread.sleep(5000);

//    WebElement fullNameInput = driver.findElement(By.id("userName"));
//    fullNameInput.sendKeys("Nargiza");

    //                                найди элемент,при помощи className
//    WebElement fullNameInput = driver.findElement(By.className("mr-sm-2"));
//    fullNameInput.sendKeys("Nargiza");

//    WebElement fullNameInput = driver.findElement(By.tagName("input"));
//    fullNameInput.sendKeys("Nargiza");

//    String textBoxText = driver.findElement(By.tagName("h1")).getText();
//    System.out.println(textBoxText);

   // driver.get("https://demoqa.com/links");
    //Home

//    WebElement homeLink = driver.findElement(By.linkText("Home"));//откроет указанную вкладку
//    homeLink.click();

//    WebElement homeLink = driver.findElement(By.partialLinkText("Bad")); //найдет по указанному слову

    WebElement homeLink = driver.findElement(By.xpath("(//textarea[@class='form-control'])[1]"));
    homeLink.sendKeys("Wall Street 123");

    String permanentAddressTxt = driver.findElement(By.xpath("//label[text()='Permanent Address']")).getText();
    System.out.println(permanentAddressTxt);

}
}
