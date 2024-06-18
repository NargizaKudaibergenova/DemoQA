import com.demoqa.pages.OrangePage.OrangeEnum;
import com.demoqa.pages.OrangePage.OrangeMenuEnum;
import com.demoqa.utils.ConfigReader;
import org.testng.annotations.Test;

public class OrangeTest extends BaseTest{

@Test
    public void testOrange(){

    browserHelper.open(ConfigReader.getValue("baseURL") + OrangeEnum.ORANGE.getEndpoint());
    demoQAPages.getOrangePage().fillUpUsernameAndPassword("Admin", "admin123");
    webElementActions.pause(5);

    demoQAPages.getOrangePage().selectMenuOrange(OrangeMenuEnum.ADMIN);
    webElementActions.pause(5);

    //demoQAPages.getOrangePage().systemUserSearch("Admin");
}
}
