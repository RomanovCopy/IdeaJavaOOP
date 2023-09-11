package com.romanovcopy.interfaces;

import com.romanovcopy.base.Person;
import com.romanovcopy.models.Extension;

import java.util.List;

public interface ContactModel<T extends Person> {

    Extension getExtension();
    void setExtension(Extension extension);
    void addContact(T contact);
    void removeContact(T contact);
    void saveContacts(String fileName);
    void loadContacts(String fileName);
    List<T> getAllContacts();
}
