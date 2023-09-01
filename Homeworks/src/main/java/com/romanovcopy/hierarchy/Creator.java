package com.romanovcopy.hierarchy;

import java.util.Random;

// Базовый класс Creator
public class Creator {

    protected Random random;
    protected int maximumDistance;
    protected int maximumHeight;


    protected boolean isAvailable;

    public Creator(){
        random=new Random();
        this.maximumDistance = random.nextInt(1000,10000);
        this.maximumHeight = random.nextInt(50,210);
        isAvailable=true;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

}
