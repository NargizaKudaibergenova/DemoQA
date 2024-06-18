package com.demoqa.pages;

import com.demoqa.entities.TextBoxEntity;
import com.demoqa.helper.WebElementActions;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TextBoxPage extends BasePage { // тут хранятся веб элементы которые внутри этой страницы

    //коструктор
//    public TextBoxPage() throws InterruptedException {      //инициализирует TextBoxPage.class
//        PageFactory.initElements(DriverManager.getDriver(), TextBoxPage.class);//@FindBy не может работать без PageFactory, потому что в PageFactory есть метод initElements
//    }

    @FindBy(xpath ="//*[@id='userName']")
    public WebElement fullNameInput;

    @FindBy(id = "userEmail")
    public WebElement emailInput;

    @FindBy(id = "currentAddress")
    WebElement currentAddressInput;

    @FindBy(id = "permanentAddress")
    public WebElement permanentAddresseInput;

    @FindBy(id = "submit")
    public WebElement submitBtn;


    public TextBoxPage fillUpTextBoxForm(String fullname, String email, String currentAddress, String permanentAddress) {
        webElementActions.jsSendKeys(fullNameInput,fullname)
                .jsSendKeys(emailInput,email)
                .jsSendKeys(currentAddressInput,currentAddress)
                .jsSendKeys(permanentAddresseInput,permanentAddress)
                .click(submitBtn);
        return this;
    }

    @Step("Fill up text box form")
    public TextBoxPage fillUpTextBoxForm(TextBoxEntity textBoxEntity) {
        webElementActions.sendKeys(fullNameInput,textBoxEntity.getFullName())
                .sendKeys(emailInput, textBoxEntity.getEmail())
                .sendKeys(currentAddressInput, textBoxEntity.getCurrentAddress())
                .sendKeys(permanentAddresseInput, textBoxEntity.getPermanentAddress())
                .click(submitBtn);
        return this;
}
}
