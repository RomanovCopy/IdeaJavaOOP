package com.romanovcopy.interfaces;

import com.romanovcopy.base.Person;

import java.util.List;

public interface ContactView<T extends Person> {
    void displayContacts(List<T> contacts);
    void displayErrorMessage(String message);
}
