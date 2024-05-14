package com.modernfrontendshtmx.contactsapp;

public class ContactNotFoundException extends RuntimeException {

    public ContactNotFoundException(ContactId contactId) {
        super("Could not find contact with id " + contactId);
    }
}
