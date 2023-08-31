package com.romanovcopy.hierarchy;

import com.romanovcopy.interfaces.Runnable;
import com.romanovcopy.interfaces.Jumper;
public class Robot extends Lifeless implements Jumper, Runnable {


    public Robot() {
        super();
    }

    @Override
    public boolean jump(int height) {
        return height<=maximumHeight;
    }

    @Override
    public boolean run(int distance) {
        return distance<=maximumDistance;
    }
}
