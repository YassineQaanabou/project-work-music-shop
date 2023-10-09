package com.projectwork.shopstrumentimusicali.shop.api;

import com.projectwork.shopstrumentimusicali.shop.model.Acquisto;
import com.projectwork.shopstrumentimusicali.shop.repository.AcquistoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("/acquisti-time-series")
    public List<Object[]> acquistiTimeList(){
        List<Object[]> acquisti =acquistoRepository.findVenditeGiornalierePerProdotto();
        return acquisti;
    }



}
