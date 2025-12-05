package com.example.valdir.service;

import com.example.valdir.dto.ContactRequestDTO;
import com.example.valdir.dto.ContactResponseDTO;
import com.example.valdir.model.Contact;
import com.example.valdir.repository.ContactRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ContactService {

    private final ContactRepository contactRepository;

    public ContactService(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    public List<ContactResponseDTO> getAll() {
        List<Contact> contacts = contactRepository.findAll();
        return contacts.stream()
                .map(ContactResponseDTO::new)
                .collect(Collectors.toList());
    }

    public ContactResponseDTO save(ContactRequestDTO dto) {
        Contact contact = new Contact();
        contact.setName(dto.getName());
        contact.setEmail(dto.getEmail());
        contact.setPhone(dto.getPhone());

        Contact savedContact = contactRepository.save(contact);

        return new ContactResponseDTO(savedContact);
    }

    public void delete(Long id) {
        contactRepository.deleteById(id);
    }
}