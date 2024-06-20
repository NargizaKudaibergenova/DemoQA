import com.demoqa.entities.EmployeeEntity;
import com.demoqa.enums.Endpoints;
import com.demoqa.utils.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class WebTableTest extends BaseTest {

    @Test
    public void test123() {
        browserHelper.open(ConfigReader.getValue("baseDevURL") + Endpoints.WEBTABLES.getEndpoint());
        //driver.get("https://demoqa.com/webtables");
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //Employee employee1 = randomUtils.createMockEmployee();

        // Извлекаем список сотрудников из веб-таблицы
        List<EmployeeEntity> employees = demoQAPages.getWebTablePage().getEmployeesFromTable();

        // Печатаем информацию о каждом сотруднике
        for (EmployeeEntity employee : employees) {
            System.out.println(employee);
        }
        for (String emploee : demoQAPages.getWebTablePage().emails) {
            System.out.println(emploee);
        }
    }

    @Test(description = "добавление и удаление из списка")
    public void test456() throws Exception {
        browserHelper.open(ConfigReader.getValue("baseDevURL") + Endpoints.WEBTABLES.getEndpoint());
        //driver.get("https://demoqa.com/webtables");

        demoQAPages.getWebTablePage().addNewEmployee(randomUtils.createMockEmployee());
        List<EmployeeEntity> employees = demoQAPages.getWebTablePage().getEmployeesAndEmailFromTable();
        for (EmployeeEntity employee : employees) {
            System.out.println(employee);
        }
//        System.out.println("");

        for (String email : demoQAPages.getWebTablePage().emails) {
            System.out.println(email);
        }
//        System.out.println("");
        Thread.sleep(7000);
        demoQAPages.getWebTablePage().removeFromList();

        for (EmployeeEntity employee : employees) {
            System.out.println(employee);
        }
    }

    @Test(description = "редактирует случайные поля")
    public void editRandomFieldsTest() {
        browserHelper.open(ConfigReader.getValue("baseDevURL") + Endpoints.WEBTABLES.getEndpoint());

        //driver.get("https://demoqa.com/webtables");

        List<EmployeeEntity> employees = demoQAPages.getWebTablePage().getEmployeesAndEmailFromTable();
        for (EmployeeEntity employee : employees) {
            System.out.println(employee);
        }
        //System.out.println("");
        demoQAPages.getWebTablePage().editRandomFields();

        List<EmployeeEntity> employees1 = demoQAPages.getWebTablePage().getEmployeesAndEmailFromTable();
        for (EmployeeEntity employee : employees1) {
            System.out.println(employee);
        }
    }
}
