import com.demoqa.enums.Endpoints;
import com.demoqa.pages.BasePage;
import com.demoqa.utils.ConfigReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ButtonsTest extends BaseTest {

@Test(description = "Убедитесь что кнопка двойного щелчка работает корректно")
    public void doubleClickTest(){
    browserHelper.open(ConfigReader.getValue("baseDevURL") + Endpoints.BUTTONS.getEndpoint());
    webElementActions.doubleClick(demoQAPages.getButtonsPage().doubleClickBtn);
    Assert.assertEquals(demoQAPages.getButtonsPage().doubleClickMessage.getText(), "You have done a double click");
}

@Test(description = "Убедитесь что кнопка щелчка правой мышкой работает корректно")
    public void rightClickTest(){
    browserHelper.open(ConfigReader.getValue("baseDevURL") + Endpoints.BUTTONS.getEndpoint());
    webElementActions.rightClick(demoQAPages.getButtonsPage().rightClickBtn);
    Assert.assertEquals(demoQAPages.getButtonsPage().rightClickMessage.getText(), "You have done a right click");
}

@Test(description = "Убедитесь что кнопка обычного щелчка работает корректно")
    public void clickMe(){
    browserHelper.open(ConfigReader.getValue("baseDevURL") + Endpoints.BUTTONS.getEndpoint());
    webElementActions.clickMe(demoQAPages.getButtonsPage().clickMeBtn);
    Assert.assertEquals(demoQAPages.getButtonsPage().dynamicClickMessage.getText(), "You have done a dynamic click");
}

}
