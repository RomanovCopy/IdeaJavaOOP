package com.romanovcopy.interfaces;

import com.romanovcopy.base.Person;

public interface ContactController<T extends Person> {
    void addContact(T contact);
    void removeContact(T contact);
    void getAllContacts();
}
