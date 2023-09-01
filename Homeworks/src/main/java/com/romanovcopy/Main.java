package com.romanovcopy;

import com.romanovcopy.hierarchy.*;
import com.romanovcopy.interfaces.Jumper;
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
                if(person.isAvailable()){
                    if(obstacle instanceof Jumper){
                        person.setAvailable (((Jumper)person).jump(((Wall)obstacle).getHeight()));
                    }else {

                    }
                }
            }
        }

    }
}