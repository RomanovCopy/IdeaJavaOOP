package com.romanovcopy.views;

import com.romanovcopy.base.Person;
import com.romanovcopy.interfaces.ContactView;
import com.romanovcopy.models.Extension;

import java.util.List;

/**
 * Данный класс удовлетворяет принципам SOLID, а именно:
 * Принципу единственной ответственности ( SRP):
 *                   Отвечает только за отображение контактов и сообщений об ошибках.
 *                   Он не содержит логики, связанной с обработкой данных или взаимодействием с базой данных.
 * Принципу открытости/закрытости ( OCP):
 *                  Класс можно расширить, добавив новые методы или функциональность, без
 *                  изменения существующего кода. Например, можно добавить новый метод
 *                  для отображения дополнительной информации о контакте.
 * Принципу подстановки Барбары Лисков ( LSP):
 *                  Класс может быть использован вместо любого другого класса,
 *                  реализующего интерфейс ContactView<T>.
 *                  Это гарантирует, что замена одной реализации на другую не нарушит работу программы.
 * Принципу разделения интерфейса ( ISP):
 *                  Класс реализует только необходимые методы интерфейса ContactView<T> и
 *                не имеет лишних методов. Это позволяет клиентскому коду использовать
 *                только те методы, которые ему нужны, и избегать зависимостей от неиспользуемых методов.
 * Принципу инверсии зависимостей ( DIP):
 *                Класс зависит от абстракции (интерфейса ContactView<T>), а не от конкретной реализации.
 *                Это позволяет легко заменить реализацию интерфейса без изменения кода класса.
 */

public class ContactViewImpl<T extends Person> implements ContactView<T> {

    @Override
    public void displayContacts(List<T> contacts) {
        for (T contact : contacts) {
            System.out.println(contact.getNick() + " - " + contact.getPhoneNumber());
        }
    }

    @Override
    public void displayExtension(Extension extension) {
        System.out.println(extension);
    }

    @Override
    public void displayErrorMessage(String message) {
        System.out.println("Ошибка: " + message);
    }

}
