package org.example;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.text.SimpleDateFormat;


public class Main {
    public static void main(String[] args)  {
//        usersInput();
    }

    /**
     * ввод данных от пользователя
     */
    public static void usersInput(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите ФИО: ");
        String lastname = scanner.nextLine();
        inputStrValidation(lastname);
//        stringDelimeter(lastname);
        System.out.println("Введите дату рождения: ");
        String strDate = scanner.nextLine();
        inputStrValidation(strDate);
        isDateValid(strDate);
        System.out.println("Введите номер телефона: ");
        Integer phoneNumber = scanner.nextInt();
        inputIntValidation(phoneNumber);
        System.out.println("Введите пол: ");
        Character gender = scanner.next().charAt(0);
        rightGender(gender);
        createFileTxt(lastname,strDate,phoneNumber,gender);
    }

    public static void usersInputAL(){
        ArrayList<String> info = new ArrayList<>();

    }

    /**
     * проверка валидности даты
     * @param strDate дата
     * @return
     */
    public static String isDateValid(String strDate) {
        String info = "Ошибка ввода даты!";
        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
        format.setLenient(false);
            try{
                format.parse(strDate);
            } catch (Exception e) {
                throw new RuntimeException(info);
            }
            return info;
    }

    /**
     * проверка подлинности гендера
     * @param gender пол
     * @return
     */

    public static void rightGender(Character gender){
        if (gender == 'f' || gender == 'm'){

        } else
            System.out.println("Определитесь с полом");
    }

    /**
     * проверка получения всех строковых данных от пользователя
     */
    public static void inputStrValidation(String validation){
        if(validation == ""){
            throw new RuntimeException("Строка пустая ");
        }
    }

    /**
     * проверка получения целочисленных значений от пользователя
     * @param validation
     */
    public static void inputIntValidation(Integer validation){
        if(validation == null){
            throw new RuntimeException("Это не дата");
        }
    }

    /**
     * метод по разделению строки ФИО и выводу фамилии
     * @param FIO строка с ФИО
     */
    public static void stringDelimeter(String FIO){
        String [] subStr;  // массив строк, в котором записывается разделенная строка
        String delimetr = " ";  // условие при котром делится (пробел)
        subStr = FIO.split(delimetr);   // разделение строки
        String delStr = subStr[0];
        System.out.println(delStr);
    }

    /**
     * метод по заполенению файла с данными
     */
    public static void createFileTxt(String FIO,String birthday, Integer phone_number, Character gender)
            {
                String [] subStr;  // массив строк, в котором записывается разделенная строка
                String delimetr = " ";  // условие при котром делится (пробел)
                subStr = FIO.split(delimetr);   // разделение строки
                String delStr = subStr[0];
        try (FileWriter fileWriter =new FileWriter(delStr, true)){
            String file_name = FIO;
            fileWriter.append(FIO).append(" ");
            file_name = birthday;
            fileWriter.append(birthday).append(" ");
            Integer data_int = phone_number;
            fileWriter.append(Character.highSurrogate(phone_number)).append(" ");
            String data_char = String.valueOf(gender);
            fileWriter.append(gender);
            fileWriter.append('\n');
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException("Error!");
        }
    }
}