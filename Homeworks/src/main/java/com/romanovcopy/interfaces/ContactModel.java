package com.romanovcopy.interfaces;

import com.romanovcopy.base.Person;
import com.romanovcopy.models.Extension;

import java.util.List;

/**
 *Удовлетворяет нескольким принципам SOLID:
 * Принцип единственной ответственности ( SRP):
 *        Отвечает только за управление контактами и несет ответственность только
 *        за одну область функциональности - операции с контактами.
 * Принцип открытости/закрытости ( OCP):
 *        Позволяет добавлять новые типы контактов, расширяя обобщенный параметр T,
 *       без изменения существующего кода. Это позволяет классу быть открытым для
 *       расширения и закрытым для модификации.
 * Принцип подстановки Барбары Лисков ( LSP):
 *       Использует обобщенный тип T, который ограничен типом Person. Это означает,
 *       что любой подкласс Person может быть использован вместо базового класса без
 *       нарушения функциональности.
 * Принцип разделения интерфейса (ISP):
 *       Определяет только методы, связанные с управлением контактами. Не содержит
 *       методов, которые не используются в контексте контроллера контактов.
 *      Таким образом, интерфейс соответствует принципу ISP.
 * Принцип инверсии зависимостей ( DIP):
 *       Определяет абстракцию ContactModel, которая зависит от абстракции Person.
 *      Это позволяет классу быть независимым от конкретных реализаций Person и обеспечивает
 *      гибкость в использовании различных типов контактов.
 *
 *
 */

public interface ContactModel<T extends Person> {

    void getExtension();
    void setExtension(Extension extension);
    void addContact(T contact);
    void removeContact(T contact);
    void saveContacts(String fileName);
    void loadContacts(String fileName);
    void getAllContacts();
}
