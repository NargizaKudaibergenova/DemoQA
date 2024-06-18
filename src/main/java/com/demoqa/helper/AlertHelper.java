package com.demoqa.helper;

import com.demoqa.drivers.DriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AlertHelper {

    //обьект драйвера
    private WebDriver driver = DriverManager.getDriver();

    //конструктор класса
    public AlertHelper(WebDriver driver) {
        this.driver = driver;
    }

    //метод чтобы переключиться на всплывающее окно т.е. в Alert
    public Alert getAlert() {
        new WebDriverWait(driver, Duration.ofSeconds(10))//ставим явные ожидания
                .until(ExpectedConditions.alertIsPresent());//типа, жди пока Alert не появится
        return driver.switchTo().alert();//переключись на всплывающее окно
    }

    //метод на кнопку ОК
    public void acceptAlert(){
        getAlert().accept();//вызываем метод getAlert и далее метод accept() это значит принимать
    }

    //метод на кнопку Cancel
    public void dismissAllert(){
        getAlert().dismiss();// т.е.не принимать
    }

    //вытащить текст в Alert
    public String getAlertText(){
        return getAlert().getText();
    }

    //проверяет есть ли Alert или нет
    public boolean isAlertPresent(){
        try {
            driver.switchTo().alert();//если есть то прими его
            return true; //возврати true
        }catch (NoAlertPresentException e){ //если нет его то возврати false
            return false;
        }
    }

    // если Alert есть то мы можем принять его
    public void acceptAlertIfPresented(){
        if (!isAlertPresent())
            return; //return служит как выход если нет Alert
        acceptAlert();//это если есть
    }

    //если Alert нет то мы можем отклонить его
    public void dismissAlertIfPresented(){
        if (!isAlertPresent())
            return;
        dismissAllert(); //нажать кнопку Cancel т.е. отклонить
    }

    //метод чтобы в всплывающем окне(Alert) напечатать(prompt) с кнопкой ОК
    public void acceptPrompt(String txt){
        if (!isAlertPresent()) //если Alert нету то return т.е.выход
            return;
        Alert alert = getAlert();//если есть то найди Alert
        alert.sendKeys(txt);//набери текст
        alert.accept();//кнопка ОК
    }

    ///метод чтобы в всплывающем(Alert) окне напечатать(prompt) с кнопкой Cancel
    public void dismissPrompt(String txt){
        if (!isAlertPresent()) //если Alert нету то return т.е.выход
            return;
        Alert alert = getAlert();//если есть то найди Alert
        alert.sendKeys(txt);//набери текст
        alert.dismiss();//кнопка Cancel
    }

}
