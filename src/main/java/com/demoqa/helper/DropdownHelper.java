package com.demoqa.helper;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DropdownHelper {

    public WebDriver driver;

    public DropdownHelper(WebDriver driver) {
        this.driver = driver;
    }

    //календарь
    public DropdownHelper selectByVisibleText(WebElement element, String value) {
        Select select = new Select(element);
        select.selectByVisibleText(value);
        return this;
    }
    //так же есть несколько методов выбрать нужный нам элемент

    //ищем по атрибуту value
    public DropdownHelper selectByValueText(WebElement element, String value) {
        Select select = new Select(element);
        select.selectByValue(value);
        return this;
    }

    //ищем по индексу
    public DropdownHelper selectByIndex(WebElement element, int index) {
        Select select = new Select(element);
        select.selectByIndex(index);
        return this;
    }
}
