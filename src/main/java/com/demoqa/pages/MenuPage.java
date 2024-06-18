package com.demoqa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MenuPage extends BasePage{

    @FindBy(xpath = "//a[text()='Main Item 2']")
    public WebElement mainItem2;

    @FindBy(xpath = "//*[@id=\"nav\"]/li[2]/ul")
    public WebElement subItem;

    @FindBy(xpath = "//*[@id=\"nav\"]/li[2]/ul/li[1]/a")
    public WebElement subItem2;


}
