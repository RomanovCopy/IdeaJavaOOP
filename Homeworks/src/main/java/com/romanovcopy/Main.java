package com.romanovcopy;


import com.romanovcopy.controllers.ContactControllerImpl;
import com.romanovcopy.interfaces.ContactController;
import com.romanovcopy.models.Contact;
import com.romanovcopy.models.ContactModelImpl;
import com.romanovcopy.models.Extension;

import java.util.List;

public class Main {


    public static void main(String[] args) {

        //создание контактов
        ContactControllerImpl<Contact>controlller=new ContactControllerImpl<>();
        controlller.addContact(new Contact("John","13243647"));
        controlller.addContact(new Contact("Jane","644859487"));
//        ContactModelImpl<Contact> model = new ContactModelImpl<>();
//        model.addContact(new Contact("John", "123456789"));
//        model.addContact(new Contact("Jane", "987654321"));

        //установка расширения для загрузки и сохранения контактов
        controlller.setExtension(Extension.BIN);
        System.out.println("Extension : " + controlller.getExtension());

        controlller.setExtension(Extension.DAT);
        System.out.println("Extension : " + controlller.getExtension());

        // Сохранение контактов на диск с заданным расширением
        controlller.saveContacts("contacts");

        // Загрузка контактов с диска с заданным расширением
        controlller.loadContacts("contacts");

        // Получение всех контактов
        controlller.getAllContacts();

        }
    }
