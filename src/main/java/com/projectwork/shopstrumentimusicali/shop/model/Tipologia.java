package com.projectwork.shopstrumentimusicali.shop.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.List;

@Entity
public class Tipologia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank
    @Size(max = 100)
    private String nome;

    @Size(max = 100)
    private String slug;
    @OneToMany(mappedBy = "tipologia")
    private List<Strumento> strumenti;

    @NotBlank
    private String urlFoto;

    public Tipologia(String nome, String slug, List<Strumento> strumenti, String urlFoto) {
        this.nome = nome;
        this.slug = slug;
        this.strumenti = strumenti;
        this.urlFoto = urlFoto;
    }

    public Tipologia() {
    }

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public List<Strumento> getStrumenti() {
        return strumenti;
    }

    public String getUrlFoto() {
        return urlFoto;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setStrumenti(List<Strumento> strumenti) {
        this.strumenti = strumenti;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public void setUrlFoto(String fotoUrl) {
        this.urlFoto = urlFoto;
    }
}
