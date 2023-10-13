package com.projectwork.shopstrumentimusicali.shop.service;

import com.projectwork.shopstrumentimusicali.shop.model.Acquisto;
import com.projectwork.shopstrumentimusicali.shop.model.Assortimento;
import com.projectwork.shopstrumentimusicali.shop.repository.AcquistoRepository;
import com.projectwork.shopstrumentimusicali.shop.repository.AssortimentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
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

    public BigDecimal calculateTotalAssortimentiBetweenDates(LocalDate startDate, LocalDate endDate) {
        List<Assortimento> assortimentiList = assortimentoRepository.findByDataBetween(startDate, endDate);
        BigDecimal totaleAssortimenti = BigDecimal.ZERO;
        for (Assortimento a : assortimentiList) {
            totaleAssortimenti = totaleAssortimenti.add(a.getTotale());
        }
        return totaleAssortimenti;
    }

    public BigDecimal calculateTotalAcquistiBetweenDates(LocalDate startDate, LocalDate endDate) {
        List<Acquisto> acquistiList = acquistoRepository.findByDataAcquistoBetween(startDate, endDate);
        BigDecimal totaleAcquisti = BigDecimal.ZERO;
        for (Acquisto a : acquistiList) {
            totaleAcquisti = totaleAcquisti.add(a.getStrumento().getPrezzo().multiply(BigDecimal.valueOf(a.getQuantity())));
        }
        return totaleAcquisti;
    }

    public BigDecimal calculateProfitBetweenDates(LocalDate startDate, LocalDate endDate) {
        BigDecimal totaleAssortimenti = calculateTotalAssortimentiBetweenDates(startDate, endDate);
        BigDecimal totaleAcquisti = calculateTotalAcquistiBetweenDates(startDate, endDate);
        return totaleAcquisti.subtract(totaleAssortimenti);
    }

    public int countVenditeTotaliBetweenDates(LocalDate startDate, LocalDate endDate) {
        List<Acquisto> acquistiList = acquistoRepository.findByDataAcquistoBetween(startDate, endDate);
        return acquistiList.size();
    }


}
