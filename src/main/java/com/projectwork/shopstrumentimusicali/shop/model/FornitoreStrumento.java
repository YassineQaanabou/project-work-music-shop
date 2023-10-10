package com.projectwork.shopstrumentimusicali.shop.model;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "fornitore_strumento")
public class FornitoreStrumento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "fornitore_id", nullable = false)
    private Fornitore fornitore;
    @ManyToOne
    @JoinColumn(name = "strumento_id", nullable = false)
    private Strumento strumento;

    private BigDecimal prezzo;

    public Integer getId() {
        return id;
    }

    public Fornitore getFornitore() {
        return fornitore;
    }

    public Strumento getStrumento() {
        return strumento;
    }

    public BigDecimal getPrezzo() {
        return prezzo;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setFornitore(Fornitore fornitore) {
        this.fornitore = fornitore;
    }

    public void setStrumento(Strumento strumento) {
        this.strumento = strumento;
    }

    public void setPrezzo(BigDecimal prezzo) {
        this.prezzo = prezzo;
    }
}
