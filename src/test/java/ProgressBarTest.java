import com.demoqa.enums.Endpoints;
import com.demoqa.utils.ConfigReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProgressBarTest extends BaseTest {

    @Test(description = "")
    public void progressBarTest() throws InterruptedException {
        browserHelper.open("https://demoqa.com/progress-bar");
        webElementActions.click(demoQAPages.getProgressBarPage().startStopBtn);

        Thread.sleep(2000);
        webElementActions.click(demoQAPages.getProgressBarPage().startStopBtn);
        Thread.sleep(6000);

        System.out.println(demoQAPages.getProgressBarPage().aria_valuenow.getAttribute("aria-valuenow"));

       // Assert.assertEquals(demoQAPages.getProgressBarPage().aria_valuenow.getAttribute("aria-valuenow"), "21");
    }

    @Test(description = "Проверить, чтобы индикатор выполнения остановится, когда он достигнет 52%")
    public void progressBarTest52Percent() {
        browserHelper.open(ConfigReader.getValue("baseDevURL") + Endpoints.PROGRESSBAR.getEndpoint());
        //browserHelper.open("https://demoqa.com/progress-bar");

        webElementActions.click(demoQAPages.getProgressBarPage().startStopBtn);

        String value;
        while (true) {
            value = demoQAPages.getProgressBarPage().aria_valuenow.getAttribute("aria-valuenow");
            if (value.equals("52")) {
                webElementActions.click(demoQAPages.getProgressBarPage().startStopBtn);
                break;
            }
        }
        System.out.println(value);
        Assert.assertEquals(value, "52");
    }
}
