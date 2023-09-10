package com.romanovcopy.models.base;

import com.romanovcopy.models.Email;
import com.romanovcopy.models.PhoneNumber;
import com.romanovcopy.models.PostalAddress;

import java.io.Serializable;

public class Person implements Serializable {
    private String nick;
    private String firstName;
    private String surName;
    private Email email;
    private PhoneNumber phoneNumber;
    private PostalAddress postalAddress;

    public Person(final String nick) {
        this.nick = nick;
    }

    public String getNick() {
        return this.nick;
    }
    public void setNick(final String nick) {
        this.nick = nick;
    }

    public String getFirstName() {
        return this.firstName;
    }
    public void setFirstName(final String firstName) {
        this.firstName = firstName;
    }

    public String getSurName() {
        return this.surName;
    }
    public void setSurName(final String surName) {
        this.surName = surName;
    }

    public Email getEmail() {
        return this.email;
    }
    public void setEmail(final Email email) {
        this.email = email;
    }

    public PhoneNumber getPhoneNumber() {
        return this.phoneNumber;
    }
    public void setPhoneNumber(final PhoneNumber phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public PostalAddress getPostalAddress() {
        return this.postalAddress;
    }
    public void setPostalAddress(final PostalAddress postalAddress) {
        this.postalAddress = postalAddress;
    }

}
