package com.demoqa.pages;

import com.demoqa.drivers.DriverManager;
import com.demoqa.entities.PracticeFormEntity;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;
import java.util.List;
import java.util.Random;

public class PracticeFormPage extends BasePage {

    @FindBy(id = "firstName")
    public WebElement firstNameInput;

    @FindBy(id = "lastName")
    public WebElement lastNameInput;

    @FindBy(id = "userEmail")
    public WebElement emailInput;

    @FindBy(xpath = "//*[@id=\"genterWrapper\"]/div[2]/div[1]/label")
    public WebElement genderMale;

    @FindBy(xpath = "//*[@id=\"genterWrapper\"]/div[2]/div[2]/label")
    public WebElement genderFemale;

    @FindBy(xpath = "//*[@id=\"genterWrapper\"]/div[2]/div[3]/label")
    public WebElement genderOther;

    @FindBy(id = "userNumber")
    public WebElement mobileNumberInput;

    @FindBy(className = "react-datepicker__input-container")
    public WebElement dateOfBirthInput;

    @FindBy(id = "subjectsInput")
    public WebElement subjects;

    @FindBy(xpath = "//*[@id=\"hobbiesWrapper\"]/div[2]/div[1]/label")
    public WebElement hobbiesSports;

    @FindBy(xpath = "//*[@id=\"hobbiesWrapper\"]/div[2]/div[2]/label")
    public WebElement hobbiesReading;

    @FindBy(xpath = "//*[@id=\"hobbiesWrapper\"]/div[2]/div[3]/label")
    public WebElement hobbiesMusic;

    @FindBy(id = "uploadPicture")
    public WebElement picture;

    @FindBy(id = "currentAddress")
    public WebElement currentAddressInput;

    @FindBy(id = "react-select-3-input")
    public WebElement stateInput;

    @FindBy(id = "react-select-4-input")
    public WebElement cityInput;

//    @FindBy(id = "//*[@id='state']//input")
//    public WebElement stateInput;
//
//    @FindBy(id = "//*[@id='city']//input")
//    public WebElement cityInput;

    @FindBy(id = "submit")
    public WebElement submitBtn;


    public List<WebElement> listGender = List.of(genderMale, genderFemale, genderOther);
    Random random = new Random();
    WebElement randomGender = listGender.get(random.nextInt(listGender.size()));

    public List<WebElement> listHobbies = List.of(hobbiesSports, hobbiesReading, hobbiesMusic);
    WebElement randomHobbies = listHobbies.get(random.nextInt((listHobbies.size())));


    public PracticeFormPage fillPracticeForm(PracticeFormEntity practiceFormEntity) {

        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(20));

        webElementActions.sendKeys(firstNameInput, practiceFormEntity.getFirstName())
                .sendKeys(lastNameInput, practiceFormEntity.getLastName())
                .sendKeys(emailInput, practiceFormEntity.getEmail())
                .click(randomGender)
                .sendKeys(mobileNumberInput, practiceFormEntity.getMobileNumber())
                .sendKeysWithEnter(subjects, practiceFormEntity.getSubjects())
                .moveToElement(randomHobbies)
                .click(randomHobbies);
        // Логирование и проверка файла
//        String picturePath = practiceFormEntity.getPicture();
//        File pictureFile = new File(picturePath);
//        if (!pictureFile.exists()){
//            throw  new IllegalArgumentException("Файл не существует: " + picturePath);
//        }
//        System.out.println("Путь к картинке: " + picturePath);
//                webElementActions.sendKeys(picture, picturePath);

                webElementActions.sendKeys(currentAddressInput, practiceFormEntity.getCurrentAddress())
                .sendKeysWithEnter(stateInput, practiceFormEntity.getState())
                .sendKeysWithEnter(cityInput, practiceFormEntity.getCity())
                .click(submitBtn);

        // Явное ожидание для проверки элемента
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Thanks for submitting the form']")));

        return this;
    }

//календарь
@Step("select Date Month and Year") //помогает разбить выполнение теста на отдельные шаги
public PracticeFormPage selectDateMonthYear(String dateMonthYear){
        //dateMonthYear передается как один String
        String [] dateMonthYearParts = dateMonthYear.split(" "); //split это значит разделить т.е. поставить пробел
        String date = dateMonthYearParts[0];
        String month = dateMonthYearParts[1];
        String year = dateMonthYearParts[2];

        webElementActions.click(dateOfBirthInput);

        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(10));

        WebElement monthDropDown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("react-datepicker__month-select")));
        WebElement yearDropDown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("react-datepicker__year-select")));

        dropdownHelper.selectByVisibleText(monthDropDown, month)
                .selectByVisibleText(yearDropDown, year);

        // //div[contains(@class,'react-datepicker__day') and not (contains(@class,'react-datepicker__day--outside-month')) and text()='4']
        WebElement day = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath(
                        "//div[contains(@class,'react-datepicker__day') and not (contains(@class,'react-datepicker__day--outside-month')) and text()='" + date +"']")));

        webElementActions.click(day);

        return this;
    }

}

