package com.projectwork.shopstrumentimusicali.shop.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
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
    private int quantità;

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


    public int getQuantità() {
        return quantità;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setStrumento(Strumento strumento) {
        this.strumento = strumento;
    }



    public void setQuantità(int quantità) {
        this.quantità = quantità;
    }
}
