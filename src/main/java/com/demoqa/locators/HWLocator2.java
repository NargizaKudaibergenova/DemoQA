package com.demoqa.locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.time.Duration;
import java.util.List;

public class HWLocator2 {

    WebDriver driver;

    @BeforeClass
    void openBrowsers() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Home\\DemoQAWinter24\\src\\main\\resources\\drivers\\chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        Thread.sleep(5000);
        driver.get("https://dostavka312.kg/");
    }

    @AfterSuite
    void СloseTab() throws InterruptedException {
        Thread.sleep(5000);
        driver.close();
        driver.quit();
    }

    @Test
    public void openLinks() throws Exception {
        WebElement mainmenu = driver.findElement(By.xpath("//*[@id=\"tab-01\"]/div/p/a/img"));
        mainmenu.click();

        WebElement textRestaurant = driver.findElement(By.xpath("//h2[normalize-space(text())='Все заведения']"));
        System.out.println(" " + "Открытые" + " " + textRestaurant.getText() + ":");

        List<WebElement> listOfRestaurants = driver.findElements(By.xpath("//div[@class='panel-heading']//p[1]"));
        listOfRestaurants.stream()              //создает поток из списка элементов listOfRestaurants
                .map(WebElement::getText)       //преобразует каждый WebElement в его текстовое представление
                .forEach(System.out::println);  //выводит каждый текст на консоль

        for (WebElement list : listOfRestaurants) {
            if (list.getText().equals("Ресторан Пишпек")) {
                WebElement pishpek = driver.findElement(By.xpath("//a[@href='https://dostavka312.kg/garnirygpt/restoran-pishpek']"));
                pishpek.click();
                break;
            }
        }
    }

    @AfterTest
    public void listFoods() {
        //Завтраки
        WebElement breakfasts = driver.findElement(By.xpath("//a[@href='https://dostavka312.kg/garnirygpt/restoran-pishpek#menu_0']"));
        breakfasts.click();
        WebElement textBreakfast = driver.findElement(By.xpath("//h2[a[@name='menu_0']]"));
        System.out.println(" " + " " + textBreakfast.getText() + ":");
        WebElement listBreakfast = textBreakfast.findElement(By.xpath("./following-sibling::div[contains(@class, 'product')]"));

        List<WebElement> menuBreakfast = listBreakfast.findElements(By.xpath(".//div[@class='food-title']/p[@class='product-name']"));
        for (WebElement menuBreak : menuBreakfast) {
            System.out.println(menuBreak.getText());
        }
        System.out.println();

//Холодные закуски
        WebElement coldSnacks = driver.findElement(By.xpath("//a[@href='https://dostavka312.kg/garnirygpt/restoran-pishpek#menu_1']"));
        coldSnacks.click();
        WebElement coldSnack = driver.findElement(By.xpath("//h2[a[@name='menu_1']]"));
        System.out.println(" " + " " + coldSnack.getText() + ":");
        WebElement listColdSnacks = coldSnack.findElement(By.xpath("./following-sibling::div[contains(@class, 'product')]"));

        List<WebElement> menuColdSnacks = listColdSnacks.findElements(By.xpath(".//div[@class='food-title']/p[@class='product-name']"));
        menuColdSnacks.stream()
                .map(WebElement::getText)
                .forEach(System.out::println);
        System.out.println();

//Салаты
        WebElement salads = driver.findElement(By.xpath("//a[@href='https://dostavka312.kg/garnirygpt/restoran-pishpek#menu_2']"));
        salads.click();
        WebElement textSalads = driver.findElement(By.xpath("//h2[a[@name='menu_2']]"));
        System.out.println(" " + " " + textSalads.getText() + ":");
        WebElement listSalads = textSalads.findElement(By.xpath("./following-sibling::div[contains(@class, 'product')]"));

        List<WebElement> menuSalads = listSalads.findElements(By.xpath(".//div[@class='food-title']/p[@class='product-name']"));
        menuSalads.stream()
                .map(WebElement::getText)
                .forEach(System.out::println);
        System.out.println();

//Супы
        WebElement Soups = driver.findElement(By.xpath("//a[@href='https://dostavka312.kg/garnirygpt/restoran-pishpek#menu_3']"));
        Soups.click();
        WebElement textSoups = driver.findElement(By.xpath("//h2[a[@name='menu_3']]"));
        System.out.println(" " + " " + textSoups.getText() + ":");
        WebElement listSoups = textSoups.findElement(By.xpath("./following-sibling::div[contains(@class, 'product')]"));

        List<WebElement> menuSoups = listSoups.findElements(By.xpath(".//div[@class='food-title']/p[@class='product-name']"));
        menuSoups.stream()
                .map(WebElement::getText)
                .forEach(System.out::println);
        System.out.println();

//Горячие блюда восточной кухни
        WebElement HotDishesVostok = driver.findElement(By.xpath("//a[@href='https://dostavka312.kg/garnirygpt/restoran-pishpek#menu_4']"));
        HotDishesVostok.click();
        WebElement textHotDishesVostok = driver.findElement(By.xpath("//h2[a[@name='menu_4']]"));
        System.out.println(" " + " " + textHotDishesVostok.getText() + ":");
        WebElement listHotDishesVostok = textHotDishesVostok.findElement(By.xpath("./following-sibling::div[contains(@class, 'product')]"));

        List<WebElement> menuHotDishesVostok = listHotDishesVostok.findElements(By.xpath(".//div[@class='food-title']/p[@class='product-name']"));
        menuHotDishesVostok.stream()
                .map(WebElement::getText)
                .forEach(System.out::println);
        System.out.println();

//Крем супы
        WebElement CreamSoups = driver.findElement(By.xpath("//a[@href='https://dostavka312.kg/garnirygpt/restoran-pishpek#menu_5']"));
        CreamSoups.click();
        WebElement textCreamSoups = driver.findElement(By.xpath("//h2[a[@name='menu_5']]"));
        System.out.println(" " + " " + textCreamSoups.getText() + ":");
        WebElement listCreamSoups = textCreamSoups.findElement(By.xpath("./following-sibling::div[contains(@class, 'product')]"));

        List<WebElement> menuCreamSoups = listCreamSoups.findElements(By.xpath(".//div[@class='food-title']/p[@class='product-name']"));
        menuCreamSoups.stream()
                .map(WebElement::getText)
                .forEach(System.out::println);
        System.out.println();

// Восточные супы
        WebElement OrientalSoups = driver.findElement(By.xpath("//a[@href='https://dostavka312.kg/garnirygpt/restoran-pishpek#menu_6']"));
        OrientalSoups.click();
        WebElement textOrientalSoups = driver.findElement(By.xpath("//h2[a[@name='menu_6']]"));
        System.out.println(" " + " " + textOrientalSoups.getText() + ":");
        WebElement listOrientalSoups = textOrientalSoups.findElement(By.xpath("./following-sibling::div[contains(@class, 'product')]"));

        List<WebElement> menuOrientalSoups = listOrientalSoups.findElements(By.xpath(".//div[@class='food-title']/p[@class='product-name']"));
        menuOrientalSoups.stream()
                .map(WebElement::getText)
                .forEach(System.out::println);
        System.out.println();

//Горячие закуски
        WebElement HotSnacks = driver.findElement(By.xpath("//a[@href='https://dostavka312.kg/garnirygpt/restoran-pishpek#menu_7']"));
        HotSnacks.click();
        WebElement textHotSnacks = driver.findElement(By.xpath("//h2[a[@name='menu_7']]"));
        System.out.println(" " + " " + textHotSnacks.getText() + ":");
        WebElement listHotSnacks = textHotSnacks.findElement(By.xpath("./following-sibling::div[contains(@class, 'product')]"));

        List<WebElement> menuHotSnacks = listHotSnacks.findElements(By.xpath(".//div[@class='food-title']/p[@class='product-name']"));
        menuHotSnacks.stream()
                .map(WebElement::getText)
                .forEach(System.out::println);
        System.out.println();

// Выпечка
        WebElement Bakery = driver.findElement(By.xpath("//a[@href='https://dostavka312.kg/garnirygpt/restoran-pishpek#menu_8']"));
        Bakery.click();
        WebElement textBakery = driver.findElement(By.xpath("//h2[a[@name='menu_8']]"));
        System.out.println(" " + " " + textBakery.getText() + ":");
        WebElement listBakery = textBakery.findElement(By.xpath("./following-sibling::div[contains(@class, 'product')]"));

        List<WebElement> menuBakery = listBakery.findElements(By.xpath(".//div[@class='food-title']/p[@class='product-name']"));
        menuBakery.stream()
                .map(WebElement::getText)
                .forEach(System.out::println);
        System.out.println();

//Паста
        WebElement Paste = driver.findElement(By.xpath("//a[@href='https://dostavka312.kg/garnirygpt/restoran-pishpek#menu_9']"));
        Paste.click();
        WebElement textPaste = driver.findElement(By.xpath("//h2[a[@name='menu_9']]"));
        System.out.println(" " + " " + textPaste.getText() + ":");
        WebElement listPaste = textPaste.findElement(By.xpath("./following-sibling::div[contains(@class, 'product')]"));

        List<WebElement> menuPaste = listPaste.findElements(By.xpath(".//div[@class='food-title']/p[@class='product-name']"));
        menuPaste.stream()
                .map(WebElement::getText)
                .forEach(System.out::println);
        System.out.println();

//Стейки
        WebElement Steaks = driver.findElement(By.xpath("//a[@href='https://dostavka312.kg/garnirygpt/restoran-pishpek#menu_10']"));
        Steaks.click();
        WebElement textSteaks = driver.findElement(By.xpath("//h2[a[@name='menu_10']]"));
        System.out.println(" " + " " + textSteaks.getText() + ":");
        WebElement listSteaks = textSteaks.findElement(By.xpath("./following-sibling::div[contains(@class, 'product')]"));

        List<WebElement> menuSteaks = listSteaks.findElements(By.xpath(".//div[@class='food-title']/p[@class='product-name']"));
        menuSteaks.stream()
                .map(WebElement::getText)
                .forEach(System.out::println);
        System.out.println();

// Горячие блюда европейской кухни
        WebElement HotEuropeanDishes = driver.findElement(By.xpath("//a[@href='https://dostavka312.kg/garnirygpt/restoran-pishpek#menu_11']"));
        HotEuropeanDishes.click();
        WebElement textHotEuropeanDishes = driver.findElement(By.xpath("//h2[a[@name='menu_11']]"));
        System.out.println(" " + " " + textHotEuropeanDishes.getText() + ":");
        WebElement listHotEuropeanDishes = textHotEuropeanDishes.findElement(By.xpath("./following-sibling::div[contains(@class, 'product')]"));

        List<WebElement> menuHotEuropeanDishes = listHotEuropeanDishes.findElements(By.xpath(".//div[@class='food-title']/p[@class='product-name']"));
        menuHotEuropeanDishes.stream()
                .map(WebElement::getText)
                .forEach(System.out::println);
        System.out.println();

//Блюда из рыбы
        WebElement FishDishes = driver.findElement(By.xpath("//a[@href='https://dostavka312.kg/garnirygpt/restoran-pishpek#menu_12']"));
        FishDishes.click();
        WebElement textFishDishes = driver.findElement(By.xpath("//h2[a[@name='menu_12']]"));
        System.out.println(" " + " " + textFishDishes.getText() + ":");
        WebElement listFishDishes = textFishDishes.findElement(By.xpath("./following-sibling::div[contains(@class, 'product')]"));

        List<WebElement> menuFishDishes = listFishDishes.findElements(By.xpath(".//div[@class='food-title']/p[@class='product-name']"));
        menuFishDishes.stream()
                .map(WebElement::getText)
                .forEach(System.out::println);
        System.out.println();

//Шашлыки
        WebElement Kebabs = driver.findElement(By.xpath("//a[@href='https://dostavka312.kg/garnirygpt/restoran-pishpek#menu_13']"));
        Kebabs.click();
        WebElement textKebabs = driver.findElement(By.xpath("//h2[a[@name='menu_13']]"));
        System.out.println(" " + " " + textKebabs.getText() + ":");
        WebElement listKebabs = textKebabs.findElement(By.xpath("./following-sibling::div[contains(@class, 'product')]"));

        List<WebElement> menuKebabs = listKebabs.findElements(By.xpath(".//div[@class='food-title']/p[@class='product-name']"));
        menuKebabs.stream()
                .map(WebElement::getText)
                .forEach(System.out::println);
        System.out.println();

// 	Блюда на компанию
        WebElement DishesForCompany = driver.findElement(By.xpath("//a[@href='https://dostavka312.kg/garnirygpt/restoran-pishpek#menu_14']"));
        DishesForCompany.click();
        WebElement textDishesForCompany = driver.findElement(By.xpath("//h2[a[@name='menu_14']]"));
        System.out.println(" " + " " + textDishesForCompany.getText() + ":");
        WebElement listDishesForCompany = textDishesForCompany.findElement(By.xpath("./following-sibling::div[contains(@class, 'product')]"));

        List<WebElement> menuDishesForCompany = listDishesForCompany.findElements(By.xpath(".//div[@class='food-title']/p[@class='product-name']"));
        menuDishesForCompany.stream()
                .map(WebElement::getText)
                .forEach(System.out::println);
        System.out.println();

//	Гарниры
        WebElement SideDishes = driver.findElement(By.xpath("//a[@href='https://dostavka312.kg/garnirygpt/restoran-pishpek#menu_15']"));
        SideDishes.click();
        WebElement textSideDishes = driver.findElement(By.xpath("//h2[a[@name='menu_15']]"));
        System.out.println(" " + " " + textSideDishes.getText() + ":");
        WebElement listSideDishes = textSideDishes.findElement(By.xpath("./following-sibling::div[contains(@class, 'product')]"));

        List<WebElement> menuSideDishes = listSideDishes.findElements(By.xpath(".//div[@class='food-title']/p[@class='product-name']"));
        menuSideDishes.stream()
                .map(WebElement::getText)
                .forEach(System.out::println);
        System.out.println();

//Соусы
        WebElement Sauces = driver.findElement(By.xpath("//a[@href='https://dostavka312.kg/garnirygpt/restoran-pishpek#menu_16']"));
        Sauces.click();
        WebElement textSauces = driver.findElement(By.xpath("//h2[a[@name='menu_16']]"));
        System.out.println(" " + " " + textSauces.getText() + ":");
        WebElement listSauces = textSauces.findElement(By.xpath("./following-sibling::div[contains(@class, 'product')]"));

        List<WebElement> menuSauces = listSauces.findElements(By.xpath(".//div[@class='food-title']/p[@class='product-name']"));
        menuSauces.stream()
                .map(WebElement::getText)
                .forEach(System.out::println);
        System.out.println();

// Пицца
        WebElement Pizza = driver.findElement(By.xpath("//a[@href='https://dostavka312.kg/garnirygpt/restoran-pishpek#menu_17']"));
        Pizza.click();
        WebElement textPizza = driver.findElement(By.xpath("//h2[a[@name='menu_17']]"));
        System.out.println(" " + " " + textPizza.getText() + ":");
        WebElement listPizza = textPizza.findElement(By.xpath("./following-sibling::div[contains(@class, 'product')]"));

        List<WebElement> menuPizza = listPizza.findElements(By.xpath(".//div[@class='food-title']/p[@class='product-name']"));
        menuPizza.stream()
                .map(WebElement::getText)
                .forEach(System.out::println);
        System.out.println();

// Десерты
        WebElement Dessert = driver.findElement(By.xpath("//a[@href='https://dostavka312.kg/garnirygpt/restoran-pishpek#menu_18']"));
        Dessert.click();
        WebElement textDessert = driver.findElement(By.xpath("//h2[a[@name='menu_18']]"));
        System.out.println(" " + " " + textDessert.getText() + ":");
        WebElement listDessert = textDessert.findElement(By.xpath("./following-sibling::div[contains(@class, 'product')]"));

        List<WebElement> menuDessert = listDessert.findElements(By.xpath(".//div[@class='food-title']/p[@class='product-name']"));
        menuDessert.stream()
                .map(WebElement::getText)
                .forEach(System.out::println);
        System.out.println();

//Роллы
        WebElement Rolls = driver.findElement(By.xpath("//a[@href='https://dostavka312.kg/garnirygpt/restoran-pishpek#menu_19']"));
        Rolls.click();
        WebElement textRolls = driver.findElement(By.xpath("//h2[a[@name='menu_19']]"));
        System.out.println(" " + " " + textRolls.getText() + ":");
        WebElement listRolls = textRolls.findElement(By.xpath("./following-sibling::div[contains(@class, 'product')]"));

        List<WebElement> menuRolls = listRolls.findElements(By.xpath(".//div[@class='food-title']/p[@class='product-name']"));
        menuRolls.stream()
                .map(WebElement::getText)
                .forEach(System.out::println);
        System.out.println();

// Горячие роллы
        WebElement HotRolls = driver.findElement(By.xpath("//a[@href='https://dostavka312.kg/garnirygpt/restoran-pishpek#menu_20']"));
        HotRolls.click();
        WebElement textHotRolls = driver.findElement(By.xpath("//h2[a[@name='menu_20']]"));
        System.out.println(" " + " " + textHotRolls.getText() + ":");
        WebElement listHotRolls = textHotRolls.findElement(By.xpath("./following-sibling::div[contains(@class, 'product')]"));

        List<WebElement> menuHotRolls = listHotRolls.findElements(By.xpath(".//div[@class='food-title']/p[@class='product-name']"));
        menuHotRolls.stream()
                .map(WebElement::getText)
                .forEach(System.out::println);
        System.out.println();

//	Классические роллы
        WebElement ClassicRolls = driver.findElement(By.xpath("//a[@href='https://dostavka312.kg/garnirygpt/restoran-pishpek#menu_21']"));
        ClassicRolls.click();
        WebElement textClassicRolls = driver.findElement(By.xpath("//h2[a[@name='menu_21']]"));
        System.out.println(" " + " " + textClassicRolls.getText() + ":");
        WebElement listClassicRolls = textClassicRolls.findElement(By.xpath("./following-sibling::div[contains(@class, 'product')]"));

        List<WebElement> menuClassicRolls = listClassicRolls.findElements(By.xpath(".//div[@class='food-title']/p[@class='product-name']"));
        menuClassicRolls.stream()
                .map(WebElement::getText)
                .forEach(System.out::println);
        System.out.println();

//	Ассорти из ролл
        WebElement AssortedRolls = driver.findElement(By.xpath("//a[@href='https://dostavka312.kg/garnirygpt/restoran-pishpek#menu_22']"));
        AssortedRolls.click();
        WebElement textAssortedRolls = driver.findElement(By.xpath("//h2[a[@name='menu_22']]"));
        System.out.println(" " + " " + textAssortedRolls.getText() + ":");
        WebElement listAssortedRolls = textAssortedRolls.findElement(By.xpath("./following-sibling::div[contains(@class, 'product')]"));

        List<WebElement> menuAssortedRolls = listAssortedRolls.findElements(By.xpath(".//div[@class='food-title']/p[@class='product-name']"));
        menuAssortedRolls.stream()
                .map(WebElement::getText)
                .forEach(System.out::println);
        System.out.println();

// 	Лимонады
        WebElement Lemonades = driver.findElement(By.xpath("//a[@href='https://dostavka312.kg/garnirygpt/restoran-pishpek#menu_23']"));
        Lemonades.click();
        WebElement textLemonades = driver.findElement(By.xpath("//h2[a[@name='menu_23']]"));
        System.out.println(" " + " " + textLemonades.getText() + ":");
        WebElement listLemonades = textLemonades.findElement(By.xpath("./following-sibling::div[contains(@class, 'product')]"));

        List<WebElement> menuLemonades = listLemonades.findElements(By.xpath(".//div[@class='food-title']/p[@class='product-name']"));
        menuLemonades.stream()
                .map(WebElement::getText)
                .forEach(System.out::println);
        System.out.println();

//Холодные напитки
        WebElement ColdВrinks = driver.findElement(By.xpath("//a[@href='https://dostavka312.kg/garnirygpt/restoran-pishpek#menu_24']"));
        ColdВrinks.click();
        WebElement textColdВrinks = driver.findElement(By.xpath("//h2[a[@name='menu_24']]"));
        System.out.println(" " + " " + textColdВrinks.getText() + ":");
        WebElement listColdВrinks = textColdВrinks.findElement(By.xpath("./following-sibling::div[contains(@class, 'product')]"));

        List<WebElement> menuColdВrinks = listColdВrinks.findElements(By.xpath(".//div[@class='food-title']/p[@class='product-name']"));
        menuColdВrinks.stream()
                .map(WebElement::getText)
                .forEach(System.out::println);
    }
}
