package com.romanovcopy.controllers;

import com.romanovcopy.models.Contact;
import com.romanovcopy.models.base.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Data<T extends Person> {

    private List<T> contacts;
    private List<T>selectedContacts;

    public Data() {
        contacts=new ArrayList<>();
    }

    /**
     * коллекция выбранных контактов
     * @return коллекция контактов
     */
    public List<T> getSelectedContacts() {
        return this.selectedContacts;
    }

    /**
     * получение коллекции всех контактов
     * @return коллекция контактов
     */
    public List<T> getContacts() {
        return this.contacts;
    }

    /**
     * добавление контакта
     * @param contact добавляемый контакт
     * @return результат: True - успешно; False - ошибка
     */
    public boolean add(T contact){
        if(contact!=null){
            contacts.add(contact);
            return true;
        }
        return false;
    }

    /**
     * удаление контакта
     * @param contact удаляемый контакт
     * @return результат: True - успешно; False - ошибка
     */
    public boolean remove(T contact){
        if(contacts.contains(contact)){
            contacts.remove(contact);
            return true;
        }
        return false;
    }

    /**
     * поиск контактов с совпадениями в полях
     * @param tag искомая подстрока
     * @return массив контактов с совпадениями
     */
    public List<T> search(String tag){
        Predicate<T> containsTag = contact -> contact.getNick().toLowerCase().contains(tag.toLowerCase())
                || contact.getFirstName().toLowerCase().contains(tag.toLowerCase())
                || contact.getSurName().toLowerCase().contains(tag.toLowerCase())
                || contact.getEmail().getEmail().toLowerCase().contains(tag.toLowerCase())
                || contact.getPhoneNumber().getPhoneNumber().toLowerCase().contains(tag.toLowerCase());
        return contacts.stream().filter(containsTag).collect(Collectors.toList());
    }
}
