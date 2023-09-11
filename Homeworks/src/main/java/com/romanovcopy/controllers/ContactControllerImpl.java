package com.romanovcopy.controllers;

import com.romanovcopy.base.Person;
import com.romanovcopy.interfaces.ContactController;
import com.romanovcopy.interfaces.ContactModel;
import com.romanovcopy.interfaces.ContactView;
import com.romanovcopy.models.ContactModelImpl;
import com.romanovcopy.models.Extension;
import com.romanovcopy.views.ContactViewImpl;

import java.util.List;

public class ContactControllerImpl<T extends Person> implements ContactController<T> {
    private ContactModelImpl<T> model;

    public ContactControllerImpl( ) {
        super();
        this.model = new ContactModelImpl<>();
    }


    @Override
    public void setExtension(Extension extension){
        model.setExtension(extension);
    }
    @Override
    public void getExtension(){
        model.getExtension();
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
        model.getAllContacts();
    }

    @Override
    public void saveContacts(String fileName) {
        model.saveContacts(fileName);
    }

    @Override
    public void loadContacts(String fileName) {
        model.loadContacts(fileName);
    }

}