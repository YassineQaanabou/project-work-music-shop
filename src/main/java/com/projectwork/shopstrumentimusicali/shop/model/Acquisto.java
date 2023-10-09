package com.projectwork.shopstrumentimusicali.shop.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

@Entity
public class Acquisto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "strumento_id", nullable = false)
    private Strumento strumento;

    @NotNull
    @Min(1)
    private int quantity;

    private LocalDate dataAcquisto;
    // getter e setter

    public LocalDate getDataAcquisto() {
        return dataAcquisto;
    }

    public void setDataAcquisto(LocalDate dataAcquisto) {
        this.dataAcquisto = dataAcquisto;
    }

    public Integer getId() {
        return id;
    }

    public Strumento getStrumento() {
        return strumento;
    }


    public void setId(Integer id) {
        this.id = id;
    }

    public void setStrumento(Strumento strumento) {
        this.strumento = strumento;
    }


    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
