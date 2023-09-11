package com.romanovcopy.models;

import com.romanovcopy.base.Person;
import com.romanovcopy.interfaces.ContactModel;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

// Реализация модели
public class ContactModelImpl<T extends Person> implements ContactModel<T>, Serializable {
    private List<T> contacts;

    private Extension extension;

    public ContactModelImpl() {
        contacts = new ArrayList<>();
        extension=Extension.DAT;
    }

    @Override
    public Extension getExtension() {
        return this.extension;
    }

    @Override
    public void setExtension(Extension extension) {
        this.extension=extension;
    }

    @Override
    public void addContact(T contact) {
        contacts.add(contact);
    }

    @Override
    public void removeContact(T contact) {
        contacts.remove(contact);
    }

    @Override
    public List<T> getAllContacts() {
        return contacts;
    }
    @Override
    public void saveContacts(String fileName) {
        fileName=fileName+"."+extension;
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(fileName))) {
            outputStream.writeObject(contacts);
            System.out.println("Контакты успешно сохранены.");
        } catch (IOException e) {
            System.out.println("Ошибка при сохранении контактов: " + e.getMessage());
        }
    }
    @Override
    public void loadContacts(String fileName) {
        fileName=fileName+"."+extension;
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(fileName))) {
            contacts = (List<T>) inputStream.readObject();
            System.out.println("Контакты успешно загружены.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Ошибка при загрузке контактов: " + e.getMessage());
        }
    }

}