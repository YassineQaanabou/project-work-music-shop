package com.projectwork.shopstrumentimusicali.shop.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
public class Utente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank
    @Size(max = 100)
    private String nome;
    @NotBlank
    @Size(max = 100)
    private String cognome;
    @NotBlank
    @Size(max = 100)
    @Column(unique = true)
    private String email;

    private String password;
    private boolean registrato;
    // costruttori


    // getter e setter

    public boolean isRegistrato() {
        return registrato;
    }

    public void setRegistrato(boolean registrato) {
        this.registrato = registrato;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
