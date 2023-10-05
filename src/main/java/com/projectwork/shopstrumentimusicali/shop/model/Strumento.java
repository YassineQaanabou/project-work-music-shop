package com.projectwork.shopstrumentimusicali.shop.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;

@Entity
public class Strumento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name="tipologia_id", nullable=false)
    private Tipologia tipologia;
    @NotBlank
    @Size(max = 100)
    private String nome;

    @Size(max = 100)
    private String slug;
    @NotBlank
    @Size(max = 255)
    private String urlFoto;
    @NotBlank
    @Size(max = 255)
    private String descrizione;
    @NotNull
    @Min(0)
    private BigDecimal prezzo;

    public Strumento(Tipologia tipologia, String nome, String urlFoto, String descrizione, BigDecimal prezzo) {
        this.tipologia = tipologia;
        this.nome = nome;
        this.urlFoto = urlFoto;
        this.descrizione = descrizione;
        this.prezzo = prezzo;
    }

    public Strumento() {
    }

    public Integer getId() {
        return id;
    }

    public Tipologia getTipologia() {
        return tipologia;
    }

    public String getNome() {
        return nome;
    }

    public String getUrlFoto() {
        return urlFoto;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public BigDecimal getPrezzo() {
        return prezzo;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setTipologia(Tipologia tipologia) {
        this.tipologia = tipologia;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setUrlFoto(String urlFoto) {
        this.urlFoto = urlFoto;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public void setPrezzo(BigDecimal prezzo) {
        this.prezzo = prezzo;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }
}
