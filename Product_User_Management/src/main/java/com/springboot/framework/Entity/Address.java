package com.springboot.framework.Entity;

import jakarta.persistence.*;

@Entity
@Table(name="address")
public class Address {
    @EmbeddedId
    private AddressPk addressPk;
    private String country;
    private String zipcode;
//https://stackoverflow.com/questions/44266127/how-i-can-post-json-to-springboot-controller-with-embedded-in-embeddable-class
    public AddressPk getAddressPk() {
        return addressPk;
    }

    public void setAddressPk(AddressPk addressPk) {
        this.addressPk = addressPk;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    @Override
    public String toString() {
        return "Address{" +
                "addressPk=" + addressPk +
                ", country='" + country + '\'' +
                ", zipcode='" + zipcode + '\'' +
                '}';
    }
}
