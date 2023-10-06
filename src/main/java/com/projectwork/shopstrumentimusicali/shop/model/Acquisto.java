package com.projectwork.shopstrumentimusicali.shop.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Acquisto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "strumento_id", nullable = false)
    private Strumento strumento;
    @ManyToOne
    @JoinColumn(name = "utente_id", nullable = false)
    private Utente utente;
    @NotBlank
    private int quantità;

    public Acquisto(Strumento strumento, Utente utente, int quantità) {
        this.strumento = strumento;
        this.utente = utente;
        this.quantità = quantità;
    }

    public Acquisto() {
    }

    public Integer getId() {
        return id;
    }

    public Strumento getStrumento() {
        return strumento;
    }

    public Utente getUtente() {
        return utente;
    }

    public int getQuantità() {
        return quantità;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setStrumento(Strumento strumento) {
        this.strumento = strumento;
    }

    public void setUtente(Utente utente) {
        this.utente = utente;
    }

    public void setQuantità(int quantità) {
        this.quantità = quantità;
    }
}
