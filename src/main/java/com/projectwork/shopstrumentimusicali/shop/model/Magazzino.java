package com.projectwork.shopstrumentimusicali.shop.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;


@Entity
public class Magazzino {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

   private int quantity;

    @OneToOne
    private  Strumento strumento;
    // getter e setter


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Strumento getStrumento() {
        return strumento;
    }

    public void setStrumento(Strumento strumento) {
        this.strumento = strumento;
    }
}
