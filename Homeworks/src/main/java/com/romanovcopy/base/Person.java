package com.romanovcopy.base;

import java.io.Serializable;

/**
 * Данный класс "Person" удовлетворяет нескольким принципам SOLID:
 * Принцип единственной ответственности (SRP):
 *               имеет только одну ответственность - представлять
 *              информацию о человеке и имеет только одну причину
 *             для изменения - изменение информации о человеке.
 * Принцип открытости/закрытости (OCP):
 *             нарушает принцип OCP, так как он не предоставляет
 *            возможность для расширения или изменения своего поведения.
 *            Однако, это  намеренное решение, т.к. он представляет базовую
 *            сущность, от которой могут наследоваться другие классы с
 *            дополнительной функциональностью.
 * Принцип подстановки Барбары Лисков (LSP):
 *          Класс "Person" не нарушает принцип LSP, так как он является базовым
 *          классом для других классов и все его подклассы взаимозаменяемы с "Person"
 *          без нарушения корректности программы.
 * Принцип разделения интерфейса (ISP):
 *         Класс "Person" не является интерфейсом, поэтому принцип ISP не применяется
 *         непосредственно к нему.
 * Принцип инверсии зависимостей (DIP):
 *          Класс "Person" не имеет явных зависимостей от других классов, поэтому принцип
 *       DIP не применяется непосредственно к нему.
 */

public class Person implements Serializable {
    private String nick;
    private String phoneNumber;

    public Person(final String nick, final String phoneNumber) {
        this.nick = nick;
        this.phoneNumber = phoneNumber;
    }


    public String getPhoneNumber() { return this.phoneNumber==null?"":this.phoneNumber; }
    public void setPhoneNumber(final String phoneNumber) { this.phoneNumber = phoneNumber; }

    public String getNick() {
        return this.nick==null?"":this.nick;
    }
    public void setNick(final String nick) {
        this.nick = nick;
    }


}
