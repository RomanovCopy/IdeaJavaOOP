package com.romanovcopy;


import com.romanovcopy.classwork150923.adapter.*;
import com.romanovcopy.classwork150923.factory.*;

public class Main {
    public static void main(String[] args) {
//        adapter();
        factory();
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

        private static void factory(){

        }
}