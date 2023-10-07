package com.projectwork.shopstrumentimusicali.shop.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class Assortimento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;

    private String nomeFornitore;
    @NotNull
    private int quantity;
    private BigDecimal totale;
    private LocalDate data;

    @ManyToOne
    @JoinColumn(name = "strumento_id", nullable = false)
    private Strumento strumento;

    // getter e setter


    public int getQuantity() {
        return quantity;
    }


    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomeFornitore() {
        return nomeFornitore;
    }

    public void setNomeFornitore(String nomeFornitore) {
        this.nomeFornitore = nomeFornitore;
    }

    public BigDecimal getTotale() {
        return totale;
    }

    public void setTotale(BigDecimal totale) {
        this.totale = totale;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public Strumento getStrumento() {
        return strumento;
    }

    public void setStrumento(Strumento strumento) {
        this.strumento = strumento;
    }
}
