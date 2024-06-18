package com.demoqa.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ButtonsPage extends BasePage {

    @FindBy(id = "doubleClickBtn")
    public WebElement doubleClickBtn;

    @FindBy(id = "doubleClickMessage")
    public WebElement doubleClickMessage;

    @FindBy(id = "rightClickBtn")
    public WebElement rightClickBtn;

    @FindBy(id = "rightClickMessage")
    public WebElement rightClickMessage;

   // @FindBy(xpath = "//div[@class='col-12 mt-4 col-md-6']/div[2]/div[3]")
    @FindBy(id = "Q3cxz")
    public WebElement clickMeBtn;

    @FindBy(id = "dynamicClickMessage")
    public WebElement dynamicClickMessage;


}
