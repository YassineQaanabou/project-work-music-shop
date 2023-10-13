package com.projectwork.shopstrumentimusicali.shop.api;

import com.projectwork.shopstrumentimusicali.shop.dto.TipologiaVenditaDto;
import com.projectwork.shopstrumentimusicali.shop.repository.AcquistoRepository;
import com.projectwork.shopstrumentimusicali.shop.service.AcquistoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/admin/api/")
public class AcquistoRestController {
    @Autowired
    private AcquistoRepository acquistoRepository;
    @Autowired
    private AcquistoService acquistoService;

    @GetMapping("/acquisti")
    public List<Object[]> scquistiList(@RequestParam("time") String time) {
        if (time.equals("2")) {
            LocalDate oggi = LocalDate.now();
            LocalDate mese = LocalDate.now().minusMonths(1);
            return acquistoService.findVenditeTotaliPerProdottoLastMonth(mese, oggi);
        } else if (time.equals("1")) {
            return acquistoService.findVenditeTotaliPerProdotto();

        } else {
            return acquistoService.findVenditeTotaliPerProdotto();
        }

    }

    @GetMapping("/acquisti-per-tipologia")
    public List<TipologiaVenditaDto> acquistiTimeList(@RequestParam("time") String time) {
        System.out.println(time);
        if (time.equals("2")) {
            LocalDate oggi = LocalDate.now();
            LocalDate mese = LocalDate.now().minusMonths(1);
            return acquistoService.findAcquistiPerTipologiaLastMonth(mese, oggi);
        } else if (time.equals("1")) {
            return acquistoService.findAcquistiPerTipologia();
        } else {
            return acquistoService.findAcquistiPerTipologia();

        }


    }


    // profitto e


}
