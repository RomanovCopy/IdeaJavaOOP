package com.romanovcopy;

import com.romanovcopy.hierarchy.*;
import com.romanovcopy.interfaces.Jumper;
import com.romanovcopy.interfaces.Runnable;
import com.romanovcopy.obstacles.*;

import java.util.ArrayList;
import java.util.Random;

public class Main {

    private static ArrayList<Creator>participants;
    private static ArrayList<Obstacle>sportsDisciplines;
    public static void main(String[] args) {

        Random random=new Random();

        /*
        создаем массив участников
        максимальные значения преодолеваемых препятствий
        задаются случайным образом
         */
        participants=new ArrayList<>();

        participants.add(new HomoSapiens("Human1"));
        participants.add(new HomoSapiens("Human2"));
        participants.add(new HomoSapiens("Human3"));

        participants.add(new Cat("Cat1"));
        participants.add(new Cat("Cat2"));
        participants.add(new Cat("Cat3"));

        participants.add(new Robot("Robot1"));
        participants.add(new Robot("Robot2"));
        participants.add(new Robot("Robot3"));

        System.out.println("Создан массив участников:");
        for(var person:participants){
            System.out.println(person.toString());
        }

        /*
        создаем массив препятствий
        высота и дистанция задаются случайным образом
         */

        sportsDisciplines=new ArrayList<>();

        for(int i=0;i<6;i++){
            sportsDisciplines.add(new Treadmill(random.nextInt(10000)));
            sportsDisciplines.add(new Wall(random.nextInt(210)));
        }

        System.out.println("Создан массив препятствий:");
        for(var obstacle:sportsDisciplines){
            System.out.println(obstacle.toString());
        }

        /*
        Прохождение препятствий
         */

        for(var obstacle:sportsDisciplines){
            System.out.println(obstacle.toString());
            for(var person:participants){
                if (person.isAvailable()) {
                    if (obstacle instanceof Jumper && person instanceof Jumper) {
                        person.setAvailable(((Jumper) person).jump(((Wall) obstacle).getHeight()));
                    } else if (obstacle instanceof Treadmill && person instanceof Runnable) {
                        person.setAvailable(((Runnable) person).run(((Treadmill) obstacle).getLength()));
                    }
                    if (!person.isAvailable()) {
                        System.out.println("Выбыл из борьбы: " + person);
                    }
                }
            }
        }
        System.out.println("Дистанцию прошли : ");
        for(var person:participants){
            if(person.isAvailable()){
                System.out.println(person.toString());
            }
        }

    }
}