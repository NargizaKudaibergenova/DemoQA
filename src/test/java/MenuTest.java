import com.demoqa.enums.Endpoints;
import com.demoqa.utils.ConfigReader;
import org.testng.annotations.Test;

public class MenuTest extends BaseTest {

    @Test(description = "Убедитесь, что методы перемещения элемента работают")
    public void moveToElementTest() throws InterruptedException {
       browserHelper.open(ConfigReader.getValue("baseDevURL") + Endpoints.MENU.getEndpoint());
        //browserHelper.open("https://demoqa.com/menu");
        webElementActions.moveToElement(demoQAPages.getMenuPage().mainItem2);
//        webElementActions.moveToElement(demoQAPages.getMenuPage().subItem);
//        webElementActions.moveToElement(demoQAPages.getMenuPage().subItem2);
        Thread.sleep(5000);
    }
}
