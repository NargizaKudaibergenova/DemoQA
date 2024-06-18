package com.demoqa.helper;

import org.openqa.selenium.WebDriver;

import java.util.LinkedList;
import java.util.Set;

public class BrowserHelper {

    private WebDriver driver;

    public BrowserHelper(WebDriver driver) {
        this.driver = driver;
    }


    public void open(String url) {
        driver.navigate().to(url);// т.е.driver зайди на url(ссылка)
    }

    //кнопка назад в самом браузере например Chrome
    public void goBack() {
        driver.navigate().back();
    }

    //кнопка вперед в самом браузере например Chrome
    public void goForward() {
        driver.navigate().forward();
    }

    //кнопка обновить страницу в самом браузере например Chrome
    public void refreshThePage() {
        driver.navigate().refresh();
    }

    //метод которые управляет вкладками браузера
    public Set<String> getWindowHandles() {
        return driver.getWindowHandles();//вытаскивает вкладку открытую и ложит в Set<String>
    }

    //метод который мы будет выбирать вкладку по индексу
    public void switchToWindow(int index) {//переключиться по индексу
        LinkedList<String> windowsId = new LinkedList<>(getWindowHandles());//вызываем метод getWindowHandles и ложим их в LinkedList

        for (String window : windowsId) {
            System.out.println(window);
        }

        //если открытых 3 вкладки а мы запросили index 5вкладом то этот if для него:
        if (index < 0 || index > windowsId.size()) throw new IllegalArgumentException("Недопустимый индекс: " + index);

        driver.switchTo().window(windowsId.get(index));//если все правильно то найди вкладку и указываем index
    }

    //метод который возвращается в родительскую вкладку
    public void switchToParentWindow() {
        LinkedList<String> windowsId = new LinkedList<>(getWindowHandles());//вызываем метод getWindowHandles и ложим их в LinkedList

        driver.switchTo().window(windowsId.get(0));//0 -это и есть родительская вкладка под 0 индексом
    }

    //метод который переключится к родителю и паралельно закроет все оставшие вкладки
    public void switchToParentWithChildClose() {
        switchToParentWindow();

        LinkedList<String> windowsId = new LinkedList<>(getWindowHandles());//вызываем метод getWindowHandles и ложим их в LinkedList

        for (int i = 1; i < windowsId.size(); i++) {//начинает перебирать с 1индекса потому что 0 это родитюмы его не трогаем
            driver.switchTo().window(windowsId.get(i));
            driver.close();
        }
        switchToParentWindow();
    }
}
