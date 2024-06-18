package com.demoqa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SelectMenuPage extends BasePage {

    @FindBy(id = "withOptGroup")
    public WebElement selectValue;

    @FindBy(className = "css-26l3qy-menu")
    public WebElement classMenu;

    @FindBy(xpath = "(//div[@class =  ' css-yk16xz-control'])[2]")
    public WebElement selectOne;

    @FindBy(id = "oldSelectMenu")
    public WebElement oldStyleSelectMenu;

    @FindBy(xpath = "//div[text()='Select...']")
    public WebElement multiselectDropDown;

    @FindBy(id = "cars")
    public WebElement standardMultiSelect;

}