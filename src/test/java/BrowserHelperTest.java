import com.demoqa.enums.Endpoints;
import com.demoqa.utils.ConfigReader;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class BrowserHelperTest extends BaseTest {

    @Test
    void test123() throws InterruptedException {
        browserHelper.open(ConfigReader.getValue("baseDevURL") + Endpoints.BROWSERWINDOWS.getEndpoint());
        // driver.findElement(By.xpath("//span[text()='Alerts']")).click();//c browser-windows перешли на страницу Alerts
        Thread.sleep(4000);
//        browserHelper.goBack();//вернулись назад
//        Thread.sleep(4000);
//        browserHelper.goForward();//нажал кнопку вперед
//        Thread.sleep(4000);
//        browserHelper.refreshThePage();// обновил старницу

        //использование методов по вкладке
        driver.findElement(By.id("tabButton")).click();
        Thread.sleep(4000);
        browserHelper.switchToWindow(0);
        Thread.sleep(4000);
        driver.findElement(By.id("tabButton")).click();
        Thread.sleep(4000);
        browserHelper.switchToWindow(0);
        driver.findElement(By.id("tabButton")).click();
        Thread.sleep(4000);
        browserHelper.switchToWindow(0);
        driver.findElement(By.id("tabButton")).click();
        Thread.sleep(4000);
        browserHelper.switchToWindow(4);
        Thread.sleep(4000);

        browserHelper.switchToParentWindow();
        Thread.sleep(4000);


    }
}
