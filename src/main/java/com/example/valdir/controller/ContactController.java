package com.example.valdir.controller;

import com.example.valdir.dto.ContactRequestDTO;
import com.example.valdir.dto.ContactResponseDTO;
import com.example.valdir.service.ContactService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contacts")
@CrossOrigin(origins = "*")
public class ContactController {
    private final ContactService contactService;

    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @GetMapping
    public ResponseEntity<List<ContactResponseDTO>> getAll() {
        return ResponseEntity.ok(contactService.getAll());
    }

    @PostMapping
    public ResponseEntity<ContactResponseDTO> create(@RequestBody ContactRequestDTO dto) {
        ContactResponseDTO savedContact = contactService.save(dto);
        return new ResponseEntity<>(savedContact, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        contactService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
