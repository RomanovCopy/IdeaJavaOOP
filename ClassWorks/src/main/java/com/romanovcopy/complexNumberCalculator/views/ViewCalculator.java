package com.romanovcopy.complexNumberCalculator.views;

import com.romanovcopy.complexNumberCalculator.interfaces.IViewCalculator;

import java.util.Scanner;

/**
 * Отвечает за отображение данных пользователю. Предоставляет пользовательский
 * интерфейс, с помощью которого он может взаимодействовать с приложением.
 * Получает данные от модели и отображает их в удобном для пользователя формате.
 */
public class ViewCalculator implements IViewCalculator {

    private Scanner scanner;

    public ViewCalculator() {
        scanner=new Scanner(System.in);
    }

    @Override
    public String inputString(String message) {
        String input = "";
        scanner.nextLine();
        if (message != null && message.length() > 0) {
            System.out.println(message);
        }
        if (scanner.hasNextLine()) {
            input = scanner.nextLine();
        }
        return input;
    }

    @Override
    public Double inputDouble(String message) {
        double input = 0;
        if (message != null && message.length() > 0) {
            System.out.println(message);
        }
        if (scanner.hasNextDouble()) {
            input = scanner.nextDouble();
        }
//        scanner.nextLine();
        return input;
    }
    @Override
    public void message(String message){
        System.out.println(message);
    }
    @Override
    public void errorMessage(String errorMessge){
        System.out.println(errorMessge);
    }
    @Override
    public void close() {
        if (scanner != null) {
            scanner.close();
        }
        message("Программа успешно завершена.");
    }
}
