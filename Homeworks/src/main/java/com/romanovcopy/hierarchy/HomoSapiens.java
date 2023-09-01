package com.romanovcopy.hierarchy;


import com.romanovcopy.interfaces.Runnable;
import com.romanovcopy.interfaces.Jumper;

public class HomoSapiens extends Live implements Runnable, Jumper{


    private String name;


    public HomoSapiens(String name) {
        super();
        this.name=name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean run(int distance) {
        return distance<=maximumDistance;
    }

    @Override
    public boolean jump(int height) {
        return height<=maximumHeight;
    }
    @Override
    public String toString() {
        return "HomoSapiens{" +
                "name='" + name + '\'' +
                ", maximumDistance=" + maximumDistance + " m."+
                ", maximumHeight=" + maximumHeight + " sm."+
                '}';
    }
}
