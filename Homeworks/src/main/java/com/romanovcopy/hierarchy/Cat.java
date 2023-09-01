package com.romanovcopy.hierarchy;

import com.romanovcopy.interfaces.Runnable;
import com.romanovcopy.interfaces.Jumper;


public class Cat extends Live implements Runnable, Jumper {

    private String name;



    public Cat( String name ) {
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
        return "Cat{" +
                "name='" + name + '\'' +
                ", maximumDistance=" + maximumDistance + " m."+
                ", maximumHeight=" + maximumHeight + " sm."+
                '}';
    }
}
