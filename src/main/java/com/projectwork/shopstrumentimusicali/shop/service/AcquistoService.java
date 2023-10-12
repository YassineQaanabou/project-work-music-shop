package com.projectwork.shopstrumentimusicali.shop.service;

import com.projectwork.shopstrumentimusicali.shop.dto.TipologiaVenditaDto;
import com.projectwork.shopstrumentimusicali.shop.model.Tipologia;
import com.projectwork.shopstrumentimusicali.shop.repository.AcquistoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class AcquistoService {
    @Autowired
    private AcquistoRepository acquistoRepository;

    public List<Object[]> findVenditeTotaliPerProdotto() {
        return acquistoRepository.findVenditeTotaliPerProdotto();
    }

    public List<TipologiaVenditaDto> findAcquistiPerTipologia() {
        List<Object[]> risultati = acquistoRepository.findAcquistiPerTipologia();
        List<TipologiaVenditaDto> risultatiDTO = new ArrayList<>();

        for (Object[] riga : risultati) {
            Tipologia tipologia = (Tipologia) riga[0];
            String nomeTipologia = tipologia.getNome();
            int quantita = ((Long) riga[1]).intValue();
            TipologiaVenditaDto dto = new TipologiaVenditaDto(nomeTipologia, quantita);
            risultatiDTO.add(dto);
        }

        return risultatiDTO;
    }

    // last month
    public List<Object[]> findVenditeTotaliPerProdottoLastMonth(LocalDate startDate, LocalDate endDate) {
        return acquistoRepository.findVenditeTotaliPerProdottoLastMonth(startDate, endDate);
    }

    public List<TipologiaVenditaDto> findAcquistiPerTipologiaLastMonth(LocalDate startDate, LocalDate endDate) {
        List<Object[]> risultati = acquistoRepository.findAcquistiPerTipologiaLastMonth(startDate, endDate);
        List<TipologiaVenditaDto> risultatiDTO = new ArrayList<>();

        for (Object[] riga : risultati) {
            Tipologia tipologia = (Tipologia) riga[0];
            String nomeTipologia = tipologia.getNome();
            int quantita = ((Long) riga[1]).intValue();
            TipologiaVenditaDto dto = new TipologiaVenditaDto(nomeTipologia, quantita);
            risultatiDTO.add(dto);
        }

        return risultatiDTO;
    }


}
