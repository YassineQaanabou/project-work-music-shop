package com.projectwork.shopstrumentimusicali.shop.api;

import com.projectwork.shopstrumentimusicali.shop.dto.ProfittoDto;
import com.projectwork.shopstrumentimusicali.shop.model.Acquisto;
import com.projectwork.shopstrumentimusicali.shop.model.Assortimento;
import com.projectwork.shopstrumentimusicali.shop.repository.AcquistoRepository;
import com.projectwork.shopstrumentimusicali.shop.repository.AssortimentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@RestController
@RequestMapping("/admin/api")
public class ProfittoRestController {
    @Autowired
    private AssortimentoRepository assortimentoRepository;
    @Autowired
    private AcquistoRepository acquistoRepository;
    @GetMapping("/profitto")
    public List<ProfittoDto> getProfitto() {
        List<ProfittoDto> profittoList = new ArrayList<>();

        List<Assortimento> assortimenti = assortimentoRepository.findAll();
        List<Acquisto> acquisti = acquistoRepository.findAll();

        List<ProfittoDto> temporaryList = new ArrayList<>();

        for (Assortimento assortimento : assortimenti) {
            BigDecimal importoAssortimento = assortimento.getTotale();
            temporaryList.add(new ProfittoDto(assortimento.getData(), importoAssortimento.negate()));
        }

        for (Acquisto acquisto : acquisti) {
            BigDecimal importoVendita = acquisto.getStrumento().getPrezzo().multiply(BigDecimal.valueOf(acquisto.getQuantity()));
            temporaryList.add(new ProfittoDto(acquisto.getDataAcquisto(), importoVendita));
        }

        temporaryList.sort(Comparator.comparing(ProfittoDto::getData));

        BigDecimal profittoCumulativo = BigDecimal.ZERO;

        for (ProfittoDto entry : temporaryList) {
            profittoCumulativo = profittoCumulativo.add(entry.getProfittoCumulativo());
            entry.setProfittoCumulativo(profittoCumulativo);
            profittoList.add(entry);
        }

        return profittoList;
    }

}
