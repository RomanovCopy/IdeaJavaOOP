package com.romanovcopy.models;

import com.romanovcopy.base.Person;

import java.io.Serializable;

public class Contact extends Person implements Serializable {
    public Contact(String name, String phoneNumber) {
        super(name, phoneNumber);
    }

    @Override
    public String toString() {
        return "Contact{" +
                "name='" + getNick() + '\'' +
                ", phoneNumber='" + getPhoneNumber() + '\'' +
                '}';
    }
}