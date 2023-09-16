package com.romanovcopy;


import com.romanovcopy.classwork150923.adapter.*;
import com.romanovcopy.classwork150923.decoratorFactory.*;
import com.romanovcopy.classwork150923.observer.*;

public class Main {
    public static void main(String[] args) {
//        adapter();
//        decoratorFactory();
        observer();
    }


    private static void adapter() {
        // Есть библиотека сбора данных от датчиков. Все они были куплены в комплекте с этой библиотекой.
        // Поступил новый датчик от другой компании, интерфейс которого отличается от предыдущих.
        // Надо включить этот датчик в систему.
        MeteoStore meteoDb = new MeteoStore();

        MeteoSensor ms200_1 = new MS200(1);
        meteoDb.save(ms200_1);
        // Здесь надо вызвать метод getData у класса ST500Info. Полученные данные отправить в метод save объекта meteoDb
        meteoDb.save(new AdapterST500Info(new ST500Info().getData()));

    }
    private static void decoratorFactory() {

// Создать логирование операций, для класса Calculator. Класс Calculator не должен изменится.
        ICalculableFactory calculableFactory = new LogCalculableFactory(new ConsoleLogger());
        ViewCalculator view = new ViewCalculator(calculableFactory);
        view.run();
    }
    private static void observer() {
        // Добавить нового наблюдателя, например Specialist, который будет наблюдать за Company
        Publisher jobAgency = new JobAgency();
        Company google = new Company(jobAgency, "Google", 50);
        Company geekBrains = new Company(jobAgency, "GeekBrains", 100);
        Student petrov = new Student("Petrov");
        Master ivanov = new Master("Ivanov");
        Junior sidorov = new Junior("Sidorov");
        Povar peshkov = new Povar("Peshkov");
        jobAgency.registerObserver(petrov);
        jobAgency.registerObserver(ivanov);
        jobAgency.registerObserver(sidorov);
        jobAgency.registerObserver(peshkov);
        for (int i = 0; i < 2; i++) {
            google.needEmpoyee();
            geekBrains.needEmpoyee();
        }
    }
}