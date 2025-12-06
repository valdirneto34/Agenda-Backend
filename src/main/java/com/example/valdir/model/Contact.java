package com.example.valdir.model;

import jakarta.validation.constraints.Pattern;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "contacts")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Pattern(regexp = "^[a-zA-Z]+$", message = "Nome inválido. Use apenas letras.")
    @Column(nullable = false)
    private String name;

    @Pattern(regexp = "^[A-Za-z0-9]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$" , mensagem = "Formato de e-mail inválido" )
    @Column(nullable = false, unique = true)
    private String email;

    @Pattern(regexp = "^[0-9]+$", message = "Número inválido. Use apenas números.")
    private String phone;
}