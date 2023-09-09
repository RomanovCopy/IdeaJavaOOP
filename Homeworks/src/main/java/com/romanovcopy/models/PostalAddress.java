package com.romanovcopy.models;

import com.romanovcopy.models.interfaces.DataValidation;

import java.io.Serializable;

public class PostalAddress implements DataValidation<String>, Serializable {

    private String postalIndex;
    private String country;
    private String region;
    private String city;

    public PostalAddress() {
    }

    public String getPostalIndex() {
        return this.postalIndex;
    }
    public void setPostalIndex(final String postalIndex) {
        this.postalIndex = validate(postalIndex)? postalIndex:this.postalIndex;
    }

    public String getCountry() {
        return this.country;
    }
    public void setCountry(final String country) {
        this.country = validate(country)? country:this.country;
    }

    public String getRegion() {
        return this.region;
    }
    public void setRegion(final String region) {
        this.region = validate(region)? region:this.region;
    }

    public String getCity() {
        return this.city;
    }
    public void setCity(final String city) {
        this.city = validate(city)? city:this.city;
    }

    @Override
    public boolean validate(String data) {
        return data!=null&&data.length()>=3;
    }

}
