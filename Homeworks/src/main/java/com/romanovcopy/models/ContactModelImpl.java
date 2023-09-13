package com.romanovcopy.models;

import com.romanovcopy.base.Person;
import com.romanovcopy.interfaces.ContactModel;
import com.romanovcopy.views.ContactViewImpl;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Данный класс удовлетворяет принципам SOLID, а именно:
 *                    Принцип единственной ответственности (SRP):
 *                    Отвечает только за управление контактами и сохранение/загрузку
 *                    контактов в файлы.
 *                    Он не занимается другими задачами, что соответствует SRP.
 * Принцип открытости/закрытости ( OCP):
 *                    Позволяет расширять функциональность через использование
 *                    интерфейса ContactModel и реализацию методов. Новые типы контактов
 *                    могут быть добавлены, не изменяя существующий код.
 * Принцип подстановки Барбары Лисков ( LSP):
 *                    Расширяет интерфейс ContactModel и сохраняет контакты, которые являются
 *                    подтипами класса Person. Это соответствует LSP, так как объекты класса
 *                    ContactModelImpl могут быть использованы вместо объектов интерфейса ContactModel
 *                    без изменения корректности программы.
 * Принцип разделения интерфейса ( ISP):
 *                   Реализует интерфейс ContactModel, который  определяет только необходимые методы
 *                   для управления контактами. Это соответствует ISP, так как классы, которые
 *                   используют ContactModelImpl, не зависят от неиспользуемых ими методов.
 * Принцип инверсии зависимостей ( DIP):
 *                   Зависит от абстракции ContactModel и Extension, а не от конкретных реализаций.
 *                   Это соответствует DIP, так как классы верхнего уровня не зависят от классов
 *                   нижнего уровня, а зависят от абстракций.
 */

// Реализация модели
public class ContactModelImpl<T extends Person> implements ContactModel<T>, Serializable {
    private List<T> contacts;

    private Extension extension;
    private ContactViewImpl<T> view;


    public ContactModelImpl() {
        contacts = new ArrayList<>();
        this.view = new ContactViewImpl<>();
        extension=Extension.DAT;
    }

    @Override
    public void getExtension() {
        this.view.displayExtension(extension);
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
    public void getAllContacts() {
        this.view.displayContacts(contacts);
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