package com.leads.ai.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Leads {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "Nome é obrigatório")
    private String nome;

    @Email(message = "E-mail inválido")
    @NotBlank(message = "e-mail é obrigatório")
    private String email;

    @NotBlank(message = "Proposta não pode esta vazia")
    private String proposta;

    public Leads() {
    }

    public Leads(int id, String nome, String email, String proposta) {
        this.id = id;
        this.proposta = proposta;
        this.email = email;
        this.nome = nome;
    }
}
