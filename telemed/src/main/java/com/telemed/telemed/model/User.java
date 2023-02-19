package com.telemed.telemed.model;

import jakarta.annotation.Nullable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.sql.Date;

@Entity(name = "APP_USER")
public class User {


    // kako bi spring, hibernate ili sto vec mogli
    public User() {

    }

    public User(String loginEmail, String loginPassword, int type) {
        this.loginEmail = loginEmail;
        this.loginPassword = loginPassword;
        this.type = type;
    }

    public User(String loginEmail, String loginPassword, String firstName, String lastName, String phoneNumber, String mbo) {
        this.loginEmail = loginEmail;
        this.loginPassword = loginPassword;
        this.firstName =firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.mbo = mbo;

    }

    @Id
    @GeneratedValue()
    private Long id;

    private String loginEmail;

    private String loginPassword;

    private int type = 1;
    @Nullable

    private String firstName;
    @Nullable

    private String lastName;

    @Nullable

    private String phoneNumber;

    @Nullable
    private String mbo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLoginEmail() {
        return loginEmail;
    }

    public void setLoginEmail(String loginEmail) {
        this.loginEmail = loginEmail;
    }

    public String getLoginPassword() {
        return loginPassword;
    }

    public void setLoginPassword(String loginPassword) {
        this.loginPassword = loginPassword;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }



    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getMbo() {
        return mbo;
    }

    public void setMbo(String mbo) {
        this.mbo = mbo;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", loginEmail='" + loginEmail + '\'' +
                ", loginPassword='" + loginPassword + '\'' +
                ", type=" + type +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", mbo=" + mbo +
                '}';
    }
}
