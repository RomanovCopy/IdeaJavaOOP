package com.romanovcopy.hierarchy;


import com.romanovcopy.interfaces.Runnable;
import com.romanovcopy.interfaces.Jumper;

public class HomoSapiens extends Live implements Runnable, Jumper{

    public HomoSapiens() {
        super();

    }

    @Override
    public boolean run(int distance) {
        return distance<=maximumDistance;
    }

    @Override
    public boolean jump(int height) {
        return height<=maximumHeight;
    }
}
