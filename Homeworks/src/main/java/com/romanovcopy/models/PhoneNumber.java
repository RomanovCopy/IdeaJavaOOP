package com.romanovcopy.models;

import com.romanovcopy.models.interfaces.DataValidation;
import com.sun.source.tree.ReturnTree;

import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneNumber implements DataValidation<String>, Serializable {

    private String phoneNumber;


    public PhoneNumber() { }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setPhoneNumber(final String phoneNumber) {
        this.phoneNumber=validate(phoneNumber)?phoneNumber:this.phoneNumber;
    }

    @Override
    public boolean validate(String data) {
        Pattern pattern = Pattern.compile("^\\+\\d{1,3}\\s?\\d{1,3}\\s?\\d{3}\\s?\\d{2}\\s?\\d{2}$");
        Matcher matcher = pattern.matcher(data);
        return matcher.matches();

    }

}
