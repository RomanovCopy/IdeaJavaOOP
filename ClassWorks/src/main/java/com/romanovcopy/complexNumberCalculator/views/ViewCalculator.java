package com.romanovcopy.complexNumberCalculator.views;

import java.util.Scanner;

public class ViewCalculator {

    private Scanner scanner;

    public ViewCalculator() {
        scanner=new Scanner(System.in);
    }


    /**
     * прием ввода строки от пользователя
     * @param message сообщение пользователю
     * @return сообщение пользователя
     */
    public String inputString(String message) {
        String input = "";
        if (message != null && message.length() > 0) {
            System.out.println(message);
        }
        if (scanner.hasNextLine()) {
            input = scanner.nextLine();
        }
        scanner.nextLine();
        return input;
    }

    /**
     * прием ввода числа от пользователя
     * @param message сообщение пользователю
     * @return число пользователя
     */
    public Double inputDouble(String message) {
        double input = 0;
        if (message != null && message.length() > 0) {
            System.out.println(message);
        }
        if (scanner.hasNextDouble()) {
            input = scanner.nextDouble();
        }
        scanner.nextLine();
        return input;
    }

    /**
     * сообщение пользователю без ввода
     * @param message сообщение
     */
    public void message(String message){
        System.out.println(message);
    }

    /**
     * сообщение пользователю об ошибке без ввода
     * @param errorMessge сообщение об ошибке
     */
    public void errorMessage(String errorMessge){
        System.out.println(errorMessge);
    }

}
