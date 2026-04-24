package com.example.valdir.dto;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class ContactRequestDTO {

    @NotBlank(message = "Name is required")
    @Size(min = 3, message = "Name must have at least 3 characters")
    @Pattern(regexp = "^[\\p{L}\\s]+$", message = "Name must contain only letters and spaces")
    private String name;

    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email format")
    @Pattern(regexp = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$" , message = "Formato de e-mail inválido" )
    private String email;

    @NotBlank(message = "Phone is required")
    @Pattern(regexp = "^\\d{10,12}$", message = "Phone must contain only numbers (10 to 12 digits)")
    private String phone;
}