package com.projectwork.shopstrumentimusicali.shop.service;

import com.projectwork.shopstrumentimusicali.shop.model.Acquisto;
import com.projectwork.shopstrumentimusicali.shop.model.Assortimento;
import com.projectwork.shopstrumentimusicali.shop.repository.AcquistoRepository;
import com.projectwork.shopstrumentimusicali.shop.repository.AssortimentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class AdminService {
    @Autowired
    private AssortimentoRepository assortimentoRepository;
    @Autowired
    private AcquistoRepository acquistoRepository;

    public BigDecimal calculateTotalAssortimenti() {
        List<Assortimento> assortimentiList = assortimentoRepository.findAll();
        BigDecimal totaleAssortimenti = BigDecimal.ZERO;
        for (Assortimento a : assortimentiList) {
            totaleAssortimenti = totaleAssortimenti.add(a.getTotale());
        }
        return totaleAssortimenti;
    }

    public BigDecimal calculateTotalAcquisti() {
        List<Acquisto> acquistiList = acquistoRepository.findAll();
        BigDecimal totaleAcquisti = BigDecimal.ZERO;
        for (Acquisto a : acquistiList) {
            totaleAcquisti = totaleAcquisti.add(a.getStrumento().getPrezzo().multiply(BigDecimal.valueOf(a.getQuantity())));
        }
        return totaleAcquisti;
    }

    public BigDecimal calculateProfit() {
        BigDecimal totaleAssortimenti = calculateTotalAssortimenti();
        BigDecimal totaleAcquisti = calculateTotalAcquisti();
        return totaleAcquisti.subtract(totaleAssortimenti);
    }

    public int countVenditeTotali() {
        return acquistoRepository.findAll().size();
    }
}
