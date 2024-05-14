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
    public Contact getContact(ContactId contactId) {
        return contactRepository.findById(contactId).orElseThrow(() -> new ContactNotFoundException(contactId));
    }
    public void updateContact(ContactId contactId, String givenName, String familyName, String phone, String email) {
        Contact contact = getContact(contactId);
        contact.setGivenName(givenName);
        contact.setFamilyName(familyName);
        contact.setPhone(phone);
        contact.setEmail(email);

        contactRepository.save(contact);
    }
    public void deleteContact(ContactId contactId) {
        contactRepository.deleteById(contactId);
    }
    public boolean contactWithEmailExists(String email) {
        return contactRepository.existsByEmail(email);
    }
    public Page<Contact> getAll(int page) {
        return contactRepository.findAllOrderedByName(page, 10);
    }
    public Page<Contact> searchContacts(String query,
                                        int page) {
        return contactRepository.findAllWithNameContaining(query,
                page,
                10);
    }
}
