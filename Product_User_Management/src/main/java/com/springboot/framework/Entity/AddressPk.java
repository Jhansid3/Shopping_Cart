package com.springboot.framework.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

//A composite primary key, also called a composite key, is a combination of two or more columns to form a primary key for a table.
// https://www.baeldung.com/jpa-composite-primary-keys
@Embeddable
public class AddressPk implements Serializable {
   @Column(name="user_id")
    private int userId;

    private String street;

    private String city;

    private String state;

    public AddressPk(){

    }

    public AddressPk(int userId, String street, String city, String state) {
        this.userId = userId;
        this.street = street;
        this.city = city;
        this.state = state;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AddressPk addressPk = (AddressPk) o;
        return userId == addressPk.userId && Objects.equals(street, addressPk.street) && Objects.equals(city, addressPk.city) && Objects.equals(state, addressPk.state);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, street, city, state);
    }

    @Override
    public String toString() {
        return "AddressPk{" +
                "userId=" + userId +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                '}';
    }
}
