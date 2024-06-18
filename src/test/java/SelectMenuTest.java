import com.demoqa.drivers.DriverManager;
import com.demoqa.enums.Endpoints;
import com.demoqa.helper.DropdownHelper;
import com.demoqa.utils.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class SelectMenuTest extends BaseTest {

    @Test
    void test123() throws InterruptedException {
        browserHelper.open(ConfigReader.getValue("baseDevURL") + Endpoints.SELECTMENU.getEndpoint());
        //driver.get("https://demoqa.com/select-menu");
        WebElement selectMenu = driver.findElement(By.id("oldSelectMenu"));

        DropdownHelper dropdownHelper = new DropdownHelper(driver);

        dropdownHelper.selectByVisibleText(selectMenu, "Blue");

        Thread.sleep(4000);
    }


    @Test
    public void selectValueTest() throws InterruptedException {
        browserHelper.open(ConfigReader.getValue("baseDevURL") + Endpoints.SELECTMENU.getEndpoint());
        //driver.get("https://demoqa.com/select-menu");
        demoQAPages.getSelectMenuPage().selectValue.click();

        List<WebElement> options = demoQAPages.getSelectMenuPage().classMenu.findElements(By.xpath("//div[@class=' css-26l3qy-menu']"));
        for (WebElement option : options) {
            System.out.println(option.getText());
        }
        Thread.sleep(6000);
    }

    @Test
    public void selectOneTest() {
        browserHelper.open(ConfigReader.getValue("baseDevURL") + Endpoints.SELECTMENU.getEndpoint());
        //driver.get("https://demoqa.com/select-menu");
        demoQAPages.getSelectMenuPage().selectOne.click();

        List<WebElement> options2 = demoQAPages.getSelectMenuPage().selectOne.findElements(By.xpath("(//div[@class=' css-26l3qy-menu'])[1]"));
        for (WebElement option2 : options2) {
            System.out.println(option2.getText());
        }
    }

    @Test
    public void oldStyleSelectMenuTest() {
        browserHelper.open(ConfigReader.getValue("baseDevURL") + Endpoints.SELECTMENU.getEndpoint());
        //driver.get("https://demoqa.com/select-menu");
        demoQAPages.getSelectMenuPage().oldStyleSelectMenu.click();

        List<WebElement> options3 = demoQAPages.getSelectMenuPage().oldStyleSelectMenu.findElements(By.xpath("//select[@id='oldSelectMenu']"));
        for (WebElement option3 : options3) {
            System.out.println(option3.getText());
        }
    }

    @Test
    public void multiselectDropDownTest() {
        browserHelper.open(ConfigReader.getValue("baseDevURL") + Endpoints.SELECTMENU.getEndpoint());
        //driver.get("https://demoqa.com/select-menu");
        demoQAPages.getSelectMenuPage().multiselectDropDown.click();

        List<WebElement> options4 = demoQAPages.getSelectMenuPage().multiselectDropDown.findElements(By.xpath("//div[@class=' css-26l3qy-menu']/div[1]"));
        for (WebElement option4 : options4) {
            System.out.println(option4.getText());
        }
    }

    @Test
    public void standardMultiSelectTest() {
        browserHelper.open(ConfigReader.getValue("baseDevURL") + Endpoints.SELECTMENU.getEndpoint());
        //driver.get("https://demoqa.com/select-menu");

        List<WebElement> options5 = demoQAPages.getSelectMenuPage().standardMultiSelect.findElements(By.xpath("//select[@name='cars']"));
        for (WebElement option5 : options5)
            System.out.println(option5.getText());

    }
}

