package com.modernfrontendshtmx.contactsapp;

import java.util.List;
import java.util.Optional;

public interface ContactRepository {
    ContactId nextId();
    void save(Contact contact);
    List<Contact> findAll();
    List<Contact> findAllWithNameContaining(String query);
    Optional<Contact> findById(ContactId contactId);
}
