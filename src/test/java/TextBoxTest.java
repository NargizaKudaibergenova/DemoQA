
import com.demoqa.entities.TextBoxEntity;
import com.demoqa.enums.Endpoints;
import com.demoqa.utils.ConfigReader;
import org.testng.annotations.Test;

public class TextBoxTest extends BaseTest {

    @Test
    public void textBoxTest() {
        browserHelper.open(ConfigReader.getValue("baseDevURL") + Endpoints.TEXTBOX.getEndpoint());
        //driver.get("https://demoqa.com/text-box");

        TextBoxEntity textBoxEntity = randomUtils.generateRandomTextBoxEntity();
        demoQAPages.getTextBoxPage().fillUpTextBoxForm(textBoxEntity);


    }

}
