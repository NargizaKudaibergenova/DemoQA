
import com.demoqa.utils.ConfigReader;
import io.qameta.allure.*;
import io.qameta.allure.testng.Tag;
import org.testng.annotations.Test;
import static com.demoqa.enums.Endpoints.ALERTS;

public class AlertTest extends BaseTest {

    @Description("Описание к методу")
    @Owner("NArgiza, (ответственный за выполнение и поддержку теста)")
    @Tag("Smoke") //добавления меток или тегов к тестовым методам, что позволяет лучше
                // структурировать отчеты и фильтровать тесты по их атрибутам
    @Severity(SeverityLevel.CRITICAL) //"для определения уровня серьёзности теста")
    @Story("для указания истории или функциональности")
    @Epic("Registration")
    @Link("www.google.com") //ссылки

    @Test (groups = {"Smoke", "UI", "1212"}, description = "Alert test")
    void alertTest() {
        browserHelper.open(ConfigReader.getValue("baseDevURL") + ALERTS.getEndpoint());
        //driver.get("https://demoqa.com/alerts");
        webElementActions.click(demoQAPages.getAlertPage().confirmAlertBtn);
        alertHelper.acceptAlert();
        webElementActions.pause(5);
    }

    @Test (groups = {"Regression", "API", "12123"}, description = "Alert test1")
    void alertTest1(){
        driver.get("https://demoqa.com/alerts");
        webElementActions.click(demoQAPages.getAlertPage().confirmAlertBtn);
        alertHelper.acceptAlert();
        webElementActions.pause(5);
    }

    @Test (groups = {"E2E", "SQL", "1212"}, description = "Alert test2")
    void alertTest2() {
        driver.get("https://demoqa.com/alerts");
        webElementActions.click(demoQAPages.getAlertPage().confirmAlertBtn);
        alertHelper.acceptAlert();
        webElementActions.pause(5);
    }
}
