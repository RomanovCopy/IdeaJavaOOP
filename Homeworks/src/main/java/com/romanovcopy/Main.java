package com.romanovcopy;


import com.romanovcopy.models.Contact;
import com.romanovcopy.models.ContactModelImpl;
import com.romanovcopy.models.Extension;

import java.util.List;

public class Main {


    public static void main(String[] args) {

        //создание контактов
        ContactModelImpl<Contact> model = new ContactModelImpl<>();
        model.addContact(new Contact("John", "123456789"));
        model.addContact(new Contact("Jane", "987654321"));

        //установка расширения для загрузки и сохранения контактов
        model.setExtension(Extension.BIN);
        System.out.println("Extension : " + model.getExtension());

        model.setExtension(Extension.DAT);
        System.out.println("Extension : " + model.getExtension());

        // Сохранение контактов на диск с заданным расширением
        model.saveContacts("contacts");

        // Загрузка контактов с диска с заданным расширением
        model.loadContacts("contacts");

        // Получение всех контактов
        List<Contact> contacts = model.getAllContacts();
    }

}