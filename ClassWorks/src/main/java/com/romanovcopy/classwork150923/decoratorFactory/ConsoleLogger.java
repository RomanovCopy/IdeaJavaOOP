package com.romanovcopy.classwork150923.decoratorFactory;

public class ConsoleLogger implements Logable {
    @Override
    public void log(String message) {
        System.out.println(" LOG :  " + message);
    }
}
