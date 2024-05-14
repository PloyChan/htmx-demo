package com.modernfrontendshtmx.contactsapp;

import java.util.Locale;

public class Contact {
    private final ContactId id;
    private String givenName;
    private String familyName;
    private String phone;
    private String email;

    public Contact(ContactId id, String givenName, String familyName, String phone, String email) {
        this.id = id;
        this.givenName = givenName;
        this.familyName = familyName;
        this.phone = phone;
        this.email = email;
    }

    public ContactId getId() {
        return id;
    }

    public String getGivenName() {
        return givenName;
    }

    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public boolean hasName(String name) {
        return this.givenName.toLowerCase(Locale.ROOT).contains(name) ||
                this.familyName.toLowerCase(Locale.ROOT).contains(name);
    }
}
