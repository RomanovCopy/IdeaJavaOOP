package com.romanovcopy;


//import com.romanovcopy.classwork150923.adapter.*;
//import com.romanovcopy.classwork150923.decoratorFactory.*;
//import com.romanovcopy.classwork150923.observer.*;
import com.romanovcopy.complexNumberCalculator.calculator.ComplexNumberFactory;
import com.romanovcopy.complexNumberCalculator.interfaces.IComplexNumber;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        adapter();
//        decoratorFactory();
//        observer();
        complexCalculator();
    }


//    private static void adapter() {
//        // Есть библиотека сбора данных от датчиков. Все они были куплены в комплекте с этой библиотекой.
//        // Поступил новый датчик от другой компании, интерфейс которого отличается от предыдущих.
//        // Надо включить этот датчик в систему.
//        MeteoStore meteoDb = new MeteoStore();
//
//        MeteoSensor ms200_1 = new MS200(1);
//        meteoDb.save(ms200_1);
//        // Здесь надо вызвать метод getData у класса ST500Info. Полученные данные отправить в метод save объекта meteoDb
//        meteoDb.save(new AdapterST500Info(new ST500Info().getData()));
//
//    }
//    private static void decoratorFactory() {
//
//// Создать логирование операций, для класса Calculator. Класс Calculator не должен изменится.
//        ICalculableFactory calculableFactory = new LogCalculableFactory(new ConsoleLogger());
//        ViewCalculator view = new ViewCalculator(calculableFactory);
//        view.run();
//    }
//    private static void observer() {
//        // Добавить нового наблюдателя, например Specialist, который будет наблюдать за Company
//        Publisher jobAgency = new JobAgency();
//        Company google = new Company(jobAgency, "Google", 50);
//        Company geekBrains = new Company(jobAgency, "GeekBrains", 100);
//        Student petrov = new Student("Petrov");
//        Master ivanov = new Master("Ivanov");
//        Junior sidorov = new Junior("Sidorov");
//        Povar peshkov = new Povar("Peshkov");
//        jobAgency.registerObserver(petrov);
//        jobAgency.registerObserver(ivanov);
//        jobAgency.registerObserver(sidorov);
//        jobAgency.registerObserver(peshkov);
//        for (int i = 0; i < 2; i++) {
//            google.needEmpoyee();
//            geekBrains.needEmpoyee();
//        }
//    }

    private static void complexCalculator(){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите действительную часть первого комплексного числа: ");
        double real1 = scanner.nextDouble();
        System.out.print("Введите мнимую часть первого комплексного числа: ");
        double imaginary1 = scanner.nextDouble();
        IComplexNumber complex1 = (IComplexNumber) ComplexNumberFactory.createComplexNumber(real1,
                imaginary1);

        System.out.print("Введите действительную часть второго комплексного числа: ");
        double real2 = scanner.nextDouble();
        System.out.print("Введите мнимую часть второго комплексного числа: ");
        double imaginary2 = scanner.nextDouble();
        IComplexNumber complex2 = ComplexNumberFactory.createComplexNumber(real2,
                imaginary2);

        IComplexNumber sum = complex1.add(complex2);
        IComplexNumber difference = complex1.subtract(complex2);
        IComplexNumber product = complex1.multiply(complex2);
        IComplexNumber quotient = complex1.divide(complex2);

        System.out.println("Сумма: " + sum);
        System.out.println("Разность: " + difference);
        System.out.println("Произведение: " + product);
        System.out.println("Частное: " + quotient);

        scanner.close();
    }
}