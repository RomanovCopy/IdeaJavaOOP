package com.romanovcopy.interfaces;

import com.romanovcopy.base.Person;
import com.romanovcopy.models.Extension;

import java.util.List;

/**
 * Данный интерфейс принципу единственной ответственности .
 *        Он определяет три метода, каждый из которых отвечает за конкретную
 *      ответственность:
 *            Метод displayContacts отображает список контактов типа T, где T является
 *            подтипом Person.
 *            Метод displayExtension отображает информацию о расширении.
 *            Метод displayErrorMessage отображает сообщение об ошибке.
 * Каждый метод выполняет только одну задачу, что соответствует принципу единственной ответственности.
 * Это позволяет легко понять, какие операции выполняет интерфейс и как их использовать.
 */

public interface ContactView<T extends Person> {
    void displayContacts(List<T> contacts);
    void displayExtension(Extension extension);
    void displayErrorMessage(String message);
}
