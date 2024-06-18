package com.demoqa.pages;
import lombok.*;
import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Builder
public class DemoQAPages {

    protected TextBoxPage textBoxPage;
    protected AlertPage alertPage;
    protected ButtonsPage buttonsPage;
    protected MenuPage menuPage;
    protected PracticeFormPage practiceFormPage;
    protected ProgressBarPage progressBarPage;
    protected SelectMenuPage selectMenuPage;
    protected WebTablePage webTablePage;


    @BeforeClass(alwaysRun = true)//создаем обьекты тут как шаблон
    public void setUp() throws MalformedURLException {

        textBoxPage = new TextBoxPage();
        alertPage = new AlertPage();
        buttonsPage = new ButtonsPage();
        menuPage = new MenuPage();
        progressBarPage = new ProgressBarPage();
        practiceFormPage = new PracticeFormPage();
        selectMenuPage = new SelectMenuPage();
        webTablePage = new WebTablePage();

    }
}
