import com.demoqa.enums.Endpoints;
import com.demoqa.utils.ConfigReader;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class FrameTest extends BaseTest {

    @Test(description = "Убедитесь, что драйвер может переключиться на другой frame")
    public void doubleClickTest() {
        browserHelper.open(ConfigReader.getValue("baseDevURL") + Endpoints.FRAMES.getEndpoint());
        iframeHelper.switchToFrame("frame1"); //переключись на другой frames
        System.out.println(driver.findElement(By.id("sampleHeading")).getText());
        iframeHelper.switchToParentFrame();//переключиться к родителю
        System.out.println(driver.findElement(By.tagName("h1")).getText());


    }


}
