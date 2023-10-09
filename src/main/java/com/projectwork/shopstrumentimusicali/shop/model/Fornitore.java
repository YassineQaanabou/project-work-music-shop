package com.projectwork.shopstrumentimusicali.shop.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Fornitore {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;

    @OneToMany(mappedBy = "fornitore")
    private List<FornitoreStrumento> fornitoreStrumento;

    @OneToMany(mappedBy = "fornitore")
    private List<Assortimento> assortimenti;

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public List<FornitoreStrumento> getFornitoreStrumento() {
        return fornitoreStrumento;
    }

    public List<Assortimento> getAssortimenti() {
        return assortimenti;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setFornitoreStrumento(List<FornitoreStrumento> fornitoreStrumento) {
        this.fornitoreStrumento = fornitoreStrumento;
    }

    public void setAssortimenti(List<Assortimento> assortimenti) {
        this.assortimenti = assortimenti;
    }
}
