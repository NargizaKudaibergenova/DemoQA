package com.demoqa.pages;

import com.demoqa.drivers.DriverManager;
import com.demoqa.entities.EmployeeEntity;
import com.demoqa.utils.RandomUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.*;

public class WebTablePage extends BasePage {

    @FindBy(id = "addNewRecordButton")
    public WebElement addNewBtn;

    @FindBy(id = "firstName")
    public WebElement firstNameInput;

    @FindBy(id = "lastName")
    public WebElement lastNameInput;

    @FindBy(id = "age")
    public WebElement ageInput;

    @FindBy(id = "userEmail")
    public WebElement emailInput;

    @FindBy(id = "salary")
    public WebElement salaryInput;

    @FindBy(id = "department")
    public WebElement departmentInput;

    @FindBy(id = "submit")
    public WebElement submitBtn;


    private int index;

    public ArrayList<String> emails = new ArrayList<>();

    // добавляем сотрудника проверяя на наличие дубликата email
    @Step("Add new Employee {0}")
    public WebTablePage addNewEmployee(EmployeeEntity employee) throws Exception {
        webElementActions.click(addNewBtn)
                .sendKeys(firstNameInput, employee.getFirstName())
                .sendKeys(lastNameInput, employee.getLastName())
                .sendKeys(emailInput, employee.getEmail())
                .sendKeys(ageInput, String.valueOf(employee.getAge()))
                .sendKeys(salaryInput, String.valueOf(employee.getSalary()))
                .sendKeys(departmentInput, employee.getDepartment());
        if (emails.contains(employee.getEmail())) {
            throw new Exception("Имеется дубликат c таким email");
        } else {
            webElementActions.click(submitBtn);
        }
        return this;
    }

    // получаем список сотрудников
    public ArrayList<EmployeeEntity> getEmployeesFromTable() {
        //Находим все строки таблицы на веб-странице.
        List<WebElement> rows = DriverManager.getDriver().findElements(
                By.cssSelector(".ReactTable .rt-tr-group"));

        ArrayList<EmployeeEntity> employees = new ArrayList<>();
        for (WebElement row : rows) {
            List<WebElement> cells = row.findElements(By.cssSelector(".rt-td"));
            String firstName = cells.get(0).getText();
            String lastName = cells.get(1).getText();
            String ageText = cells.get(2).getText().replaceAll("[^0-9]", "");
            String email = cells.get(3).getText();
            String salaryText = cells.get(4).getText().replaceAll("[^0-9]", "");
            String department = cells.get(5).getText();

            if (firstName.isEmpty() || lastName.isEmpty() || ageText.isEmpty() || email.isEmpty() || salaryText.isEmpty() || department.isEmpty()) {
                continue;
            }

            //за парсили с int в Integer и с long в Long
            int age = Integer.parseInt(ageText.trim());
            long salary = Long.parseLong(salaryText.trim());

            employees.add(new EmployeeEntity(firstName, lastName, age, email, salary, department));
        }
        return employees;
    }

    //Метод, который извлекает список сотрудников и отдельно email
    public ArrayList<EmployeeEntity> getEmployeesAndEmailFromTable() {
        //Находим все строки таблицы на веб-странице.
        List<WebElement> rows = DriverManager.getDriver().findElements(
                By.cssSelector(".ReactTable .rt-tr-group"));
        // Создаем список для хранения email адресов
        ArrayList<EmployeeEntity> employees = new ArrayList<>();
        //Проходим по каждой строке таблицы
        for (WebElement row : rows) {
            // Находим все ячейки в текущей строке
            List<WebElement> cells = row.findElements(By.cssSelector(".rt-td"));
            String firstName = cells.get(0).getText();
            String lastName = cells.get(1).getText();
            String ageText = cells.get(2).getText().replaceAll("[^0-9]", "");
            String email = cells.get(3).getText();
            String salaryText = cells.get(4).getText().replaceAll("[^0-9]", "");
            String department = cells.get(5).getText();

            if (firstName.isEmpty() || lastName.isEmpty() || ageText.isEmpty() || email.isEmpty() || salaryText.isEmpty() || department.isEmpty()) {
                continue;
            }
            int age = Integer.parseInt(ageText.trim());
            long salary = Long.parseLong(salaryText.trim());

            // Проверяем на уникальность перед добавлением
            if (!emails.contains(email)) {
                emails.add(email);
            }
            employees.add(new EmployeeEntity(firstName, lastName, age, email, salary, department));
        }
        return employees;
    }

    // Удаление из списка. Рандомно выбирает email, по выбранному email сформирует xPath
    // нужной кнопки удаления и нажимает
    public void removeFromList() {
        if (emails.isEmpty()) {
            System.out.println("Список email адресов пуст");
            return;
        }
        Random random = new Random();
        int index = random.nextInt(emails.size());
        String email = emails.get(index);
        System.out.println("Выбранный индекс: " + " " + index + ", " + "Email: " + email);

        for (int i = 0; i < emails.size(); i++) {
            if (emails.get(i).equals(email)) {
                String xpath = String.format("//*[@id='delete-record-%d']", i + 1);
                System.out.println("Сформированный XPath: " + xpath);
                try {
                    WebElement deleteBtn = DriverManager.getDriver().findElement(By.xpath(xpath));
                    webElementActions.jsClick(deleteBtn);
                    System.out.println("Элемент удалён: " + email);
                    // Удаляем email из списка после успешного удаления элемента
                    emails.remove(email);
                } catch (NoSuchElementException e) {
                    System.out.println("Элемент не найден для удаления: " + email);
                }
                break;
            }
        }
    }


    // метод редактирования email адреса сотрудника в таблице рандомно
    public void editRandomFields() {
        // Получаем список сотрудников
        List<EmployeeEntity> employees = getEmployeesAndEmailFromTable();
        if (employees.isEmpty()) {
            System.out.println("Список сотрудников пуст");
            return;
        }
        // Рандомно выбираем сотрудника из списка
        Random random = new Random();
        index = random.nextInt(employees.size());
        EmployeeEntity randomEmployee = employees.get(index);
        System.out.println("Выбранный сотрудник для редактирования: " + randomEmployee);

        // Рандомно выбираем количество полей для редактирования (от 1 до 6 полей)
        int fieldsToEdit = random.nextInt(6) + 1;

        // Создаем новый объект Employee с новыми значениями полей
        EmployeeEntity newValues = RandomUtils.createMockEmployee();

        Set<Integer> getIndex = new HashSet<>();

        // Открываем форму редактирования сотрудника
        String xpath = String.format("//*[@id='edit-record-%d']", index + 1);

        WebElement editButton = DriverManager.getDriver().findElement(By.xpath(xpath));
        webElementActions.jsClick(editButton);

        for (int i = 0; i < fieldsToEdit; i++) {
// Генерируем случайное поле для редактирования, которое еще не было выбрано
            int fieldIndex = random.nextInt(6);
            while (getIndex.contains(fieldIndex)) {
                fieldIndex = random.nextInt(6);
            }
            getIndex.add(fieldIndex);
            System.out.println("Индекс выбранного поля: " + fieldIndex); // Возможные индексы: 0 - firstName, 1 - lastName, 2 - age, 3 - email, 4 - salary, 5 - department

            String fieldName = "";

            switch (fieldName) {
                case "firstName":
                    webElementActions.clearAndSendKeys(firstNameInput, newValues.getFirstName());
                    randomEmployee.setFirstName(newValues.getFirstName());
                    break;
                case "lastName":
                    webElementActions.clearAndSendKeys(lastNameInput, newValues.getLastName());
                    randomEmployee.setLastName(newValues.getLastName());
                    break;
                case "age":
                    webElementActions.clearAndSendKeys(ageInput, String.valueOf(newValues.getAge()));
                    randomEmployee.setAge(newValues.getAge());
                    break;
                case "email":
                    webElementActions.clearAndSendKeys(emailInput, newValues.getEmail());
                    randomEmployee.setEmail(newValues.getEmail());
                    break;
                case "salary":
                    webElementActions.clearAndSendKeys(salaryInput, String.valueOf(newValues.getSalary()));
                    randomEmployee.setSalary(newValues.getSalary());
                    break;
                case "department":
                    webElementActions.clearAndSendKeys(departmentInput, newValues.getDepartment());
                    randomEmployee.setDepartment(newValues.getDepartment());
                    break;
                default:
                    System.out.println("Неверный индекс поля");
                    return;
            }
            System.out.println("Обновленое поле " + fieldName + " " + "для сотрудника: "
                    + randomEmployee.getFirstName() + " " + randomEmployee.getLastName());
        }

        webElementActions.jsClick(submitBtn);
    }
}

