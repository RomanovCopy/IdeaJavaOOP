package com.romanovcopy.models;

import com.romanovcopy.models.interfaces.DataValidation;

import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Email implements DataValidation<String>, Serializable {
    private String email;


    public Email() { }

    public String getEmail() {
        return this.email;
    }
    public void setEmail(final String email) {
        this.email = validate(email)? email:this.email;
    }

    public boolean validate(String email) {
        Pattern pattern = Pattern.compile("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

}
