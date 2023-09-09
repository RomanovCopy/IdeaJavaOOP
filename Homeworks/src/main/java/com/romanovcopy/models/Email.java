package com.romanovcopy.models;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Email {
    private String email;


    public Email(final String email) {
        this.email = email;
        if(validate(email)){
            System.out.println("Email успешно добавлен.");
        }
        else {
            System.out.println("Не удалось добавить Email.");
            return;
        }
    }

    public String getEmail() {
        return this.email;
    }
    public void setEmail(final String email) {
        this.email = email;
    }


    public boolean validate(String email) {
        Pattern pattern = Pattern.compile(EMAIL_REGEX);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

}
