package com.romanovcopy.models;

import com.romanovcopy.base.Person;

import java.io.Serializable;

/**
 * Данный класс Contact удовлетворяет принципу единственной ответственности (SRP).
 * Он отвечает только за представление контактной информации и несет ответственность
 * только за хранение имени и номера телефона. Класс не занимается другими функциями,
 * такими как обработка данных или взаимодействие с базой данных.
 * Это позволяет классу быть более гибким и легко поддерживаемым.
 */

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