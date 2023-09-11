package com.romanovcopy.controllers;

import com.romanovcopy.base.Person;
import com.romanovcopy.interfaces.ContactController;
import com.romanovcopy.interfaces.ContactModel;
import com.romanovcopy.interfaces.ContactView;

import java.util.List;

public class ContactControllerImpl<T extends Person> implements ContactController<T> {
    private ContactModel<T> model;
    private ContactView<T> view;

    public ContactControllerImpl(ContactModel<T> model, ContactView<T> view) {
        this.model = model;
        this.view = view;
    }

    @Override
    public void addContact(T contact) {
        model.addContact(contact);
    }

    @Override
    public void removeContact(T contact) {
        model.removeContact(contact);
    }

    @Override
    public void getAllContacts() {
        List<T> contacts = model.getAllContacts();
        view.displayContacts(contacts);
    }

}