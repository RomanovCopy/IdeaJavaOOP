package com.romanovcopy.views;

import com.romanovcopy.base.Person;
import com.romanovcopy.interfaces.ContactView;

import java.util.List;

public class ContactViewImpl<T extends Person> implements ContactView<T> {

    @Override
    public void displayContacts(List<T> contacts) {
        for (T contact : contacts) {
            System.out.println(contact.getNick() + " - " + contact.getPhoneNumber());
        }
    }

    @Override
    public void displayErrorMessage(String message) {
        System.out.println("Ошибка: " + message);
    }

}
