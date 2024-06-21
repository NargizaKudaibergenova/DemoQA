
import com.demoqa.entities.PracticeFormEntity;
import com.demoqa.enums.Endpoints;
import com.demoqa.utils.ConfigReader;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.time.Duration;

public class PracticeFormTest extends BaseTest {

    @Test
    public void practiceFormTest() {
        browserHelper.open(ConfigReader.getValue("baseDevURL") + Endpoints.PRACTICEFORM.getEndpoint());
        //driver.get("https://demoqa.com/automation-practice-form");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        System.out.println("Генерация данных формы");
        PracticeFormEntity practiceFormEntity = randomUtils.generateRandomPracticeFormEntity();
        System.out.println("Сгенерированные данные: " + practiceFormEntity);

        System.out.println("Заполнение формы");
        demoQAPages.getPracticeFormPage().fillPracticeForm(practiceFormEntity);

        System.out.println("Проверка результата");
        String text = driver.findElement(By.xpath("//*[text()='Thanks for submitting the form']")).getText();

        Assert.assertEquals(text, "Thanks for submitting the form");
        System.out.println("Тест успешно пройден");

    }

    @Test
    public void calendarTest() throws InterruptedException {
        browserHelper.open("https://demoqa.com/automation-practice-form");
        demoQAPages.getPracticeFormPage().selectDateMonthYear("21 September 1986");
        Thread.sleep(5000);
    }

    }


