package com.romanovcopy.interfaces;

import com.romanovcopy.base.Person;
import com.romanovcopy.models.Extension;

import java.util.List;

public interface ContactView<T extends Person> {
    void displayContacts(List<T> contacts);
    void displayExtension(Extension extension);
    void displayErrorMessage(String message);
}
