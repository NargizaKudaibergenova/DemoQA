import com.demoqa.drivers.DriverManager;
import com.demoqa.helper.AlertHelper;
import com.demoqa.helper.BrowserHelper;
import com.demoqa.helper.IframeHelper;
import com.demoqa.helper.WebElementActions;
import com.demoqa.pages.*;
import com.demoqa.utils.RandomUtils;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;

public class BaseTest {

    protected WebDriver driver;
    protected RandomUtils randomUtils;
    protected WebElementActions webElementActions;
    protected AlertHelper alertHelper;
    protected BrowserHelper browserHelper;
    protected DemoQAPages demoQAPages;
    protected IframeHelper iframeHelper;

    @BeforeClass(alwaysRun = true)//создаем обьекты тут как шаблон
    public void setUp() throws MalformedURLException {
        driver = DriverManager.getDriver();
        randomUtils = new RandomUtils();
        webElementActions = new WebElementActions();
        alertHelper = new AlertHelper(driver);
        browserHelper = new BrowserHelper(driver);
        demoQAPages = new DemoQAPages();
        demoQAPages.setUp(); //мы инициализировали т.к.Если не вызвать это то объекты страниц останутся null
        iframeHelper = new IframeHelper(driver);
    }


    @AfterClass(alwaysRun = true)
    public void tearDown() throws InterruptedException {
        Thread.sleep(7000);
        DriverManager.closeDriver();
    }
}
