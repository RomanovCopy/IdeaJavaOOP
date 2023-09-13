package com.romanovcopy.controllers;

import com.romanovcopy.base.Person;
import com.romanovcopy.interfaces.ContactController;
import com.romanovcopy.interfaces.ContactModel;
import com.romanovcopy.interfaces.ContactView;
import com.romanovcopy.models.ContactModelImpl;
import com.romanovcopy.models.Extension;
import com.romanovcopy.views.ContactViewImpl;

import java.util.List;

/**
 * Данный класс удовлетворяет нескольким принципам SOLID:
 *Принцип единственной ответственности (SRP):
 *            Отвечает только за управление контактами и делегирует операции с
 *            контактами объекту ContactModelImpl.
 *            Не содержит логики, связанной с другими аспектами системы, что
 *            соответствует принципу SRP.
 * Принцип открытости/закрытости (OCP):
 *            Расширяет функциональность интерфейса ContactController<T>,
 *            позволяя работать с контактами любого типа, который наследуется от Person.
 *            Это позволяет расширять функциональность класса, добавляя новые типы контактов,
 *            без изменения самого класса ContactControllerImpl.
 * Принцип подстановки Барбары Лисков (LSP):
 *            Не является базовым классом, поэтому данный принцип не применяется.
 * Принцип инверсии зависимостей (DIP):
 *            Зависит от абстракции ContactController<T>, а не от конкретной реализации.
 *            Это позволяет легко заменять реализацию ContactController<T> без изменения кода класса
 *            ContactControllerImpl.
 * Принцип разделения интерфейса (ISP):
 *            Реализует только те методы, которые необходимы для управления контактами.
 *            Он не зависит от методов, которые не используются в его контексте, что соответствует принципу ISP.
 */

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