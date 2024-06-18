package com.demoqa.helper;

import com.demoqa.drivers.DriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class WebElementActions { //внутри этого класса храним все WebElement

    //работа с мышкой
    Actions actions = new Actions(DriverManager.getDriver());

//    @BeforeClass(alwaysRun = true)
//    public void init(){
//        actions = new Actions(DriverManager.getDriver());
//
//    }

    //метод клик
    public WebElementActions click(WebElement element) {
        waitElementToBeClickAble(element);
        scrollToElement(element);
        highlightElement(element);
        element.click();
        return this;
    }

    public WebElementActions sendKeys(WebElement element, String txt) {
        waitElementToBeVisible(element);
        scrollToElement(element);
        highlightElement(element);
        element.sendKeys(txt); //с element передаем в txt
        return this;
    }

    public WebElementActions sendKeysWithEnter(WebElement element, String txt) {
        waitElementToBeVisible(element);
        scrollToElement(element);
        element.sendKeys(txt); //с element передаем в txt
        element.sendKeys(Keys.ENTER);//в sendKeys передаем клавиатуру и дальше выбираем какую кнопку хотим нажать
        return this;
    }

    //виды ожидания
    public WebElementActions waitElementToBeClickAble(WebElement element) {
        new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(20))
                .until(ExpectedConditions.elementToBeClickable(element));//жди до тех пор, пока элемент не кликнет
        return this;
    }

    public WebElementActions waitElementToBeVisible(WebElement element) {
        new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(20))
                .until(ExpectedConditions.visibilityOf((element))); //жди до тех пор, пока не появиться текст
        return this;
    }

    public WebElementActions scrollToElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
        js.executeScript("arguments[0].scrollIntoView(true);", element);
        return this;
    }

//кликать при помощи JavascriptExecutor
    public WebElementActions jsClick(WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
        js.executeScript("argument[0].click();", element);
        return this;
    }

    //подсвечивать элементы
    public WebElementActions highlightElement(WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
        js.executeScript("arguments[0].setAttribute('style', 'border: 2px solid red;');", element);
        return this;
}

//
    public WebElementActions jsSendKeys(WebElement element, String  txt){
        JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
        js.executeScript("arguments[0].value = arguments[1];");
                return this;
    }

    //двойной клик мышкой
    public WebElementActions doubleClick(WebElement element){
        waitElementToBeVisible(element);
        waitElementToBeClickAble(element);
        actions.doubleClick(element).perform(); //метод perform() говорит выполни действие которое до него прописаны
        return this;

    }

    //щелкнуть правой мышкой
    public WebElementActions rightClick(WebElement element){
        waitElementToBeVisible(element);
        waitElementToBeClickAble(element);
        actions.contextClick(element).perform();
        return this;
    }

    //обычный метод клик один раз
    public void clickMe(WebElement element){
        waitElementToBeVisible(element);
        waitElementToBeClickAble(element);
        actions.click(element).perform();
    }

    //наводить на элемент мышкой (класса Actions)
    public WebElementActions moveToElement(WebElement element){
        waitElementToBeClickAble(element);
        actions.moveToElement(element).perform();
        return this; //Дает возможность чейнить т.е. цепочку методов делать
    }

    public WebElementActions clearAndSendKeys(WebElement element, String value){
        element.clear();
        element.sendKeys();
        return this;
    }

    //метод пауза
    public void pause(Integer seconds){
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}