package com.projectwork.shopstrumentimusicali.shop.api;

import com.projectwork.shopstrumentimusicali.shop.dto.TipologiaVenditaDto;
import com.projectwork.shopstrumentimusicali.shop.model.Acquisto;
import com.projectwork.shopstrumentimusicali.shop.model.Tipologia;
import com.projectwork.shopstrumentimusicali.shop.repository.AcquistoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/admin/api/")
public class AcquistoRestController {
    @Autowired
    private AcquistoRepository acquistoRepository;
    @GetMapping("/acquisti")
    public List<Object[]> scquistiList(){
        List<Object[]> acquisti = acquistoRepository.findVenditeTotaliPerProdotto();
        return acquisti;
    }

    @GetMapping("/acquisti-per-tipologia")
    public List<TipologiaVenditaDto> acquistiTimeList(){
        List<Object[]> risultati = acquistoRepository.findAcquistiPerTipologia();

        // Mappa i risultati nella lista di oggetti TipologiaVenditaDTO
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

        // profitto e


}
