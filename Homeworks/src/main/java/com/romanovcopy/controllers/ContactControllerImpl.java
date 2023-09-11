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
    private ContactViewImpl<T> view;

    public ContactControllerImpl( ) {
        super();
        this.model = new ContactModelImpl<>();
        this.view = new ContactViewImpl<>();
    }


    @Override
    public void setExtension(Extension extension){
        model.setExtension(extension);
    }
    @Override
    public Extension getExtension(){
        return model.getExtension();
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
        view.displayContacts(model.getAllContacts());
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