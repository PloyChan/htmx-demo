package com.modernfrontendshtmx.contactsapp;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactService {
    private final ContactRepository contactRepository;

    public ContactService(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }
    public List<Contact> getAll() {
        return contactRepository.findAll();
    }
    public Contact storeNewContact(String givenName, String familyName, String phone, String email) {
        Contact contact = new Contact(contactRepository.nextId(), givenName, familyName, phone, email);
        contactRepository.save(contact);
        return contact;
    }
    public List<Contact> searchContact(String query) {
        return contactRepository.findAllWithNameContaining(query);
    }
}
