package com.romanovcopy.interfaces;

import com.romanovcopy.base.Person;
import com.romanovcopy.models.Extension;

public interface ContactController<T extends Person> {

    Extension getExtension();
    void setExtension(Extension extension);
    void addContact(T contact);
    void removeContact(T contact);
    void getAllContacts();
    void saveContacts(String fileName);
    void loadContacts(String fileName);
}
