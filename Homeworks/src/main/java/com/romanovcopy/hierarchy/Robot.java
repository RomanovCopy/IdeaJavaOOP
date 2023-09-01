package com.romanovcopy.hierarchy;

import com.romanovcopy.interfaces.Runnable;
import com.romanovcopy.interfaces.Jumper;
public class Robot extends Lifeless implements Jumper, Runnable {

    private String name;


    public Robot(String name ) {
        super();
        this.name=name;
    }

    public String getName() {
        return name;
    }
    @Override
    public boolean jump(int height) {
        return height<=maximumHeight;
    }

    @Override
    public boolean run(int distance) {
        return distance<=maximumDistance;
    }
    @Override
    public String toString() {
        return "Robot{" +
                "name='" + name + '\'' +
                ", maximumDistance=" + maximumDistance + " m."+
                ", maximumHeight=" + maximumHeight + " sm."+
                '}';
    }
}
