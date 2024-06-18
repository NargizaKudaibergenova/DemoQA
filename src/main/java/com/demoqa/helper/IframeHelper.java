package com.demoqa.helper;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class IframeHelper {

    private WebDriver driver;

    public IframeHelper(WebDriver driver){
        this.driver = driver;
    }
//переключиться (вернуться) к родителю
    public void switchToParentFrame(){
        driver.switchTo().parentFrame();//переключиться к родителю
    }

    //переключись на другой frames
    public void switchToFrame(String nameOrID){
        new WebDriverWait(driver, Duration.ofSeconds(15))
                .until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(nameOrID));//подожди пока не появится frame и если появиться то переключись

    }
}
