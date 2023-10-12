package com.projectwork.shopstrumentimusicali.shop.api;

import com.projectwork.shopstrumentimusicali.shop.dto.TipologiaVenditaDto;
import com.projectwork.shopstrumentimusicali.shop.model.Acquisto;
import com.projectwork.shopstrumentimusicali.shop.model.Tipologia;
import com.projectwork.shopstrumentimusicali.shop.repository.AcquistoRepository;
import com.projectwork.shopstrumentimusicali.shop.service.AcquistoService;
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
    @Autowired
    private AcquistoService acquistoService;
    @GetMapping("/acquisti")
    public List<Object[]> scquistiList(){
        return acquistoService.findVenditeTotaliPerProdotto();
    }

    @GetMapping("/acquisti-per-tipologia")
    public List<TipologiaVenditaDto> acquistiTimeList(){
        return acquistoService.findAcquistiPerTipologia();
    }

        // profitto e


}
