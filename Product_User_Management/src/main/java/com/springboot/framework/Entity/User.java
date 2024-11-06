package com.springboot.framework.Entity;

import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;

import java.util.List;

@Entity
@Table(name="user")
public class User {
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private int user_id;
     private String firstname;
     private String lastname;
     @Column(name="pasword")
     private String password;
     private String email;
     private String mobile;
     @OneToMany(cascade=CascadeType.ALL,orphanRemoval=true)
     @Cascade(org.hibernate.annotations.CascadeType.DELETE_ORPHAN)
     @JoinColumn(name = "user_id",referencedColumnName = "user_id")
     private List<Address> addresses;


    public int getId() {
        return user_id;
    }

    public void setId(int user_id) {
        this.user_id = user_id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    @Override
    public String toString() {
        return "User{" +
                "user_id=" + user_id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", mobile='" + mobile + '\'' +
                ", addresses=" + addresses +
                '}';
    }
}
