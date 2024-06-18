package com.demoqa.utils;

import com.demoqa.entities.EmployeeEntity;
import com.demoqa.entities.PracticeFormEntity;
import com.demoqa.entities.TextBoxEntity;
import com.github.javafaker.Faker;

public class RandomUtils {

    static Faker faker = new Faker();

    public TextBoxEntity generateRandomTextBoxEntity() {
        TextBoxEntity textBoxEntity = new TextBoxEntity();
        textBoxEntity.setFullName(faker.name().fullName());
        textBoxEntity.setEmail(faker.internet().emailAddress());
        textBoxEntity.setCurrentAddress(faker.address().fullAddress());
        textBoxEntity.setPermanentAddress(faker.address().secondaryAddress());
        return textBoxEntity;
    }

    public PracticeFormEntity generateRandomPracticeFormEntity() {
        PracticeFormEntity practiceFormEntity = new PracticeFormEntity();
        practiceFormEntity.setFirstName(faker.name().firstName());
        practiceFormEntity.setLastName(faker.name().lastName());
        practiceFormEntity.setEmail(faker.internet().emailAddress());
        practiceFormEntity.setMobileNumber(faker.phoneNumber().subscriberNumber(10));
        practiceFormEntity.setSubjects("Biology");
        practiceFormEntity.setPicture("C:\\Users\\Home\\Desktop\\QA.jpg");
        practiceFormEntity.setCurrentAddress(faker.address().fullAddress());
        practiceFormEntity.setState("NCR");
        practiceFormEntity.setCity("Delhi");
        return practiceFormEntity;
    }

    //добавление новых сотрудников
    public static EmployeeEntity createMockEmployee() {
        EmployeeEntity employee = new EmployeeEntity();
        employee.setFirstName(faker.name().firstName());
        employee.setLastName(faker.name().lastName());
        employee.setEmail(faker.internet().emailAddress());
        employee.setAge(faker.number().numberBetween(18, 100));
        employee.setSalary(faker.number().numberBetween(100000L, 200000L));
        employee.setDepartment(faker.job().position());

        return employee;
    }

}
