package com.demoqa.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    private static Properties properties;

    //приватный конструктор,который запрещает на создание обьекта
    private ConfigReader(){
        //Singleton pattern(Одиночка)
    }

   //статичный блок
    static {
        //исключение если файл не найдется
        try {
            String path = "src/main/resources/app.properties"; //в String положили путь к файлу
            FileInputStream fileInputStream = new FileInputStream(path);//открываем поток
            properties = new Properties();
            properties.load(fileInputStream);//загрузить все с fileInputStream
            fileInputStream.close(); //закрыть поток

        } catch (FileNotFoundException e) { //файл не найден
            throw new RuntimeException(e); //Исключение в процессе выполнения
        } catch (IOException e) {  //Input --> Output
            throw new RuntimeException(e);
        }
   }

   public static String getValue(String key){
        return properties.getProperty(key).trim();
   }

   public static void main(String[] args){
       System.out.println(getValue("browser"));
       System.out.println(getValue("userName"));
       System.out.println(getValue("password"));
   }
}
