package com.romanovcopy.complexNumberCalculator.controllers;

import com.romanovcopy.complexNumberCalculator.models.ModelCalculator;

import java.util.Scanner;

/**
 * данный класс обрабатывает пользовательский ввод, вызывает соответствующие методы
 * модели ( type: ModelCalculator ) для обработки данных и обновления состояния.
 */
public class ControllerCalculator {
    private ModelCalculator modelCalculator;
    private Scanner scanner;

    public ControllerCalculator() {
        scanner=new Scanner(System.in);
        modelCalculator = new ModelCalculator();
        boolean exit=false;
        while (!exit) {
            modelCalculator.setFirstNumber();
            modelCalculator.setOperation();
            modelCalculator.setSecondNumber();
            modelCalculator.printResult(modelCalculator.operationExecute());
            modelCalculator.printMessage(" 0 - выход из программы.\n 1 - продолжить ");
            if(scanner.hasNextInt()){
                exit=scanner.nextInt()==0;
            }
        }
        if(scanner!=null){
            scanner.close();
        }
        modelCalculator.close();
    }
}
