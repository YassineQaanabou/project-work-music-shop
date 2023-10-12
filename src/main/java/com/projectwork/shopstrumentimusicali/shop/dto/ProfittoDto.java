package com.projectwork.shopstrumentimusicali.shop.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ProfittoDto {
    private LocalDate data;
    private BigDecimal profittoCumulativo;

    public ProfittoDto(LocalDate data, BigDecimal profittoCumulativo) {
        this.data = data;
        this.profittoCumulativo = profittoCumulativo;
    }


    // Getter e Setter per data e profitto

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public BigDecimal getProfittoCumulativo() {
        return profittoCumulativo;
    }

    public void setProfittoCumulativo(BigDecimal profittoCumulativo) {
        this.profittoCumulativo = profittoCumulativo;
    }
}
