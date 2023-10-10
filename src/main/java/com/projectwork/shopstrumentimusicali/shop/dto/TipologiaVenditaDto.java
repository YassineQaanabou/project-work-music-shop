package com.projectwork.shopstrumentimusicali.shop.dto;

public class TipologiaVenditaDto {
    private String nome;
    private int quantity;

    public TipologiaVenditaDto(String nome, int quantity) {
        this.nome = nome;
        this.quantity = quantity;
    }

    public TipologiaVenditaDto() {
    }

    // g e s


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
