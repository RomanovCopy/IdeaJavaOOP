package com.romanovcopy.classwork150923.observer;

public class Povar implements Observer {
    private String name;

    public Povar(String name) {
        this.name = name;
    }

    @Override
    public void receiveOffer(String nameCompany, int salary) {
        System.out.println(String.format("Povar %s: I am waiting for the better job! (company, salary) = %s, %d , " +
                "i not programmer", name, nameCompany, salary));
    }
}