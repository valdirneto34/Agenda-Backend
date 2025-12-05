package com.example.valdir.dto;

import com.example.valdir.model.Contact;
import  lombok.Getter;

@Getter
public class ContactResponseDTO {
    private Long id;
    private String name;
    private String email;
    private String phone;

    public ContactResponseDTO(Contact contact) {
        this.id = contact.getId();
        this.name = contact.getName();
        this.email = contact.getEmail();
        this.phone = contact.getPhone();
    }

}