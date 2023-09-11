package com.romanovcopy.base;

import java.io.Serializable;

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
