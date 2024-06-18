package com.demoqa.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProgressBarPage extends BasePage {

    @FindBy(id = "startStopButton")
    public WebElement startStopBtn;

    @FindBy(id = "progressBar")
    public WebElement progressBar;

    @FindBy(xpath = "//div[@aria-valuenow]")
    public WebElement aria_valuenow;

    public void startProgressBar(){
        startStopBtn.click();
    }

    @Step("Get progress bar value")
    public int getProgressBarValue(){
        String value = aria_valuenow.getAttribute("aria_valuenow");
        return Integer.parseInt(value);
    }

}

