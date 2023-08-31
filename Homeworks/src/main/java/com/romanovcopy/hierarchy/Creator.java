package com.romanovcopy.hierarchy;

import java.util.Random;

// Базовый класс Creator
class Creator {

    protected Random random;
    protected int maximumDistance;
    protected int maximumHeight;

    public Creator(){
        random=new Random();
        this.maximumDistance = random.nextInt(5001);
        this.maximumHeight = random.nextInt(3);
    }


}
