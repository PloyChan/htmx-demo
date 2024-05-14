package com.modernfrontendshtmx.contactsapp;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Stream;

@Repository
public class InMemoryContactRepository implements ContactRepository {
    private final AtomicLong sequence = new AtomicLong();
    private final Map<ContactId,Contact> values = new HashMap<>();

    public InMemoryContactRepository() {
        Stream.of(new Contact(nextId(),
                                "Wim",
                                "Deblauwe",
                                "555-789-999",
                                "wim@example.com"),
                        new Contact(nextId(),
                                "John",
                                "Doe",
                                "555-123-456",
                                "john@example.com"),
                        new Contact(nextId(),
                                "Ada",
                                "Lovelace",
                                "555-873-321",
                                "ada@lovelace.com"))
                        .forEach(this::save);
//                .collect(Collectors.toMap(Contact::getId, Function.identity())));
    }

    @Override
    public ContactId nextId() {
        return new ContactId(this.sequence.incrementAndGet());
    }

    @Override
    public void save(Contact contact) {
        values.put(contact.getId(), contact);
    }

    @Override
    public List<Contact> findAll() {
        return List.copyOf(values.values());
    }

    @Override
    public List<Contact> findAllWithNameContaining(String query) {
        return values.values().stream()
                .filter(e -> e.hasName(query))
                .toList();
    }

    @Override
    public Optional<Contact> findById(ContactId contactId) {
        return Optional.ofNullable(values.get(contactId));
    }
}
