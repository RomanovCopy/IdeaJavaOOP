package com.romanovcopy;

import com.romanovcopy.hierarchy.*;

public class Main {

    public static void main(String[] args) {

        // Создание объектов и вызов методов
        HomoSapiens human = new HomoSapiens();
        boolean a = human.run(500);
        a = human.jump(1);

        Cat cat = new Cat();
        a = cat.run(2000);
        a = cat.jump(2);

        Robot robot = new Robot();
        a = robot.run(3000);
        a = robot.jump(1);

    }
}